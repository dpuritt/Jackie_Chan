// Things left to do:
//Connect button methods to their actions
//Connect name input to method here
//Connect team # input to method here
//Connect logo input to method here


package com.uottawa.tournamentmaker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class TeamOptions extends AppCompatActivity {
    Team team;
    String name;
    int logo = 0;
    String address;
    Tournament tournament; //tournament object to do stuff with
    SaveManager sv = new SaveManager(); //object used for managing save file

    public TeamOptions(Team team){
        this.team = team;
        this.name = team.getName();
        this.logo = team.getLogo();
        this.address = team.getAddress();

        // Populate name location with name now assigned
        // Populate logo location with logo now assigned
        // Populate address location with address now assigned
    }
    public TeamOptions(){
        // This is stop from crashing, theoretically this should never be called, one must have a team to call
        // edit team/ teamOptions, thus the other constructor shall always be invoked
    }


    public void onTeamOptionsEditName(View v) {
        EditText _name = (EditText) findViewById(R.id.teamAddressField);
        if((_name.equals(""))||(_name.equals(null))){}
        else{
            this.name = _name.getText().toString();
        }
    }
    public void onTeamOptionsEditAddress(View v) {
        EditText teamAddress = (EditText) findViewById(R.id.teamAddressField);
        if((teamAddress.equals(""))||(teamAddress.equals(null))){}
        else{
            this.address = teamAddress.getText().toString();
        }
    }



    //Method for input of logo
    //this.logo = logo;

    public void onTeamOptionsSave(View v){
        team.setName(name);
        team.setAddress(address);
        team.setLogo(logo);

        sv.writeData(tournament);
        //Return to previous page with new team with edits
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_options);
        sv = MainPage.getSV();
        tournament = sv.loadData();


    }
}
