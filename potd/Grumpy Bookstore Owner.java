// https://leetcode.com/problems/grumpy-bookstore-owner/
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        if (customers == null || customers.length == 0) {
            return 0;
        }
        if (minutes >= customers.length) {
            return Arrays.stream(customers).sum();
        }
        int count = 0;
        int start =0, end = 0;
        int maxUnsatisfied = Integer.MIN_VALUE;
        int currWindowSum = 0;

        int maxStart = 0;
        int maxEnd = 0;

        while (end < customers.length) {
            if (end - start + 1 > minutes) {
                if (grumpy[start] == 1)
                    currWindowSum -= customers[start];
                start++;
            }
            if (grumpy[end] == 1)
                currWindowSum += customers[end];

            if (maxUnsatisfied < currWindowSum) {
                maxUnsatisfied = currWindowSum;
                maxStart = start;
                maxEnd = end;
            }
            end++;
        }

        for (int index=0; index < customers.length; index++) {
            if ((index >= maxStart && index <= maxEnd) || grumpy[index] == 0) {
                count += customers[index];
            }
        }

        return count;
    }
}
