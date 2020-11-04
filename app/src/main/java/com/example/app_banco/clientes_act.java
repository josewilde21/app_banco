package com.example.app_banco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import beneficio.AdminSQLiteOpenHelper;

public class clientes_act extends AppCompatActivity {

    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        et1 = (EditText) findViewById(R.id.et_codigo);
        et2 = (EditText) findViewById(R.id.et_nombre);
        et3 = (EditText) findViewById(R.id.et_salario);

    }
    public void AñadirCliente(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Ficherobanco", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase(); // que me permita sobreescribir la base de datos

        if (!et1.getText().toString().isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("codigo", et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("salario", et3.getText().toString());


            BaseDeDatos.insert("clientes", null, registro);
            BaseDeDatos.close();

            Toast.makeText(this, "Se a Guardado el Insumo", Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(this, "Debe Rellenar los campos", Toast.LENGTH_LONG).show();


        }


    }

    public void MostrarCliente(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Ficherobanco", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = et1.getText().toString();

        if (!codigo.isEmpty()) {
            Cursor fila = db.rawQuery("SELECT nombre,salario FROM clientes WHERE codigo=" + codigo, null);

            if (fila.moveToFirst()) {
                et2.setText(fila.getString(0));
                et3.setText(fila.getString(1));



            } else {
                Toast.makeText(this, "No hay ningun campo en insumos", Toast.LENGTH_LONG).show();
            }


        } else {
            Toast.makeText(this, "No hay ningun campo en insumos", Toast.LENGTH_SHORT).show();


        }
    }

    public void EliminarCliente(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Ficherobanco", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = et1.getText().toString();

        db.delete("clientes", "codigo=" + codigo, null);
        db.close();

        Toast.makeText(this, "se a eliminado un campo", Toast.LENGTH_SHORT).show();


    }

    public void ActualizarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Ficherobanco", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = et1.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", et1.getText().toString());
        cont.put("nombre", et2.getText().toString());
        cont.put("salario", et3.getText().toString());


        if(!codigo.isEmpty())
        {
            db.update("clientes", cont, "codigo="+codigo, null);
            db.close();

            Toast.makeText( this, "acabas de actualizar un campo", Toast.LENGTH_LONG).show();

        }




    }
}