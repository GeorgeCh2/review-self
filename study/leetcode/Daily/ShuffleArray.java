/**
 * 打乱数组
 * @author georgechou
 * @link https://leetcode-cn.com/problems/shuffle-an-array/
 */
public class ShuffleArray {
    int[] nums;
    int[] original;

    public Solution(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }
    
    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;

    }
    
    public int[] shuffle() {
        int[] shuffle = new int[nums.length];
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }

        // random 随机打乱
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            shuffle[i] = temp.remove(random.nextInt(nums.length));
        }

        System.arraycopy(shuffle, 0, nums, 0, shuffle.length);
        return nums;
    }
}