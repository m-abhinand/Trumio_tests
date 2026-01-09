class Conveyor{
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        // find min and max capacity bounds
        for (int w : weights) {
            low = Math.max(low, w); // heaviest package
            high += w;              // sum of all packages
        }

        // binary search on capacity
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                high = mid;       // try smaller capacity
            } else {
                low = mid + 1;    // need bigger capacity
            }
        }
        return low;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int usedDays = 1;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                usedDays++;
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return usedDays <= days;
    }
}
