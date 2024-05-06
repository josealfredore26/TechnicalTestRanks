# Climbing the Leaderboard

This problem involves calculating Alice's ranks after each game played based on the given leaderboard scores and Alice's scores. The leaderboard uses Dense Ranking, where the player with the highest score is ranked number 1, and players with equal scores receive the same ranking number.
Pseudocode Overview

The pseudocode describes a method named climbingLeaderboard(scores, alice) that calculates Alice's ranks after each game. Here's a summary of the main steps:

    Initialize variables and data structures.
    Convert the leaderboard scores into a sorted set to eliminate duplicates and ensure descending order.
    Iterate over Alice's scores:
        Add Alice's score to the sorted set.
        Create a copy of the sorted set to avoid concurrent modification exceptions.
        Traverse the copied set to find Alice's rank:
            Compare Alice's score with each score in the set.
            Determine Alice's rank based on the position of her score relative to the set.
    Return Alice's ranks after each game.

## Input Format

### The input consists of:

    The number of players on the leaderboard (n).
    The leaderboard scores in descending order (scores).
    The number of games Alice plays (m).
    Alice's scores in ascending order (alice).

### Constraints

    1 <= n <= 2 * (10^5)
    1 <= m <= 2 * (10^5)
    0 <= scores[i] <= (10^9) for 0 <= i < n
    0 <= alice[j] <= (10^9) for 0 <= j < m
    The existing leaderboard, scores, is in descending order.
    Alice’s scores, alice, are in ascending order.

## Output Format

The output consists of m integers, each indicating Alice's rank after playing the corresponding game.# TechnicalTestRanks
