public class MinimumCostCalculator {

    public int calculateMinimumCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;

        int numberOfHouses = costs.length;
        int numberOfColors = costs[0].length;
        int[][] dp = new int[numberOfHouses][numberOfColors];

        for (int color = 0; color < numberOfColors; color++) {
            dp[0][color] = costs[0][color];
        }

        for (int house = 1; house < numberOfHouses; house++) {
            for (int currentColor = 0; currentColor < numberOfColors; currentColor++) {
                dp[house][currentColor] = Integer.MAX_VALUE;
                for (int previousColor = 0; previousColor < numberOfColors; previousColor++) {
                    if (currentColor == previousColor)
                        continue;
                    // Update the minimum cost for the current color
                    dp[house][currentColor] = Math.min(dp[house][currentColor], dp[house - 1][previousColor] + costs[house][currentColor]);
                }
            }
        }

        int resultMinimumCost = Integer.MAX_VALUE;
        for (int color = 0; color < numberOfColors; color++) {
            resultMinimumCost = Math.min(resultMinimumCost, dp[numberOfHouses - 1][color]);
        }

        return resultMinimumCost;
    }

    public static void main(String[] args) {
        MinimumCostCalculator calculator = new MinimumCostCalculator();
        int[][] costs = { { 1, 3, 2 }, { 4, 6, 8 }, { 3, 1, 5 } };
        System.out.println("Minimum cost: " + calculator.calculateMinimumCost(costs));
    }
}
