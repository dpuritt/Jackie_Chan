package com.uottawa.tournamentmaker;

/**
 * Created by Owner on 11/30/2015.
 */
public class Tournament {

    String name;
    Boolean started = false;
    Boolean roundRobin = false;
    Boolean both = false; //if user selected both types
    int numTeams = 0;
    Team[] teams;
    Match[] matches;
    int nextMatchIndex = 0;
    int teamsRemaining = 0;

    /*constructors*/
    public Tournament(String _name, int _numTeams){
        name = _name;
        numTeams = _numTeams;
        teams = new Team[numTeams];
//    for(int i = 0; i < numTeams; i++){
//      teams[i] = null;
//    }
    }

    public Tournament(String _name, Boolean _roundRobin, Boolean _both, int _numTeams){
        name = _name;
        roundRobin = _roundRobin;
        both = _both;
        numTeams = _numTeams;
        teams = new Team[numTeams];
        teamsRemaining = numTeams;
    }

    public void quickStart(String _name, Boolean _roundRobin, Boolean _both, int _numTeams){
        name = _name;
        roundRobin = _roundRobin;
        both = _both;
        numTeams = _numTeams;
        teamsRemaining = numTeams;
        teams = new Team[numTeams];

        for(int i = 0; i < numTeams; i++){
            int num = i + 1;
            teams[i] = new Team("Team " + num, "");
        }
    }

    /*set*/
    public void setName(String _name){
        name = _name;
    }

    public void setStarted(Boolean b){
        started = b;
    }

    public void setRoundRobin(Boolean b){
        roundRobin = b;
    }

    public void setBoth(Boolean b){
        both = b;
    }

    public void setTournamentType(Boolean _roundRobin, Boolean _both){
        roundRobin = _roundRobin;
        both = _both;
    }

    /*get*/
    public String getName(){
        return name;
    }

    public Team[] getTeams(){
        return teams;
    }

    public Boolean setTeams(Team[] teams){
        this.teams = teams;
        return true;
    }
    public Boolean hasStarted(){
        return started;
    }

    public Boolean isRoundRobin(){
        return roundRobin;
    }

    public Boolean isBoth(){
        return both;
    }

  /*functions*/

    //adds team to first available spot
    public Boolean addTeam(Team newTeam){
        for(int i = 0; i < numTeams; i++){
            if (teams[i] == null){
                teams[i] = newTeam;
                return true;
            }
        }
        return false; //failed to find spot
    }

    //sorts all teams by rank from highest score to lowest by quicksort
    public void updateRank(){
        quickSort(teams, 0, numTeams - 1);
        for(int i = 0; i < numTeams; i++){
            teams[i].setRank(i+1);
        }
    }

    private int partition(Team arr[], int left, int right){
        int i = left, j = right;
        Team tmp;
        int pivot = arr[(left + right) / 2].getPoints();

        while(i <= j){
            while(arr[i].getPoints() < pivot)
                i++;
            while(arr[j].getPoints() > pivot)
                j--;
            if(i <= j){
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };
        return i;
    }

    private void quickSort(Team arr[], int left, int right){
        int index = partition(arr, left, right);
        if(left < index - 1)
            quickSort(arr, left, index - 1);
        if(index < right)
            quickSort(arr, index, right);
    }

    //update teams remaining
    public void updateTeamsRemaining(){
        teamsRemaining /= 2;
    }

    //create roundrobin matches
    public void createRRMatches(){
        matches = new Match[numTeams*numTeams];
        for(int i = 0; i < numTeams; i++){
            for(int j = 0; i <numTeams; i++){
                if(i != j){
                    matches[i] = new Match(teams[i], teams[j]);
                }
            }
        }
    }

    //create KO matches
    public void updateKOMatches(){
        matches = new Match[teamsRemaining/2];
        for(int i = 0; i < numTeams/2; i++){
            for(int j = numTeams - 1; j >= numTeams/2; j--){
                if(i != j && teams[i].isPlaying() && teams[j].isPlaying()){
                    matches[i] = new Match(teams[i], teams[j]);
                }
            }
        }
    }



}
