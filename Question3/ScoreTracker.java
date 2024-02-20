package Question3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreTracker {
    private List<Double> scores;

    // Constructor to initialize the list of scores
    public ScoreTracker() {
        scores = new ArrayList<>();
    }

    // Method to add a score to the list
    public void addScore(double score) {
        scores.add(score);
    }

    public double calculateMedianScore() {
        List<Double> sortedScores = new ArrayList<>(scores);
        Collections.sort(sortedScores);
        
        int size = sortedScores.size();
        if (size == 0) {
            return 0;
        } 
        else if (size % 2 == 0) {
            int mid = size / 2;
            return (sortedScores.get(mid - 1) + sortedScores.get(mid)) / 2.0;
        } 
        else {
            return sortedScores.get(size / 2);
        }
    }

    public static void main(String[] args) {
        // Create a ScoreTracker instance
        ScoreTracker scoreTracker = new ScoreTracker();
        
        // Add scores to the ScoreTracker
        scoreTracker.addScore(85.5);
        scoreTracker.addScore(92.3);
        scoreTracker.addScore(77.8);
        scoreTracker.addScore(90.1);
        
        // Calculate and print the median score
        double median1 = scoreTracker.calculateMedianScore();
        System.out.println("Median 1: " + median1);

        // Add more scores 
        scoreTracker.addScore(81.2);
        scoreTracker.addScore(88.7);
        double median2 = scoreTracker.calculateMedianScore();
        System.out.println("Median 2: " + median2);
    }
}
