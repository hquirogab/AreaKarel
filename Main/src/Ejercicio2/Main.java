package Ejercicio2;

import becker.robots.*;

/**
 * Ejercicios con el robot Karel
 * @author Juan Diego Carrero Guerrero
 */
public class Main {
     public static City objetos;
        public static Robot estudiante;
        
        public static void main(String[] args) {
        objetos = new City("Field2.txt");
	    objetos.showThingCounts(true);
            
            estudiante = new Robot(objetos,10, 2, Direction.WEST,0);
            
            
            int paredes=0;
            while(estudiante.canPickThing()==false){
               
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
                    while(estudiante.frontIsClear()==false){
                    estudiante.turnLeft();
                    paredes++;
                }
                estudiante.move();
                
            }
            System.out.println("Perimetro"+(paredes+1));
            //60 lados
            System.out.println("El area debe ser de 46m^2");
            //si fuera un rectangulo seria: 81= 9x9
            // 35 es lo que hay por fuera en area 
            // 40 movimientos
}
}
