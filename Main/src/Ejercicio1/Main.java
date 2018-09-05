package Ejercicio1;

import becker.robots.*;
import java.util.Scanner;
/**
 * Ejercicios con el robot Karel
 * @author Juan Diego Carrero Guerrero
 */
public class Main {
    public static City objetos;
        public static Robot estudiante;
        
        public static void main(String[] args) {
            Scanner entrada=new Scanner(System.in);
            boolean continuar=false;
            int opcion;
            int placa;
            int hora;
            int minuto;
            ConjuntoVehiculos conjunto=new ConjuntoVehiculos();
            do{
            
            //Vehiculo v1=new Vehiculo(123,ingreso);
        objetos = new City("Field1.txt");
	    objetos.showThingCounts(true);
            
            estudiante = new Robot(objetos,6, 1, Direction.NORTH,1);
            
                System.out.println("Bienvenido al sistema de parqueo");
                
                System.out.println("1. Ingresar vehiculo");
                System.out.println("2. Sacar vehiculo");
                System.out.println("3. Mostrar seccion");
                System.out.println("4. Generar ingresos");
                
                opcion=entrada.nextInt();
            
            int s1=0;
            
            for(int i=0; i<5; i++){
                estudiante.move();
                if(estudiante.canPickThing()){
                    s1++;
                }
            }
            estudiante.turnLeft();
            estudiante.turnLeft();
            
            for(int i=0; i<5; i++){
                estudiante.move();
            }
            
            estudiante.turnLeft();
            estudiante.move();
            estudiante.move();
            estudiante.move();
            estudiante.turnLeft();
            
            int s2=0;
            for(int i=0; i<5; i++){
                estudiante.move();
                if(estudiante.canPickThing()){
                    s2++;
                }
            }
            estudiante.turnLeft();
            estudiante.turnLeft();
            
            for(int i=0; i<5; i++){
                estudiante.move();
            }
            
            estudiante.turnLeft();
            estudiante.move();
            estudiante.move();
            estudiante.move();
            estudiante.turnLeft();
            
            int s3=0;
            for(int i=0; i<5; i++){
                estudiante.move();
                if(estudiante.canPickThing()){
                    s3++;
                }
            }
            estudiante.turnLeft();
            estudiante.turnLeft();
            
            for(int i=0; i<5; i++){
                estudiante.move();
            }
            
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
            
            for(int i=0; i<6; i++){
                estudiante.move();
            }
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
            
            switch (opcion){
                    
                    case 1:
            
            
            int posi=ingresar(s1,s2,s3);
                        
            if(s1+s2+s3<15){
            System.out.println("Numero de placa: ");  
            placa=entrada.nextInt();
            System.out.println("Hora de llegada: ");
            hora=entrada.nextInt();
            System.out.println("Minuto de llegada: ");
            minuto=entrada.nextInt();
            
            Hora ingreso=new Hora(hora,minuto);
            Vehiculo [] vehiculo = new Vehiculo[15];
            for (int i=0;i<15;i++) {
            vehiculo[i] = new Vehiculo(placa,ingreso,posi);
            System.out.println("Placa: "+vehiculo[i].getPlaca());
                        System.out.println("Ingreso: "+ingreso.getHora()+" horas "+ingreso.getMinuto()+" minutos");
                        System.out.println("Posicion: "+vehiculo[i].getPosicion());
                        conjunto.anadirVehiculo(vehiculo[i]);
            }
            //Vehiculo ve1=new Vehiculo(placa,ingreso,posi);
                        
            
            break;
            }
            else System.out.println("El parqueadero esta lleno, lo sentimos");
            }
            
                System.out.println("Desea continuar?");
                continuar=entrada.nextBoolean();
            } while(continuar);        
    }
            
    
        public static int ingresar(int s1, int s2, int s3){
            if(s1==0){
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                }
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.putThing();
                
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                }
                
                return 11;
            }
            else if(s1<=s2 && s1<=s3 && s1!=5){
                int pos=0;
                while(estudiante.canPickThing()==false && estudiante.frontIsClear()==true){
                    estudiante.move();
                    pos++;
                }
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.move();
                estudiante.putThing();
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                    
                }
                if(pos==2){
                    pos=25;
                }
                if(pos==3){
                    pos=24;
                }
                if(pos==4){
                    pos=23;
                }
                if(pos==5){
                    pos=22;
                }
                return pos;
            }
            else if(s2==0){
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.turnLeft();
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                }
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.putThing();
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                }
                return 21;
            }
            else if(s2<s1 && s2<=s3){
                int pos=0;
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.turnLeft();
                while(estudiante.canPickThing()==false && estudiante.frontIsClear()==true){
                    estudiante.move();
                    pos++;
                }
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.move();
                estudiante.putThing();
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                }
                if(pos==2){
                    pos=25;
                }
                if(pos==3){
                    pos=24;
                }
                if(pos==4){
                    pos=23;
                }
                if(pos==5){
                    pos=22;
                }
                return pos;
            }
                else if(s3==0){
                    estudiante.turnLeft();
                    estudiante.turnLeft();
                    estudiante.turnLeft();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.turnLeft();
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                }
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.putThing();
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                }
                return 31;
            }
            else if(s3<s1 && s3<s2){
                int pos=0;
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.turnLeft();
                while(estudiante.canPickThing()==false && estudiante.frontIsClear()==true){
                    estudiante.move();
                    pos++;
                }
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.move();
                estudiante.putThing();
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                }
                if(pos==2){
                    pos=25;
                }
                if(pos==3){
                    pos=24;
                }
                if(pos==4){
                    pos=23;
                }
                if(pos==5){
                    pos=22;
                }
                return pos;
            }
            return 0;
            
            
        }
        public static boolean sacarVehiculo(int seccion, int placa){
            if(seccion==15){
                estudiante.move();
                estudiante.pickThing();
            }
            if(seccion==25){
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.turnLeft();
                estudiante.move();
                estudiante.pickThing();
            }
            if(seccion==35){
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.move();
                estudiante.turnLeft();
                estudiante.move();
                estudiante.pickThing();
            }
                return true;
            }
}
