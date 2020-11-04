package com.example.app_banco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2800);
        vf.setAutoStart(true);

        // Sentido al slider
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void info (View v)
    {
        Intent i = new Intent(this, info_act.class);
        startActivity(i);


    }
    public void seguridad (View v)
    {
        Intent i = new Intent(this, seguridad_act.class);
        startActivity(i);
    }
    public void prestamos (View v)
    {

        // Envío el dato

        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> beneficio = new ArrayList<String>();

        clientes.add("axel");
        clientes.add("roxana");
        clientes.add("betzabe");
        clientes.add("matias");

        beneficio.add("credito_hp");
        beneficio.add("credito_au");


        Intent i = new Intent(this, prestamos_act.class);
        i.putExtra("listaclientes", clientes);
        i.putExtra("listabeneficio", beneficio);
        startActivity(i);
    }
    public void clientes (View v)
    {
        Intent i = new Intent(this, clientes_act.class);
        startActivity(i);
    }





}