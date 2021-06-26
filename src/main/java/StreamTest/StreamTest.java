package StreamTest;

import java.util.Arrays;

public class StreamTest {
    public static void main(String[] args) {
        int[] nums = new int[2048];
        for (int i = 0; i < 2048; i++) {
            nums[i]=i;
        }
        Arrays.stream(nums)
                .map(i -> i * 2)
                .sum();
    }
}
