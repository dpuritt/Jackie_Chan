package com.uottawa.tournamentmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EditMatchScorePage extends AppCompatActivity {

    int scoreTeamA;
    int scoreTeamB;

    public void onEditScoreTeamAGoals(View v){
    //Edit value of scoreTeamA
    }
    public void onEditScoreTeamBGoals(View v){
    //Edit value of scoreTeamB
    }
    public void onEditMatchScoreSave(View v){
    //Save values of scoreTeamA and scoreTeamB on the main tournament
        Intent i = new Intent(EditMatchScorePage.this, TournamentView.class);
        startActivity(i);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_match_score_page);
    }
}
