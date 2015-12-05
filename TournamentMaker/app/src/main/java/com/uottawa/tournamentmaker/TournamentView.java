package com.uottawa.tournamentmaker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TournamentView extends AppCompatActivity {
//Things to do:
    //
    // The UI for edit Score / Match Edit needs to be built
    Tournament tournament; //tournament object to do stuff with

    public void onViewScoreboardTournamentView(View v){
        startActivity(new Intent(TournamentView.this, Scoreboard.class));
    }
    public void onEditTournamentTournamentView(View v){
        if(tournament.hasStarted()==false) {
            Intent i = new Intent(TournamentView.this, TournamentOptions.class);
            startActivity(i);
        }
        else{

            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_NEUTRAL:
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Tournament has been started and can no longer be edited.").setNeutralButton("Cancel", dialogClickListener).show();

        }
    }

    public void onStartTournamentTournamentView(View v){
        if(tournament.hasStarted()==false) {
            tournament.setStarted(true);
        }
        else{

            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_NEUTRAL:
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Tournament has already been started.").setNeutralButton("Cancel", dialogClickListener).show();
        }
    }
    public void onEditScoreTournamentView(View v){
        startActivity(new Intent(TournamentView.this, EditMatchScorePage.class));
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_view);
/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        tournament = MainPage.sv.loadData();

        ListView lv = (ListView) findViewById(R.id.listView2);
        ArrayList<String> matchList = new ArrayList<String>();
        matchList.add("Team 1 VS Team 12");
        matchList.add("Team 3 VS Team 2");
        matchList.add("Team 5 VS Team 16");
        matchList.add("Team 7 VS Team 10");
        matchList.add("Team 9 VS Team 4");
        matchList.add("Team 11 VS Team 6");
        matchList.add("Team 13 VS Team 14");
        matchList.add("Team 15 VS Team 8");

        ArrayAdapter<String> matchListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, matchList);
        lv.setAdapter(matchListAdapter);


    }

}
