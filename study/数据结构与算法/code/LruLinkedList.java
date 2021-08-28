import java.util.LinkedList;
import java.util.List;

/**
 * @author georgechou
 * 使用链表实现 LRU 缓存淘汰算法
 */
public class LruLinkedList {
	/**
	 * 缓存列表
	 */
	private static List<String> cacheList;

	private static final int THRESHOLD = 10;

	/**
	 * 添加缓存
	 * @param value
	 */
	public static void addCache(String value) {
		if (null == cacheList) {
			cacheList = new LinkedList<>();
		}

		lru(value);
		cacheList.add(0, value);
	}

	/**
	 * LRU 缓存淘汰算法
	 * @param value
	 */
	private static void lru(String value) {
		// 时间复杂度 O(n)
		if (cacheList.contains(value)) {
			// 缓存中包含此数据，升级到队头（时间复杂度 O(1)）
			cacheList.remove(value);
		} else if (cacheList.size() >= THRESHOLD) {
			// 缓存已满，删除最近没有访问的数据
			cacheList.remove(THRESHOLD - 1);
		}
	}

	public static void main(String[] args) {
		addCache("test");
		addCache("zll");
		addCache("love");
		addCache("zz");
		addCache("heihei");
		addCache("hhh");
		addCache("singapore");
		addCache("lru");
		addCache("six");
		addCache("gad");
		addCache("test");
		addCache("heihei");
		addCache("lakers");
	}
}