import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
 * @author georgechou
 * @link https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> anagramsMap = new HashMap<>();

		for (String str : strs) {
			int[] count = new int[26];
			for (int i = 0; i < str.length(); i++) {
				count[str.charAt(i) - 'a']++;
			}

			// 字母 + 字母出现的次数作为 key
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				if (0 != count[i]) {
					sb.append('a' + i);
					sb.append(count[i]);
				}
			}

			List<String> orDefault = anagramsMap.getOrDefault(sb.toString(), new ArrayList<>());
			orDefault.add(str);
			anagramsMap.put(sb.toString(), orDefault);
		}

		return new ArrayList<>(anagramsMap.values());
	}
}
