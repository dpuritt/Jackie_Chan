package com.uottawa.tournamentmaker;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    Tournament[] tournaments = new Tournament[5];
    // Things to be added:
    //
    // - The help page must be created
    // -

/*    public void OnRemoveTournament(this){
        removeTournament(this);
    }*/
    public void onAddQuickTournament(View v){ // make it be ready to accept a completed tournament to put into the the list of tournaments
        Intent i = new Intent(MainPage.this, QuickStart.class);
        startActivity(i);
    }
    public void onTournamentView(View v){ // this must select a tournament from the list before it can call TournamentView. it must pass this tournament to tournamentview so that it can access info over there
        Intent i = new Intent(MainPage.this, TournamentView.class);
       // i.putExtra("tournament_key",tournaments[0]); // would choose

        startActivity(i);
    }
    public void onTournamentOption(View v){ // Creating a new custom tournament // we can prompt user for a tournament name here or on the tournamentOptions UI, same comments are by constructors of TournamentOptions
        startActivity(new Intent(MainPage.this, TournamentOptions.class));
    }
/*    public void onRemoveTournament(View v){
        //Remove tournament algorithm
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_page);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
