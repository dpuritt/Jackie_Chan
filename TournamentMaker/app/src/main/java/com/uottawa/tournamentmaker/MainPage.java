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

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MainPage extends AppCompatActivity {

    Tournament tournament; //tournament object to do stuff with
    public final static SaveManager sv = new SaveManager(); //object used for managing save file
    Boolean tournamentExists = false;

public static SaveManager getSV(){
    return sv;
}

    public void MPonDeleteTournament(View v) {

            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            tournament = new Tournament("Empty_Tournament", true, false, 0);
                            sv.writeData(tournament);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you wish to delete current tournament?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();

    }
    public void onAddQuickTournament(View v){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:

                        Intent i = new Intent(MainPage.this, QuickStart.class);
                        startActivity(i);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure to create a new Tournament?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
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
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent i = new Intent(MainPage.this, TournamentOptions.class);
                        startActivity(i);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you wish to create a new Tournament?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        sv.setFileContext(this.getApplicationContext());

        tournament = sv.loadData();

        if(tournament == null) {
            sv.writeData(this.getApplicationContext());
        }

    }

}
