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
public class ConjuntoVehiculos {
    private Vehiculo[] coleccion;
    
    public ConjuntoVehiculos(){
        this.coleccion=new Vehiculo[15];
    }
    
    public boolean anadirVehiculo(Vehiculo vehiculo){
        for (int i = 0; i <this.coleccion.length; i++) {
            if(this.coleccion[i]==null){
                this.coleccion[i]=vehiculo;
                return true;
            }
        }
        return false;
    }
}
