/**
 * @author georgechou
 * 使用数组实现 LRU 缓存淘汰算法
 */
public class LruArray {
	/**
	 * cache 数组
	 */
	private static String[] cacheArray = new String[10];

	private static final int THRESHOLD = 10;

	public static void addCache(String value) {
		lru(value);
		cacheArray[0] = value;
	}

	private static void lru(String value) {
		int index = indexOf(value);
		index = index == -1 ? THRESHOLD-1 : index;

        // 留出队头的位置
		for (int i = index; i > 0; i--) {
			cacheArray[i] = cacheArray[i-1];
		}
	}

	/**
	 * 获取 value 在 cacheArray 中的索引
	 * @param value
	 * @return
	 */
	private static int indexOf(String value) {
		if (null == value) {
			for (int i = 0; i < THRESHOLD; i++) {
				if (null == cacheArray[i]) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < THRESHOLD; i++) {
				if (value.equals(cacheArray[i])) {
					return i;
				}
			}
		}

		return -1;
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