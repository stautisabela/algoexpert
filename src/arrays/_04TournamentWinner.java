package arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class _04TournamentWinner {

    static final int HOME_TEAM_WON = 1;

    public static void main(String[] args) {

    }

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String bestTeam = "";
        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put(bestTeam, 0);

        for(int i = 0; i < competitions.size(); i++) {
            String homeTeam = competitions.get(i).get(0);
            String awayTeam = competitions.get(i).get(1);
            int result = results.get(i);

            String winningTeam = (result == HOME_TEAM_WON) ? homeTeam : awayTeam;
            updateScores(winningTeam, scores);
            if (scores.get(winningTeam) > scores.get(bestTeam)) {
                bestTeam = winningTeam;
            }
        }
        return bestTeam;
    }

    public static void updateScores(String team, HashMap<String, Integer> scores) {
        if (!scores.containsKey(team)) {
            scores.put(team, 0);
        }
        scores.put(team, scores.get(team) + 3);
    }
}
/*
There's an algorithms tournament taking place in which teams of programmers compete against each other to solve
algorithmic problems as fast as possible. Teams compete in a round robin, where each team faces off against all other
teams. Only two teams compete against each other at a time, and for each competition, one team is designated the home
team, while the other team is te away team. In each competition there's always one winner and one loser; there are no
ties. A team receives 3 points if it wins and 0 points if it loses. The winner of the tournament is the team that
receives the most amount of points.

Given an array of pairs representing the teams that have competed against each other and an array containing the results
of each competition, write a function that returns the winner and the tournament. The input arrays are named
competitions and results, respectively. The competitions array has elements in the form of [homeTeam, awayTeam], where
each team is a string of at most 30 characters representing the name of the team. The results array contains information
about the winner of each corresponding competition in the competitions array. Specifically, results[i] denotes the
winner of competitions[i], where 1 in the results array mean that the home team in the corresponding competition won and
a 0 means that the away team won.
 */