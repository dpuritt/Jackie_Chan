// Things left to do:
//Connect button methods to their actions



package com.uottawa.tournamentmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TournamentOptions extends AppCompatActivity {

    Tournament tournament; // Tournament that options holds onto to edit
    Boolean roundRobin = false;
    Boolean both = false; //if user selected both types
    Team[] teams;
    int teamCount = 0;
    int maxTeams = 32;
    String name;
    SaveManager sv;

    public TournamentOptions(Tournament _tournament){ // called if I am editing an existing tournament
        this.tournament = _tournament;
        this.roundRobin = _tournament.isRoundRobin();
        this.both = _tournament.isBoth();
        this.teams = _tournament.getTeams();
        this.name = _tournament.getName();
        for (int i = 0; i < teams.length; i ++)
            if (teams[i] != null) {
                teamCount++;
            }
    }
    public TournamentOptions(String name){ //called if first time editing a new tournament (if we choose to make user enter name when they create a tournament from main page)
        this.name = name;
        this.tournament = new Tournament(name, maxTeams);
        this.teams = new Team[maxTeams];
    }
    public TournamentOptions(){ //called if first time editing a new tournament (if we choose to make user edit name on tournament options page)
        this.name = "Default Tournament Name";
        this.tournament = new Tournament(name, maxTeams);
        this.teams = new Team[maxTeams];
    }


    public void onTournamentOptSetStyle(View v){

    }

    public void onSaveTournamentOpt(View v){
        //sets all the variables to the tournament object that it was passed
        tournament.setRoundRobin(roundRobin);
        tournament.setBoth(both);
        tournament.setTeams(teams);

        // Return back to main page or tournament view page (potentially return the tournament copy)
        sv.writeData(tournament);
        finish(); //returns to previous screen
    }
    public void onAddTeamTournamentOpt(View v){ // not sure if i need something other than View v to make this method be called and populate the list after
      if (teamCount+1 == maxTeams){
          // Filled possible list of teams
      }
        else{
          String defaultLocation = "No One Cares";
          String defaultName = ("Team "+ (teamCount+1));
          teams[teamCount] = new Team(defaultName, defaultLocation);
          teamCount ++;

          // populate list for user to see
      }
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_options);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerTO);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tournament_type, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        sv = MainPage.getSV();
        tournament = sv.loadData();

        roundRobin = tournament.isRoundRobin();
        both = tournament.isBoth(); //if user selected both types
        teams = tournament.getTeams();
        teamCount = 0;
        maxTeams = tournament.getNumTeams();
        name = tournament.getName();
    }
}
