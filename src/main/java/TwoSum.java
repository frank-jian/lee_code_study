import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: <p></p>
 * @author: terui
 * @date: 2019/9/8 6:58 下午
 */
public class TwoSum {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 特别注意: case需要覆盖全面 1）两个数字可能相同，需要考虑不能选择同一个元素;
     *
     */
    public int[] twoSum(int[] nums, int target) {
        for (int num : nums) {
            int twoNum = target - num;
            int oneIndex = getIndex(num, nums);
            int twoIndex = getLastIndex(twoNum, nums);
            if ( twoIndex != -1 && oneIndex != twoIndex) {
                return new int[]{oneIndex, twoIndex};
            }
        }
        return null;
    }

    private int getIndex(int target, int[] nums) {
        int n = 0;
        for (int num : nums) {
            if (num == target) {
                return n;
            }
            n = n + 1;
        }
        return -1;
    }

    private int getLastIndex(int target,int[] nums){
        int length = nums.length;
        for(int num = length -1; num >= 0; num --){
            int value = nums[num];
            if(value == target){
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = new TwoSum().twoSum(new int[]{3,3},6);
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
