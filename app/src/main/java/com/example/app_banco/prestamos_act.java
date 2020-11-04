package com.example.app_banco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import beneficio.beneficio_saldo;

public class prestamos_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);
        spin1 = (Spinner) findViewById(R.id.spnClientes);
        spin2 = (Spinner) findViewById(R.id.spnBeneficios);
        text = (TextView) findViewById(R.id.tv);

        // Recibir el dato.
        // <----
        ArrayList<String> listaclientes = (ArrayList<String>) getIntent().getSerializableExtra("listaclientes");
        ArrayList<String> listabeneficio = (ArrayList<String>) getIntent().getSerializableExtra("listabeneficio");


        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaclientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listabeneficio);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);


    }

    public void Calcular(View v) {

        String clientes = spin1.getSelectedItem().toString();
        String beneficio = spin2.getSelectedItem().toString();

        beneficio_saldo bene = new beneficio_saldo();
        beneficio_saldo cli = new beneficio_saldo();

        int resultAxel = cli.getAxel() + bene.getCredito_au();
        int resultAxel1 = cli.getAxel() + bene.getCredito_hp();
        int resultRoxana = cli.getRoxana() + bene.getCredito_au();
        int resultRoxana1 = cli.getRoxana() + bene.getCredito_hp();


        //inteligencia para Axel


        if(clientes.equals("axel") && beneficio.equals("credito_au"))
        {
            text.setText("su saldo que da en: " + resultAxel);

        }
        if(clientes.equals("axel") && beneficio.equals("credito_hp"))
        {
            text.setText("su saldo que da en: " + resultAxel1);

        }

        //inteligencia para Roxana

        if(clientes.equals("roxana") && beneficio.equals("credito_au"))
        {
            text.setText("su saldo que da en: " + resultRoxana);

        }
        if(clientes.equals("roxana") && beneficio.equals("credito_hp"))
        {
            text.setText("su saldo que da en: " + resultRoxana1);

        }



    }
    public void deuda(View v){

        String clientes = spin1.getSelectedItem().toString();
        String beneficio = spin2.getSelectedItem().toString();

        beneficio_saldo bene = new beneficio_saldo();



        int resultdeudaA = 8 / bene.getCredito_au();
        int resultdeudaA1 = 12 / bene.getCredito_hp();


        int resultdeudaR = 8 / bene.getCredito_au();
        int resultdeudaR1 = 12 / bene.getCredito_hp();


        //inteligencia para Axel

        if(bene.equals("credito_au") && clientes.equals("axel"))
        {
            text.setText("señor axel su saldo final dividas en 8 queda en: " + resultdeudaA);

        }
        if(bene.equals("credito_hp") && clientes.equals("axel"))
        {
            text.setText("señor axel su saldo final dividas en 12 queda en: " + resultdeudaA1);

        }

        //inteligencia para Roxana

        if(bene.equals("credito_au") && clientes.equals("roxana"))
        {
            text.setText("señorita roxana su saldo final dividas en 8 queda en: " + resultdeudaR);

        }
        if(bene.equals("credito_hp") && clientes.equals("roxana"))
        {
            text.setText("señorita roxana su saldo final dividas en 12 queda en: " + resultdeudaR1);

        }





    }





}




