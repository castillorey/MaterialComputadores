package com.kevinmcr.materialcomputadores;

/**
 * Created by Android on 28/05/2018.
 */

public class Computador {
    private String id;
    private int marca, ram, color, tipo, so, img;


    public Computador (){

    }

    public Computador (String id){
        this.id = id;
    }

    public Computador(String id, int marca, int ram, int color, int tipo, int so, int img) {
        this.id = id;
        this.marca = marca;
        this.ram = ram;
        this.color = color;
        this.tipo = tipo;
        this.so = so;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSo() {
        return so;
    }

    public void setSo(int so) {
        this.so = so;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void guardar(){
        Datos.guardar(this);
    }

    public void eliminar(){
        Datos.eliminarComputador(this);
    }
}
