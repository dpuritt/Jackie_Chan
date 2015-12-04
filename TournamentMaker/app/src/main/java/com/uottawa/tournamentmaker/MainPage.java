package com.uottawa.tournamentmaker;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainPage extends AppCompatActivity {


    public void MPonDeleteTournament(View v) {
        //set all values of tournament back to defaults (equivalent to empty)
    }
    public void onAddQuickTournament(View v){


        Intent i = new Intent(MainPage.this, QuickStart.class);
        startActivity(i);
    }


    public void onTournamentView(View v){ // this must select a tournament from the list before it can call TournamentView. it must pass this tournament to tournamentview so that it can access info over there
        Intent i = new Intent(MainPage.this, TournamentView.class);
        startActivity(i);
    }

    public void MPonHelpButton(View v){
        Intent i = new Intent(MainPage.this, HelpPage.class);
        startActivity(i);
    }

    public void onCreateNewTournament(View v){
        Intent i = new Intent(MainPage.this, TournamentOptions.class);
        startActivity(i);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_page);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

    }


}
