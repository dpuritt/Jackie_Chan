package com.uottawa.tournamentmaker;

import android.app.Activity;
import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Shuai on 04/12/2015.
 */
public class SaveManager implements Serializable {

    Context fileContext;
    String fileName = "save.txt";
    File myFile;


    public Tournament loadData(){
        try {
            //create input stream
            FileInputStream fis = fileContext.getApplicationContext().openFileInput(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.print(myFile.toString());

            //attempt to read the file into our object
            Tournament tournamentObj = (Tournament) ois.readObject();

            System.out.println(tournamentObj.getName());
            //close the input stream
            ois.close();

            fis.close();
            //return the object read
            return tournamentObj;
        } catch (Exception e) {
            //file error
            System.out.println(e.toString()); // for testing
        }
        return null;
    }



    public boolean writeData(Tournament tournamentObj){
        try{
            //create output stream
            FileOutputStream fos = fileContext.openFileOutput(fileName, Context.MODE_PRIVATE);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //fileContext.deleteFile(fileName);
            myFile = new File(fileContext.getFilesDir(),fileName);
            System.out.println(myFile.toString());

            //attempt to write to our file
            oos.writeObject(tournamentObj);
            //close the output stream
            oos.close();
            fos.close();

            return true;
        } catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean writeData(Context fileContext){

        Tournament tournamentObj = new Tournament("Empty_Tournament", true, false, 0);
        try{
            //create output stream
            FileOutputStream fos = fileContext.openFileOutput(fileName, Context.MODE_PRIVATE);
            this.fileContext = fileContext;
            myFile = new File(fileContext.getFilesDir(),fileName);
            System.out.println(myFile.toString());

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //attempt to write to our file
            oos.writeObject(tournamentObj);
            //close the output stream
            oos.close();
            fos.close();
            return true;
        } catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    public void setFileContext(Context _fileContext){
        fileContext = _fileContext;
    }


}
