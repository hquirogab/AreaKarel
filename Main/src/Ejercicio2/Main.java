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
        int paredes = 0;
        int[][] area = null;
        
        
        int posInicialX = estudiante.getAvenue();
        int posInicialY = estudiante.getStreet();
        int posFinalX = 0;
        int posFinalY = 0;
      
        while(estudiante.canPickThing()==false){
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
            while(estudiante.frontIsClear() == false){
                estudiante.turnLeft();
                 paredes++;
            }
            //Le indica al robot cuando crear la matriz
            if(estudiante.getAvenue() == posInicialY){
                area = new int[estudiante.getAvenue()][estudiante.getStreet()];         
                posFinalX = estudiante.getAvenue();
                posFinalY = estudiante.getStreet();
            }
            estudiante.move();
        }
        System.out.println("Creada matriz de tamaño : " + posFinalX + "," + posFinalY);
        
        
        //Iguala toda la matriz a 0
        for(int i = 0; i < posFinalX; i++){
            for (int j = 0; j < posFinalY; j++) {
                area[i][j] = 0;
            }
        }
        
        //Imprime la matriz creada
        for(int i = 0; i < posFinalX; i++){
            for(int j = 0; j < posFinalY; j++){
                System.out.print(area[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
