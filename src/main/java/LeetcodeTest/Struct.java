package LeetcodeTest;

import sun.font.AttributeMap;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;
import java.util.Queue;

public class Struct {
    public static void main(String[] args) {
        longestValidParentheses("(()");
    }

    public static int longestValidParentheses(String s) {
        BitSet bitSet = new BitSet(s.length());
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    bitSet.set(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            bitSet.set(stack.pop());
        }
        int result  = 0;
        int start = 0;
        while (start < bitSet.length()) {
            int end = bitSet.nextSetBit(start);
            result = Math.max(result, end - start);
            start = end+1;
        }
        return result;
    }

    /**
     * @Description: 接雨水
     * @Param:
     * @Author: ZAk
     */
    public int trap(int[] height) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int w = i - left - 1;
                int h = Math.min(height[i], height[left]) - height[top];
                result += w * h;
            }
            stack.push(i);
        }
        return result;
    }


}
