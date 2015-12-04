package com.uottawa.tournamentmaker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Scoreboard extends AppCompatActivity {

    Tournament tournament; //tournament object to do stuff with
    SaveManager sv = new SaveManager(); //object used for managing save file





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        tournament = sv.loadData();

    }

}
