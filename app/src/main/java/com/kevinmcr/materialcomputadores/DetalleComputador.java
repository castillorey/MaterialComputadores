package com.kevinmcr.materialcomputadores;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleComputador extends AppCompatActivity {
    private TextView tvMarca,tvRam, tvColor, tvTipo, tvSo;
    private String[] marcas, colores, tipos, sos;
    private ImageView imgDetalle;
    private String id;
    private int imagen, marca, ram, color, tipo, so;
    private Intent i;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_computador);

        imgDetalle = findViewById(R.id.imgDetalle);
        tvMarca = findViewById(R.id.tvMarca);
        tvRam = findViewById(R.id.tvRam);
        tvColor = findViewById(R.id.tvColor);
        tvTipo = findViewById(R.id.tvTipo);
        tvSo = findViewById(R.id.tvSo);
        marcas = getResources().getStringArray(R.array.marcas);
        colores = getResources().getStringArray(R.array.colores);
        tipos = getResources().getStringArray(R.array.tipos);
        sos = getResources().getStringArray(R.array.sos);

        i = getIntent();
        bundle = getIntent().getBundleExtra("datos");
        id = bundle.getString("id");
        imagen = bundle.getInt("imagen");
        marca = bundle.getInt("marca");
        ram = bundle.getInt("ram");
        color = bundle.getInt("color");
        tipo = bundle.getInt("tipo");
        so = bundle.getInt("so");

        imgDetalle.setImageResource(imagen);
        tvMarca.setText(marcas[marca]);
        tvRam.setText(ram);
        tvColor.setText(colores[color]);
        tvTipo.setText(tipos[tipo]);
        tvSo.setText(sos[so]);

    }

    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Computador c = new Computador(id);
                c.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(DetalleComputador.this,Principal.class);
        startActivity(i);
    }

}
