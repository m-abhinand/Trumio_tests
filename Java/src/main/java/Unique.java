import java.util.*;

class Unique{
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // absolute difference can't be negative

        Map<Integer, Integer> map = new HashMap<>();

        // count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (int num : map.keySet()) {
            if (k == 0) {
                // need at least two same numbers
                if (map.get(num) > 1) {
                    count++;
                }
            } else {
                // check if num + k exists
                if (map.containsKey(num + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}
