import java.util.PriorityQueue;

public class EngineBuilding {

    public static int findMinimumTimeToBuildEngines(int[] engines, int splitTime) {
        PriorityQueue<Integer> engineQueue = new PriorityQueue<>();

        for (int engine : engines) {
            engineQueue.offer(engine);
        }

        while (engineQueue.size() > 1) {
            int fastestEngine = engineQueue.poll();
            int secondFastestEngine = engineQueue.poll();

            int combinedBuildTime = secondFastestEngine + splitTime;

            engineQueue.offer(combinedBuildTime);
        }

        return engineQueue.poll();
    }

    public static void main(String[] args) {
        int[] engines = {5, 3, 7, 2, 8};
        int splitTime = 4;

        int totalTime = findMinimumTimeToBuildEngines(engines, splitTime);

        System.out.println("Minimum time to build all engines: " + totalTime);
    }
}
