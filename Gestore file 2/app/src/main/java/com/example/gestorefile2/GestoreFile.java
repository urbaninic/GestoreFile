package com.example.gestorefile2;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GestoreFile {

    // Serve il nome del file
    String nomeFile;

    public GestoreFile(){

    }

    // Costruttore
    public GestoreFile(String nomeFile)
    {
        this.nomeFile = nomeFile;
    }

    // PUBLIC STRING: restituisce stringa
    // parametri metodo: Nome file
    // Read file
    public String readFile(String nf, Context c){
        StringBuilder sb = new StringBuilder();
        // Classe usata: BUFFEREDREADER
        try {
            BufferedReader bfr = new BufferedReader(new InputStreamReader(c.openFileInput(nf)));
            String testoDaRestituire = "";
            while ((testoDaRestituire = bfr.readLine())!= null)
            {
                sb.append(testoDaRestituire + "\n");
            }
        } catch (FileNotFoundException e) {
            // file not nound exception: se file non esiste, si blocca programma. Se succedesse,
            // invece di chiudere app, faccio un log.e cosi do un messaggio di errore a user
            //restituzione errore
            Log.e("Errore", "Errore file non esistente");
        } catch (IOException e) {
            Log.e("Errore", "Errore nella lettura del File");
            //e.printStackTrace();
        }
        return sb.toString();
    }
    // Wirte on file
    private void writeToFile(String nf,Context c) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(c.openFileOutput(nf, Context.MODE_PRIVATE));
            outputStreamWriter.write(nf);
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
