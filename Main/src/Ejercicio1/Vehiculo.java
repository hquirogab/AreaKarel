/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;
import becker.robots.*;
/**
 *
 * @author USUARIO
 */
public class Vehiculo {
    private int placa;
    private Hora  ingreso;
    private Hora salida;
    private int posicion;
    private Thing thing;
    
    public Vehiculo(int placa){
        this.placa=placa;
    }
    public Vehiculo(int placa,Hora ingreso, int posicion, Thing thing){
        this.placa=placa;
        this.ingreso=ingreso;
        this.posicion=posicion;
        this.thing=thing;
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
