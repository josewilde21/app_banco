package com.example.app_banco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private Button btn;
    private EditText edit1, edit2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = (EditText)findViewById(R.id.pt1);
        edit2 = (EditText)findViewById(R.id.pt2);


        progress = (ProgressBar)findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.btn);
        ;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = edit1.getText().toString();
                String contra = edit2.getText().toString();


                if (usuario.equals("Android") && contra.equals("123")) {
                    Toast.makeText(getBaseContext(), "Sesión Iniciada Espere Porfavor", Toast.LENGTH_SHORT).show();
                    new Task().execute();

                } else {
                    Toast.makeText(getBaseContext(), "Usuario e/o Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }


            }
        });


        progress.setVisibility(View.INVISIBLE);
    }



    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(String... strings) {

            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {

            progress.setVisibility(View.INVISIBLE);

            Intent i = new Intent(getBaseContext(), home_act.class);
            startActivity(i);





        }
    }

}








