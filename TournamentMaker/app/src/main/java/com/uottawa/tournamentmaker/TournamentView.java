package com.uottawa.tournamentmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class TournamentView extends AppCompatActivity {
//Things to do:
    //
    // The UI for edit Score / Match Edit needs to be built
    Tournament tournament; //tournament object to do stuff with
    SaveManager sv = new SaveManager(); //object used for managing save file

    public void onViewScoreboardTournamentView(View v){
        startActivity(new Intent(TournamentView.this, Scoreboard.class));
    }
    public void onEditTournamentTournamentView(View v){
        startActivity(new Intent(TournamentView.this, TournamentOptions.class));
    }
    public void onStartTournamentTournamentView(View v){
        // start tournament object
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
        tournament = sv.loadData();
    }

}
