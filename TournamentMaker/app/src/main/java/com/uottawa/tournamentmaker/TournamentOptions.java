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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TournamentOptions extends AppCompatActivity {

    //Tournament tournament; // Tournament that options holds onto to edit
    Boolean roundRobin = false;
    Boolean both = false; //if user selected both types
    Team[] teams;
    int teamCount = 0;
    int maxTeams = 32;
    String name;
    //final ListView editTeamList = (ListView) findViewById(R.id.listViewTournamentOptions);


    public TournamentOptions(Tournament _tournament){ // called if I am editing an existing tournament
        MainPage.tournament = _tournament;
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
        MainPage.tournament = new Tournament(name, maxTeams);
        this.teams = new Team[maxTeams];
    }
    public TournamentOptions(){ //called if first time editing a new tournament (if we choose to make user edit name on tournament options page)
        this.name = "Default Tournament Name";
        MainPage.tournament = new Tournament(name, maxTeams);
        this.teams = new Team[maxTeams];
    }


    public void onTournamentOptSetStyle(View v){

    }

    public void onSaveTournamentOpt(View v){
        //sets all the variables to the tournament object that it was passed
        MainPage.tournament.setRoundRobin(roundRobin);
        MainPage. tournament.setBoth(both);
        MainPage.tournament.setTeams(teams);

        // Return back to main page or tournament view page (potentially return the tournament copy)
        MainPage.sv.writeData(MainPage.tournament);
        finish(); //returns to previous screen
    }
    public void onAddTeamTournamentOpt(View v){ // not sure if i need something other than View v to make this method be called and populate the list after

          String defaultLocation = "No One Cares";
          String defaultName = ("Team "+ (teamCount+1));
        Team newTeam = new Team(defaultName, defaultLocation);
        MainPage.tournament.addTeam(newTeam);

          ListView lv = (ListView) findViewById(R.id.listViewTournamentOptions);
          ArrayList <String> teamList = new ArrayList<String>();

          for(int i = 0; i < teams.length; i++){
              teamList.add(teams[i].getName());
//              teamList.add("hello");
//              teamList.add("hello");
//              teamList.add("hello");
          }

          ArrayAdapter<String> teamListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamList);
          lv.setAdapter(teamListAdapter);

    }

    public void onEditTeamListTournamentOptions(View v) {
/*
        editTeamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long myLong) {
                String selectedFromList = (String)(editTeamList.getItemAtPosition(myItemInt));
            }
        });
*/
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_options);

        MainPage.tournament = MainPage.sv.loadData();

        roundRobin = MainPage.tournament.isRoundRobin();
        both = MainPage.tournament.isBoth(); //if user selected both types
        teams = MainPage.tournament.getTeams();
        teamCount = 0;
        maxTeams = MainPage.tournament.getNumTeams();
        name = MainPage.tournament.getName();



        Spinner spinner = (Spinner) findViewById(R.id.spinnerTO);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tournament_type, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner

        spinner.setAdapter(adapter);



        ListView lv = (ListView) findViewById(R.id.listViewTournamentOptions);
        ArrayList <String> teamList = new ArrayList<String>();

        for(int i = 0; i < teams.length; i++){
            teamList.add(teams[i].getName());
            System.out.println(teams[i].getName());
        }
        System.out.println(teams.length);

//            teamList.add("Team 1");
//        teamList.add("Team 2");
//        teamList.add("Team 3");
//        teamList.add("Team 4");
//        teamList.add("Team 5");
//        teamList.add("Team 6");
//        teamList.add("Team 7");
//        teamList.add("Team 8");
//        teamList.add("Team 9");
//        teamList.add("Team 10");
//        teamList.add("Team 12");
//        teamList.add("Team 13");
//        teamList.add("Team 14");
//        teamList.add("Team 15");
//        teamList.add("Team 16");


        ArrayAdapter<String> teamListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamList);
        lv.setAdapter(teamListAdapter);
    }
}
