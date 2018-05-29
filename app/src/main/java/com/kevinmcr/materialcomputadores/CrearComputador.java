package com.kevinmcr.materialcomputadores;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearComputador extends AppCompatActivity {
    private EditText txtRam;
    private Spinner cmbMarca, cmbColor, cmbTipo, cmbSo;
    private ArrayAdapter<String> adapter1, adapter2, adapter3, adapter4;
    private String opcMarca[], opcColor[], opcTipo[], opcSo[];
    private ArrayList<Integer> imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_computador);

        cmbMarca = findViewById(R.id.spnrMarca);
        txtRam = findViewById(R.id.txtRam);
        cmbColor = findViewById(R.id.spnrColor);
        cmbTipo = findViewById(R.id.spnrTipo);
        cmbSo = findViewById(R.id.spnrSo);


        opcMarca = this.getResources().getStringArray(R.array.marcas);
        adapter1 = new ArrayAdapter<String>(this,R.layout.custom_spinner,opcMarca);
        cmbMarca.setAdapter(adapter1);

        opcColor = this.getResources().getStringArray(R.array.colores);
        adapter2 = new ArrayAdapter<String>(this,R.layout.custom_spinner,opcColor);
        cmbColor.setAdapter(adapter2);

        opcTipo = this.getResources().getStringArray(R.array.tipos);
        adapter3 = new ArrayAdapter<String>(this,R.layout.custom_spinner,opcTipo);
        cmbTipo.setAdapter(adapter3);

        opcSo   = this.getResources().getStringArray(R.array.sos);
        adapter4 = new ArrayAdapter<String>(this,R.layout.custom_spinner,opcSo);
        cmbSo.setAdapter(adapter4);

        imagenes = new ArrayList<Integer>();
        imagenes.add(R.drawable.images);
        imagenes.add(R.drawable.images2);
        imagenes.add(R.drawable.images3);


    }

    public void guardar(View v){
        String id;
        int marca,ram, color, tipo, so, imagen;
        id = Datos.getId();
        imagen = Datos.fotoAleatoria(imagenes);
        ram = Integer.parseInt(txtRam.getText().toString());
        marca = cmbMarca.getSelectedItemPosition();
        color = cmbColor.getSelectedItemPosition();
        tipo = cmbTipo.getSelectedItemPosition();
        so = cmbSo.getSelectedItemPosition();

        Computador c = new Computador(id, marca, ram, color, tipo, so, imagen);
        c.guardar();
        Snackbar.make(v, getResources().getString(R.string.mensaje_guardado_exitoso), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        txtRam.setText("");
        cmbMarca.setSelection(0);
        cmbColor.setSelection(0);
        cmbTipo.setSelection(0);
        cmbSo.setSelection(0);
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent (CrearComputador.this,Principal.class);
        startActivity(i);
    }
}
