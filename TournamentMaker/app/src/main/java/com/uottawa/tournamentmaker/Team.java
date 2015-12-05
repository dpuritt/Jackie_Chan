package com.uottawa.tournamentmaker;

import java.io.Serializable;

/**
 * Created by Owner on 11/30/2015.
 */
public class Team implements Serializable {

    String name;
    int rank = -1;
    int logo = 0;
    String address;
    int gamesPlayed = 0;
    int gamesWon = 0;
    int gamesLost = 0;
    int gamesDrawn = 0;
    int points = 0;
    Boolean playing = true; //used for knock out tournament

    public Team(String _name, String _address){
        name = _name;
        address = _address;
    }

    /*set*/
    public void setName(String _name){
        name = _name;
    }

    public void setRank(int _rank){
        rank = _rank;
    }

    public void setAddress(String _address){
        address = _address;
    }

    public void setLogo(int _logo){ logo = _logo; }

    public void setGamesPlayed(int numPlayed){
        gamesPlayed = numPlayed;
    }

    public void setGamesWon(int numWon){
        gamesWon = numWon;
    }

    public void setGamesLost(int numLost){
        gamesLost = numLost;
    }

    public void setGamesDrawn(int numDrawn){
        gamesDrawn = numDrawn;
    }

    public void setPoints(int numPoints){
        points = numPoints;
    }

    public void setPlaying(Boolean p){
        playing = p;
    }
    /*get*/
    public String getName(){
        return name;
    }

    public int getRank(){
        return rank;
    }

    public int getLogo() { return logo; }

    public String getAddress(){
        return address;
    }

    public int getGamesPlayed(){
        return gamesPlayed;
    }

    public int getGamesWon(){
        return gamesWon;
    }

    public int getGamesLost(){
        return gamesLost;
    }

    public int getGamesDrawn(){
        return gamesDrawn;
    }

    public int getPoints(){
        return points;
    }

    public Boolean isPlaying(){
        return playing;
    }
  /*update methods*/

    public void updateGamesPlayed(){
        gamesPlayed++;
    }

    public void updateGamesWon(){
        gamesWon++;
    }

    public void updateGamesLost(){
        gamesLost++;
    }

    public void updateGamesDrawn(){
        gamesDrawn++;
    }

    public void updatePoints(String result){
        if (result.compareToIgnoreCase("win") == 0){
            points += 3;
        } else if (result.compareToIgnoreCase("draw") == 0){
            points += 1;
        } else {
            //lost
        }
    }
}
