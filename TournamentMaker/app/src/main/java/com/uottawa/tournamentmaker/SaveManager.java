package com.uottawa.tournamentmaker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Shuai on 04/12/2015.
 */
public class SaveManager {
    public Tournament loadData(){
        try {

            //create input stream
            FileInputStream fis = new FileInputStream("save.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            //attempt to read the file into our object
            Tournament tournamentObj = (Tournament) ois.readObject();

            //close the input stream
            ois.close();

            //return the object read
            return tournamentObj;
        } catch (Exception e) {
            //file error
            return null;
        }
    }

    public boolean writeData(Tournament tournamentObj){
        try{

            //create output stream
            FileOutputStream fos = new FileOutputStream("save.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //attempt to write to our file
            oos.writeObject(tournamentObj);

            //close the output stream
            oos.close();

            return true;
        } catch (Exception e){
            return false;
        }
    }
}
