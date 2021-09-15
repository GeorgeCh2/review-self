![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5863176a-ec67-4299-9041-a7c5cbc3a540/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5863176a-ec67-4299-9041-a7c5cbc3a540/Untitled.png)

## 乐观锁 VS 悲观锁

对于同一个数据的并发操作，悲观锁认为自己在使用数据的时候一定有别的线程来修改数据，因此在获取数据的时候会先加锁，确保数据不会被别的线程修改。Java 中，synchronized 关键字和 Lock 的实现类都是悲观锁。

而乐观锁认为自己在使用数据时不会有别的线程修改数据，所以不会添加锁，只是在更新数据的时候去判断之前有没有别的线程更新了这个数据。乐观锁在 Java 中是通过无锁编程来实现，最常采用的是 CAS 算法，Java 原子类中的递增操作就通过 CAS 自旋实现。

- 悲观锁适合写操作多的场景，先加锁可以保证写操作时数据正确。
- 乐观锁适合读操作多的场景，不加锁的特点能够使其读操作的性能大幅提升。

**调用方式示例：**

```java
// ------------------------- 悲观锁的调用方式 -------------------------
// synchronized
public synchronized void testMethod() {
	// 操作同步资源
}
// ReentrantLock
private ReentrantLock lock = new ReentrantLock(); // 需要保证多个线程使用的是同一个锁
public void modifyPublicResources() {
	lock.lock();
	// 操作同步资源
	lock.unlock();
}

// ------------------------- 乐观锁的调用方式 -------------------------
private AtomicInteger atomicInteger = new AtomicInteger();  // 需要保证多个线程使用的是同一个AtomicInteger
atomicInteger.incrementAndGet(); //执行自增1
```

CAS 全称 Compare And Swap，是一种无锁算法。在不使用锁的情况下实现多线程之间的变量同步。

**原子类 AtomicInteger 源码（CAS）：**

```java
// AtomicInteger 自增方法
public final int incrementAndGet() {
    return unsafe.getAndAddInt(this, valueOffset, 1) + 1;
}

// Unsafe.class
public final int getAndAddInt(Object var1, long var2, int var4) {
    int var5;
    do {
        var5 = this.getIntVolatile(var1, var2);
    } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

    return var5;
}
```

通过源码可以看到实际是通过 Unsafe 的 getAndAddInt() 实现自增。Unsafe 内部是通过循环获取给定对象 var1 中的偏移量处的值 var5，然后判断内存值是否等于 var5。如果先等则将内存值设置为 v+delta，否则返回 false，继续循环进行重试，直到设置成功才能退出循环，并且将旧值返回。整个“比较+更新”操作封装在 compareAndSwapIn() 中，在 JNI 里是借助一个 CPU 指令完成的，属于原子操作，可以保证多个线程都能够看到同一个变量的修改值。

**CAS 存在的问题：**

1. ABA 问题
2. 循环实际长开销大
3. 只能保证一个共享变量的原子操作

## 自旋锁 VS 适应性自旋锁

阻塞或唤醒一个 Java 线程需要操作系统切换 CPU 状态来完成，这种状态转换需要耗费处理器时间。如果同步代码块中的内容过于简单，状态转换消耗的时间有可能比用户代码执行的时间还要长。

在许多场景中，同步资源的锁定时间很短，为了让这一小段时间去切换线程，线程挂起和恢复现场的花费可能会让系统得不偿失。

让当前线程进行自旋，如果在自旋完成后前面锁定同步资源的线程已经释放了锁，那么当前线程就可以不必阻塞而是直接获取同步资源，从而避免线程的开销。这就是**自旋锁**。

自旋锁的本身是有缺点的，它**不能代替阻塞**。自旋等待虽然避免了线程切换的开销，但它要占用处理器时间。如果锁被占用的时间很短，自旋等待的效果就会非常好。反之，如果锁被占用的时间很长，那么自旋的线程只会白浪费处理器时间。

自旋锁的实现原理同样也是 CAS，AtomicInteger 中调用 unsafe 进行自增操作的源码中的 do-while 循环就是一个自旋操作

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9ac87d97-ac8d-416b-ac9b-cc9bda5d2f72/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9ac87d97-ac8d-416b-ac9b-cc9bda5d2f72/Untitled.png)

自适应意味着自旋的时间（次数）不再固定，而是由前一次在**同一个锁上的自旋时间及锁的拥有者的状态来决定**。如果在同一个锁对象上，自旋等待刚刚成功获得过锁，并且持有锁的线程正在运行中，那么虚拟机就会认为这次自旋也是很有可能再次成功，进而它将允许自旋等待持续相对更长的时间。如果对于某个锁，自旋很少成功获得过，那么以后尝试获取这个锁时将可能**省略掉自旋过程**，直接阻塞线程，避免浪费处理器资源。

## 无锁 VS 偏向锁 VS 轻量级锁 VS 重量级锁

这四种锁是指锁的状态，专门针对 **synchronized** 的。

首先为什么 Synchronized 能实现线程同步？

需要了解两个重要的概念：“Java 对象头”、“Monitor”

### Java 对象头

以 Hotspot 虚拟机为例，Hotspot 的对象头注意包括两部分数据：Mark Word（标记字段）、Klass Pointer（类型指针）。

**Mark Word**：默认存储对象的 HashCode，分代年龄和锁标识位信息。这些信息都是与对象自身定义无关的数据，在运行期间 Mark Word 里存储的数据会随着锁标志位的变化而变化。

**Klass Point**：对象指向它的类元数据的指针，虚拟机通过这个指针来确定这个对象是哪个类的实例。

### Monitor

Monitor 可以理解为一个同步工具或一种同步机制，通常被描述为一个对象。每一个 Java 对象就有一把看不见的锁，成为内部锁或者 Monitor 锁。

Monitor 是线程私有的数据结构，每一个线程都有一个可用 monitor record 列表，同时还有一个全局的可用列表。每一个被锁住的对象都会和一个 monitor 关联，同时 monitor 中有一个 Owner 字段存放拥有该锁的线程的唯一标识，表示该锁被这个线程占用。

synchronized 通过 Monitor 来实现**线程同步**，Monitor 是依赖于底层的操作系统的 **Mutex Lock**（互斥锁）来显示线程同步。

阻塞或唤醒一个 Java 线程依赖于操作系统 Mutex Lock 所实现的锁称之为 “重量级锁”，JDK 6 中为了减少获得锁和释放锁带来的性能消耗，引入了 “偏向锁” 和 “轻量级锁”。

级别从低到高的锁依次是：无锁、偏向锁、轻量级锁和重量级锁。锁状态只能升级不能降级。

四种锁状态对应的 Mark Word 内容：

[Untitled](https://www.notion.so/0fb34415cd3a42a8af959ce0dbe2718c)

### 无锁

无锁没有对资源进行锁定，所有的线程都能访问并修改同一个资源，但同时只有一个线程能修改成功。（CAS）

无锁无法全面代替有锁，但无锁在某些场合下的性能是非常高的。

### 偏向锁

偏向锁是指一段同步代码一直被一个线程所访问，那么该线程会自动获取锁，降低获取锁的代价。

在大多数情况下，锁总是由同一个线程多次获得，不存在多线程竞争，所以出现了偏向锁。其目标就是在只有一个线程执行同步代码块时能够提高性能。

当一个线程访问同步代码块并获取锁时，会在 Mark Word 里**存储锁偏向的线程ID**。在线程进入和退出同步块时不再通过 CAS 操作来加锁和解锁，而是检测 Mark Word 里是否存储着指向当前线程的偏向锁。偏向锁只需要在**置换 ThreadID** 的时候依赖依次 CAS 原子指令即可。

偏向锁只有遇到其它线程尝试**竞争偏向锁**时，持有偏向锁的线程才会释放锁，线程不会主动释放偏向锁。偏向锁的撤销，需要等待**全局安全点**（在这个时间点上没有字节码正在执行），它会首先暂停拥有偏向锁的线程，判断锁对象是否处于被锁定状态。撤销偏向锁后恢复到无锁或轻量级锁的状态。

### 轻量级锁

当锁是偏向锁的时候，被另外的线程所访问，偏向锁就会升级为轻量级锁，其他线程会通过**自旋**的形式尝试获取锁，不会阻塞，从而提高性能。

在代码块进入同步块的时候，如果同步对象锁状态为无锁状态，虚拟机首先将在当前线程的栈帧中建立一个名为**锁记录（Lock Record）**的空间，用于存储锁对象目前的 Mark Word 的拷贝，然后拷贝对象头中的 Mark Word 复制到锁记录中。

拷贝成功后，虚拟机将使用 CAS 操作尝试将对象的 Mark Word 更新指向 Lock Record 的指针，并将 Lock Record 里的 owner 指针指向对象的 Mark Word。

如果这个更新动作成功了，那么这个线程就拥有了该对象的锁，并且对象  Mark Word 的锁标志位设置为 “00”，表示该对象处于轻量级锁定状态。

如果轻量级锁的更新操作失败了，虚拟机首先检查对象的 Mark Word 是否指向当前线程的栈帧，如果是说明当前线程已经拥有了这个对象的锁，那么就可以直接进入同步块继续执行，否则说明多个线程竞争锁。

若当前只有一个等待线程，则该线程通过自旋进行等待。但是当自旋超过一定的次数，或者一个线程在持有锁，一个在自旋，又有第三个来访时，轻量级锁升级为重量级锁。

### 重量级锁

升级为重量级锁时，此时 Mark Word 中存储的时指向重量级锁的指针，此时等待锁的线程都会进入阻塞状态。

综上，偏向锁通过对象 Mark Word 解决加锁问题，避免执行 CAS 操作。而轻量级锁时通过用 CAS 操作和自旋来解决加锁问题，避免线程阻塞和唤醒而影响性能。重量级锁是将除了拥有锁的线程以外的线程都阻塞。

## 公平锁 VS 非公平锁

公平锁是指多个线程按照申请锁的顺序来获取锁，线程直接进入队列中排队，队列中的第一个线程才能获得锁。优点是等待锁的线程不会饿死，缺点是整体吞吐效率相对于非公平锁要低，等待队列中除第一个线程以外的所有线程都会阻塞，CPU唤醒阻塞线程的开销比非公平锁大。

非公平锁是多个线程加锁时直接尝试获取锁，获取不到才会到等待队列的队尾等待。

**ReentrantLocak 中的公平锁和非公平锁：**

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3a1f5ac9-a589-4db3-bb60-d0f99feb0351/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3a1f5ac9-a589-4db3-bb60-d0f99feb0351/Untitled.png)

ReentrantLock 里面有一个内部类 Sync，Sync 继承 AQS（AbstractQueuedSynchroinzer），添加锁和释放锁的大部分操作实际上都是在 Sync 中实现的。它有公平锁 FairSync 和非公平锁 NonfairSync 两个子类。ReentrantLock 默认使用非公平锁。

公平锁和非公平锁的加锁方法：

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4440ad71-4d42-456d-afac-5946155812b9/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4440ad71-4d42-456d-afac-5946155812b9/Untitled.png)

公平锁于非公平锁的 lock() 方法唯一的区别就在于公平锁在获取同步状态时多了一个限制条件：hasQueuedPredecessors(): 判断当前线程是否位于同步队列中的第一个

## 可重入锁 VS 非可重入锁