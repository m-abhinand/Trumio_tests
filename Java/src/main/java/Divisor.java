class Divisor{
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        // find max element
        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            int sum = 0;

            for (int num : nums) {
                sum += (num + mid - 1) / mid; // ceil division
            }

            if (sum > threshold) {
                low = mid + 1;   // divisor too small
            } else {
                high = mid;      // divisor works
            }
        }
        return low;
    }
}
