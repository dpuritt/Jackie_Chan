package com.uottawa.tournamentmaker;

/**
 * Created by Owner on 11/30/2015.
 */
public class Match {
    int scoreA = 0;
    int scoreB = 0;
    String teamA;
    String teamB;

    public Match(Team _teamA, Team _teamB){
        teamA = _teamA.getName();
        teamB = _teamB.getName();
    }

    public void setScore(int _scoreA, int _scoreB){
        scoreA = _scoreA;
        scoreB = _scoreB;
    }

    public String[] getTeams(){
        String[] res = new String[2];
        res[0] = teamA;
        res[1] = teamB;
        return res;
    }

    public int[] getScore(){
        int[] res = new int[2];
        res[0] = scoreA;
        res[1] = scoreB;
        return res;
    }

    public String getWinner(){
        if(scoreA > scoreB){
            return teamA;
        } else if(scoreA < scoreB){
            return teamB;
        } else {
            return "draw";
        }
    }
}
