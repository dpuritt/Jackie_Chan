

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
import android.widget.NumberPicker;
import android.widget.Spinner;

public class QuickStart extends AppCompatActivity {
    Boolean roundRobin = false;
    Boolean both = false; //if user selected both types
    int numTeams = 0;
    String name = ("Default name");
    Tournament tournament; //tournament object to do stuff with
    SaveManager sv = new SaveManager(); //object used for managing save file


    public void onQuickStartEditTeamNumber(View v) {
        NumberPicker _numTeams = (NumberPicker) findViewById(R.id.numberPickerQS);
            this.numTeams = _numTeams.getValue();
    }

    public void onSaveButton(View v){
        Spinner spinner = (Spinner)findViewById(R.id.spinnerQS);
        int style = spinner.getSelectedItemPosition();
        if (style == 0){
            this.roundRobin = true;
        }
        else if (style == 1){
            this.roundRobin = false;
        }
        else{
            this.roundRobin = true;
            this.both = true;
        }
        tournament = new Tournament (name,numTeams);
        tournament.quickStart(name,roundRobin,both,numTeams);
        sv.writeData(tournament);

        // now one goes to Tournament View and they must pass this tournament created above for use in TournamentView

        finish();
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

        NumberPicker numberPickerQS = (NumberPicker) findViewById(R.id.numberPickerQS);
        numberPickerQS.setMinValue(2);
        numberPickerQS.setMaxValue(100);


        /*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        tournament = sv.loadData();
    }
}
