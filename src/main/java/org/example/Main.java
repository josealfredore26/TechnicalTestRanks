package org.example;

import java.util.*;


public class Main {

    /**
     * Calculates the ranks of Alice after each game based on the given leaderboard scores and Alice's scores.
     * @param scores An array representing the scores on the leaderboard, ordered in descending order.
     * @param alice An array representing Alice's scores, ordered in ascending order.
     * @return An array containing Alice's ranks after each game.
     */
    public static int[] climbingLeaderboard(int[] scores, int[] alice) {
        // Initialize variables
        int m = alice.length; // Number of games Alice plays
        int[] ranks = new int[m]; // Array to store Alice's ranks

        // Create a TreeSet to store unique scores from the leaderboard in descending order
        TreeSet<Integer> scoreSet = new TreeSet<>();
        for (int score : scores) {
            scoreSet.add(score);
        }

        // Calculate Alice's ranks for each game
        for (int i = 0; i < m; i++) {
            int aliceScore = alice[i]; // Current score of Alice
            scoreSet.add(aliceScore); // Add Alice's score to the TreeSet
            System.out.println("aliceScore = " + aliceScore);
            System.out.println(scoreSet.toString());

            // Create a copy of the TreeSet to avoid ConcurrentModificationException
            TreeSet<Integer> tempSet = new TreeSet<>(scoreSet);

            // Initialize a descending iterator to traverse the temporary TreeSet
            Iterator<Integer> descendingIterator = tempSet.descendingIterator();

            // Traverse the temporary TreeSet to find Alice's rank
            int rank = 1; // Initialize rank to 1
            int prevScore = -1; // Initialize previous score to -1
            while (descendingIterator.hasNext()) {
                int currentScore = descendingIterator.next(); // Current score in the TreeSet
                if (currentScore == aliceScore) {
                    if(currentScore == tempSet.stream().max(Integer::compare).get()) {
                        ranks[i] = rank; // Assign Alice's rank
                    } else {
                        ranks[i] = rank+1; // Assign Alice's rank
                    }
                    break;
                }
                if (currentScore < prevScore) {
                    rank++; // Increment rank if the current score is less than the previous one
                }
                prevScore = currentScore; // Update the previous score
                System.out.println("Rank fallido = " + rank);
            }
            System.out.println("rank = " + ranks[i]);
        }

        return ranks; // Return Alice's ranks after each game
    }



    /**
     * Reads the input, verifies constraints, calculates Alice's ranks, and displays them.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of players on the leaderboard
        int n = scanner.nextInt();
        // Verify input size constraints
        if (n < 1 || n > 2 * Math.pow(10, 5)) {
            throw new IllegalArgumentException("The number of players is not within the allowed range.");
        }

        // Read the leaderboard scores
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
            // Verify that scores are within the allowed range
            if (scores[i] < 0 || scores[i] > Math.pow(10, 9)) {
                throw new IllegalArgumentException("The scores on the leaderboard are not within the allowed range.");
            }
        }
        // Verify that scores are in descending order
        for (int i = 1; i < n; i++) {
            if (scores[i] > scores[i - 1]) {
                throw new IllegalArgumentException("The scores on the leaderboard are not in descending order.");
            }
        }

        // Read the number of games Alice plays
        int m = scanner.nextInt();
        // Verify input size constraints
        if (m < 1 || m > 2 * Math.pow(10, 5)) {
            throw new IllegalArgumentException("The number of games Alice plays is not within the allowed range.");
        }

        // Read Alice's scores
        int[] alice = new int[m];
        for (int i = 0; i < m; i++) {
            alice[i] = scanner.nextInt();
            // Verify that Alice's scores are within the allowed range
            if (alice[i] < 0 || alice[i] > Math.pow(10, 9)) {
                throw new IllegalArgumentException("Alice's scores are not within the allowed range.");
            }
        }
        // Verify that Alice's scores are in ascending order
        for (int i = 1; i < m; i++) {
            if (alice[i] < alice[i - 1]) {
                throw new IllegalArgumentException("Alice's scores are not in ascending order.");
            }
        }

        // Calculate Alice's ranks and display them
        int[] result = climbingLeaderboard(scores, alice);
        for (int rank : result) {
            System.out.println(rank);
        }

        scanner.close();
    }
}