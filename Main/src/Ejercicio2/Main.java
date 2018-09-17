package Ejercicio2;

import becker.robots.*;
import javax.swing.JOptionPane;

/**
 * Ejercicios con el robot Karel
 * @author Hernan Javier Quiroga Bernal
 */
public class Main {
    public static City objetos;
    public static Robot estudiante;
        
    public static void main(String[] args) {
        objetos = new City("Field2.txt");
        objetos.showThingCounts(true);
        estudiante = new Robot(objetos, 10, 2, Direction.WEST, 1);
        estudiante.putThing();
        estudiante.move();
        int paredes = 0;
        int[][] area = null;
        
        int posInicialY = estudiante.getStreet();
        int posFinalX = 0;
        
        
        while(estudiante.canPickThing()==false){
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
            while(estudiante.frontIsClear() == false){
                estudiante.turnLeft();
                paredes++;
            }
            if(estudiante.getStreet() == 0){
                    posFinalX = estudiante.getAvenue();
            }
            estudiante.move();
        }
        
        area = new int[posFinalX + 1][posInicialY + 1];
        
        for (int i = 0; i <= posFinalX; i++) {
            for (int j = 0; j <= posInicialY; j++) {
                area[i][j] = 0;
            }
        }
        
        estudiante.move();
        
        while(estudiante.canPickThing()==false){
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
            while(estudiante.frontIsClear() == false){
                estudiante.turnLeft();
                area[estudiante.getAvenue()][estudiante.getStreet()] = 1;
            }
            area[estudiante.getAvenue()][estudiante.getStreet()] = 1;
            estudiante.move();
        }
        area[estudiante.getAvenue()][estudiante.getStreet()] = 1;
         
        int areaTotal = 0;
        
        for (int i = 1; i < posFinalX; i++) {
            for (int j = 1; j < posInicialY; j++) {
                if(area[j][i]==0)areaTotal++;
                System.out.print(area[j][i] + " ");
            }
            System.out.print("\n");
        }
        
        JOptionPane.showMessageDialog(null, "El area de la zona es: " + areaTotal + "m^2");
    }
}
