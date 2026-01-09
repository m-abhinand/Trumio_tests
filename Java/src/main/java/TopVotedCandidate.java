import java.util.*;

class TopVotedCandidate {

    int[] times;
    int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[persons.length];

        Map<Integer, Integer> votes = new HashMap<>();
        int leader = -1;
        int maxVotes = 0;

        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            votes.put(p, votes.getOrDefault(p, 0) + 1);

            // tie goes to most recent vote
            if (votes.get(p) >= maxVotes) {
                leader = p;
                maxVotes = votes.get(p);
            }

            leaders[i] = leader;
        }
    }

    public int q(int t) {
        int left = 0, right = times.length - 1;

        // binary search for last time <= t
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (times[mid] <= t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return leaders[right];
    }
}
