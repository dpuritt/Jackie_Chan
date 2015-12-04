

// Things left to do:

//Connect button methods to their actions
//Connect name input to method here
//Connect team # inout to method here

package com.uottawa.tournamentmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class QuickStart extends AppCompatActivity {
    Boolean roundRobin = false;
    Boolean both = false; //if user selected both types
    int numTeams = 0;
    String name = ("Default name");

    public void onSetRoundRobin(View v){
        this.roundRobin = true;
    }

    public void onSetKnockout(View v){
        this.roundRobin = false;
    }

    public void onSetCombination(View v){
        this.roundRobin = true;
        this.both = true;
    }

    public void onQuickStartEditName(View v) {
     /*   EditText _name = (EditText) findViewById(R.id.teamAddressField);
        if((_name.equals(""))||(_name.equals(null))){}
        else{
            this.name = _name.getText().toString();
        }*/
    }

    public void onQuickStartEditTeamNumber(View v) {
       /* EditText _numTeams = (EditText) findViewById(R.id.teamAddressField);
        if((_numTeams.equals(""))||(_numTeams.equals(null))){}
        else{
            this.numTeams = Integer.parseInt(_numTeams.getText().toString());
        } */
    }

    public void onSaveButton(View v){
        Tournament tournament = new Tournament (name,numTeams);
        tournament.quickStart(name,roundRobin,both,numTeams);

        // now one goes to Tournament View and they must pass this tournament created above for use in TournamentView

        startActivity(new Intent(QuickStart.this, TournamentView.class));
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_start);

        Spinner spinnerQS = (Spinner) findViewById(R.id.spinnerQS);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterQS1 = ArrayAdapter.createFromResource(this,
                R.array.tournament_type, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterQS1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerQS.setAdapter(adapterQS1);

/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/


    }
}
