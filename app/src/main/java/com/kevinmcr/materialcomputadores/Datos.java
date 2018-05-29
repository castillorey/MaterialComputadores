package com.kevinmcr.materialcomputadores;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Android on 28/05/2018.
 */

public class Datos {

    private static String db = "Computadores";

    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    private static ArrayList<Computador> computadores= new ArrayList();

    public static void guardar(Computador c){
        databaseReference.child(db).child(c.getId()).setValue(c);
    }

    public static int fotoAleatoria (ArrayList<Integer> imagenes){
        int imagenSeleccionada;
        Random r = new Random();
        imagenSeleccionada = r.nextInt(imagenes.size());

        return imagenes.get(imagenSeleccionada);
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void setComputadores(ArrayList<Computador> computadores){
        Datos.computadores = computadores;
    }

    public static void eliminarComputador(Computador c){
        databaseReference.child(db).child(c.getId()).removeValue();
    }

    public static void modificarComputador(Computador c){
        databaseReference.child(db).child(c.getId()).setValue(c);
    }
}
