import java.util.*;

class Pairs {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // absolute difference can't be negative

        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        int count = 0;

        for (int num : nums) {
            if (set.contains(num - k)) {
                seen.add(num - k);
            }
            if (set.contains(num + k)) {
                seen.add(num);
            }
            set.add(num);
        }
        return seen.size();
    }
}
