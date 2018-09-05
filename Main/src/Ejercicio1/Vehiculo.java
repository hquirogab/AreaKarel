/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author USUARIO
 */
public class Vehiculo {
    private int placa;
    private Hora  ingreso;
    private Hora salida;
    private int posicion;
    
    public Vehiculo(int placa,Hora ingreso, int posicion){
        this.placa=placa;
        this.ingreso=ingreso;
        this.posicion=posicion;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public Hora getIngreso() {
        return ingreso;
    }

    public void setIngreso(Hora ingreso) {
        this.ingreso = ingreso;
    }

    public Hora getSalida() {
        return salida;
    }

    public void setSalida(Hora salida) {
        this.salida = salida;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    
    
    
}
