package com.kevinmcr.materialcomputadores;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements AdaptadorComputador.OnComputadorClickListener{

    private RecyclerView rcycleLista;
    private Intent i;
    private ArrayList<Computador> computadores;
    private AdaptadorComputador adapter;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private String bd = "Computadores";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rcycleLista = findViewById(R.id.rcycleLista);

        computadores = new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorComputador(computadores,this);

        rcycleLista.setLayoutManager(llm);
        rcycleLista.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(bd).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                computadores.clear();
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Computador c = snapshot.getValue(Computador.class);
                        computadores.add(c);
                    }
                }

                adapter.notifyDataSetChanged();
                Datos.setComputadores(computadores);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    public void crearComputadores(View v){
        i = new Intent(Principal.this,CrearComputador.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onComputadorClick(Computador p) {
        Intent i = new Intent(Principal.this, DetalleComputador.class);
        Bundle b = new Bundle();
        b.putString("id",p.getId());
        b.putInt("imagen",p.getImg());
        b.putString("marca",p.getMarca());
        b.putInt("ram",p.getRam());
        b.putString("color",p.getColor());
        b.putString("tipo",p.getTipo());
        b.putString("so",p.getSo());

        i.putExtra("datos",b);
        startActivity(i);
    }


}
