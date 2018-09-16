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
            int seccion;
            ConjuntoVehiculos conjunto=new ConjuntoVehiculos();
            do{
        objetos = new City("Field1.txt");
	    objetos.showThingCounts(true);
            
            estudiante = new Robot(objetos,6, 1, Direction.NORTH,1);
            Hora h1 = new Hora (7,42);
            Thing t1 = new Thing (objetos,1,2);
            Vehiculo v1 = new Vehiculo (123,h1,21,t1);
            Hora h2 = new Hora (8,10);
            Thing t2 = new Thing (objetos,2,2);
            Vehiculo v2 = new Vehiculo (675,h2,22,t2);
            Hora h3 = new Hora (9,32);
            Thing t3 = new Thing (objetos,1,3);
            Vehiculo v3 = new Vehiculo (756,h3,31,t3);
            Hora h4 = new Hora (7,15);
            Thing t4 = new Thing (objetos,2,3);
            Vehiculo v4 = new Vehiculo (912,h4,32,t4);
            Hora h5 = new Hora (10,41);
            Thing t5 = new Thing (objetos,1,1);
            Vehiculo v5 = new Vehiculo (567,h5,11,t5);
            Hora h6 = new Hora (9,5);
            Thing t6 = new Thing (objetos,2,1);
            Vehiculo v6 = new Vehiculo (476,h6,12,t6);
            Hora h7 = new Hora (11,15);
            Thing t7 = new Thing (objetos,3,1);
            Vehiculo v7 = new Vehiculo (874,h7,13,t7);
            
            
            
                System.out.println("Bienvenido al sistema de parqueo");
                
                System.out.println("1. Ingresar vehiculo");
                System.out.println("2. Sacar vehiculo");
                System.out.println("3. Mostrar seccion");
                System.out.println("4. Generar ingresos");
                
                opcion=entrada.nextInt();
            
            
            
            switch (opcion){
                    case 1:
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
            
            for(int i=0; i<2; i++){
                estudiante.move();
            }
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
            int posi=ingresar(s1,s2,s3);
                        
            if(s1+s2+s3<15){
            Thing t8= new Thing (objetos, posi%10, posi/10);
            System.out.println("Numero de placa: ");  
            placa=entrada.nextInt();
            System.out.println("Hora de llegada: ");
            hora=entrada.nextInt();
            System.out.println("Minuto de llegada: ");
            minuto=entrada.nextInt();
            
            Hora ingreso=new Hora(hora,minuto);
            Vehiculo v8= new Vehiculo (placa, ingreso, posi,t8);
            System.out.println("Placa: "+v8.getPlaca());
                        System.out.println("Ingreso: " +ingreso.getHora()+" horas "+ingreso.getMinuto()+" minutos");
                        System.out.println("Posicion: "+v8.getPosicion());
                        conjunto.anadirVehiculo(v8);
                        
            break;
            }
            else System.out.println("El parqueadero esta lleno, lo sentimos");
            
                    case 2:
                        System.out.println("Seccion en que se encuentra el vehiculo: ");
                        seccion=entrada.nextInt();
                        System.out.println("Placa del vehiculo: ");
                        placa=entrada.nextInt();
                        sacarVehiculo(seccion, placa);
                        break;
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
                estudiante.turnLeft();
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                }
                estudiante.turnLeft();
                estudiante.turnLeft();
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
                estudiante.turnLeft();
                while(estudiante.canPickThing()==false && estudiante.frontIsClear()==true){
                    estudiante.move();
                    pos++;
                }
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.move();
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
                estudiante.turnLeft();
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                }
                estudiante.turnLeft();
                estudiante.turnLeft();
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
                estudiante.turnLeft();
                while(estudiante.canPickThing()==false && estudiante.frontIsClear()==true){
                    estudiante.move();
                    pos++;
                }
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.move();
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
            int mov=0;
            Vehiculo vehiculo = new Vehiculo (placa);
            if(seccion==1){
                estudiante.move();
                while(vehiculo.getPlaca()!=placa){
                estudiante.move();
                mov++;
                }
                //estudiante.pickThing();
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
                while(estudiante.canPickThing()==true){
                    estudiante.move();
                    estudiante.pickThing();
                }
                while(estudiante.frontIsClear()==true){
                    estudiante.move();
                }
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
