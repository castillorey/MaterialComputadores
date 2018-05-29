package com.kevinmcr.materialcomputadores;

/**
 * Created by Android on 28/05/2018.
 */

public class Computador {
    private String id, marca, color, tipo, so;
    private int  img, ram;


    public Computador (){

    }

    public Computador (String id){
        this.id = id;
    }

    public Computador(String id, String marca, String color, String tipo, String so, int img, int ram) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.tipo = tipo;
        this.so = so;
        this.img = img;
        this.ram = ram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void guardar(){
        Datos.guardar(this);
    }

    public void eliminar(){
        Datos.eliminarComputador(this);
    }
}
