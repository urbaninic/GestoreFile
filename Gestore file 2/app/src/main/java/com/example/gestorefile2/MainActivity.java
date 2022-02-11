package com.example.gestorefile2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLeggi;
    Button btnScrivi;
    EditText txtNomeFile;
    TextView txtContenuto;
    GestoreFile gf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeggi = (Button) findViewById(R.id.btnLeggi);
        btnScrivi = (Button) findViewById(R.id.btnScrivi);
        txtNomeFile = (EditText) findViewById(R.id.txtNomeFile);
        txtContenuto = (TextView) findViewById(R.id.txtContenuto);
        gf = new GestoreFile();
        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringaricevuta =  gf.readFile("filedaleggere.txt", getApplicationContext());
                Toast.makeText(getApplicationContext(), stringaricevuta, Toast.LENGTH_LONG).show();
            }
        });
    }
}