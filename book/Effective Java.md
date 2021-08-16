## 创建和销毁对象
### 1. 考虑用静态工厂方法代替构造器
示例：
```java
public static Boolean valueOf(boolean b) {
    return b ? Boolean.TRUE : Boolean.FALSE;
}
```
静态工厂方法的好处：  
* 有名称
* 不必在每次调用它们的时候都创建一个新对象
* 可以返回原返回类型的任何子类型的对象
* 在创建参数化类型示例的时候，使代码变得更加简洁

### 2. 遇到多个构造器参数时考虑用构建器
调用方利用所有必要的参数调用构造器，得到一个 builder 对象，然后在 builder 对象上调用类似于 setter 的方法，来设置每个相关的可选参数，最后，调用无参的 build 方法来生成不可变的对象。

### 3. 用私有构造器或者枚举类型强化 Singleton 属性
实现 Singleton 的方法  
1. 共有静态成员是 final 域：
```java
public class Elvis() {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() { ... }

    public void leaveTheBuilding() { ... }
}
```

2. 公有的成员是个静态工厂方法：
```java
public class Elvis() {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() { ... }
    public static Elvis getInstance() { return INSTANCE; }

    public void leaveTheBuilding() { ... }
}
```

为了使上述实现的 Singleton 类变成可序列化的，需要提供一个 readResolve 方法
```java
private Object readResolve() {
    return INSTANCE;
}
```

3. 单元素的枚举类型
```java
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() { ... }
}
```

### 4. 通过私有构造器强化不可实例化的能力
在缺少显式构造器的情况下，编译器会自动提供一个公有的、无参的缺省构构造器。  
让类包含私有构造器，它就不能被实例化了：
```java
public class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }
}
```

### 5. 避免创建不必要的对象
1. 避免使用 `new String("xxx)` ;
2. 必要的对象可在初始化的时候创建
3. 使用基本类型

### 6. 消除过期的对象引用
* 类自己管理内存的情况下，就需要警惕内存泄露问题
* 缓存
* 监听器和其他回调

### 7. 避免使用终结方法
* 在 try-finally 结构中使用显式的终止方法