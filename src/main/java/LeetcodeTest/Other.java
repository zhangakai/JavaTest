package LeetcodeTest;

public class Other {
    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        int index = nums.length-1;
        while (index > 0) {

            if (nums[index] > nums[index - 1]) {

                break;
            }
            index--;

        }
        int littleIndex = nums.length - 1;
        while (littleIndex > index) {
            if (nums[littleIndex] > nums[index]) {
                break;
            }
        }
        swap(nums, index, littleIndex);
        for (int i = index + 1, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private static void swap(int[] nums, int index, int littleIndex) {
        int temp = 0;
        temp = nums[littleIndex];
        nums[littleIndex] = nums[index];
        nums[index] = temp;
    }

    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] < length && nums[i] >= 1) {

            }
        }
        return -1;
    }
}
