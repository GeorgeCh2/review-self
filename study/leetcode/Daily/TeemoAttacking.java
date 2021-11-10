public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisonedDuration = 0, lastTime = timeSeries[0] + duration - 1;
        for (int i = 1; i < timeSeries.length; i++) {
            int series = timeSeries[i];
            if (lastTime >= series) {
                poisonedDuration += timeSeries[i] - timeSeries[i-1];
            } else {
                poisonedDuration += duration;
            }

            lastTime = timeSeries[i] + duration - 1;
        }

        return poisonedDuration + duration;
    }
}