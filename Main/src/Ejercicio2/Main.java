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
            int a=2;
            int b=2;
            System.out.println(a*10+b);
            
            int paredes=0;
            int avenida[]= new int [100];
            int calle[]= new int [100];
            while(estudiante.canPickThing()==false){
               
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
                    while(estudiante.frontIsClear()==false){
                    estudiante.turnLeft();
                        
                        avenida[paredes]=estudiante.getStreet()*10+estudiante.getAvenue();
                        //System.out.println(avenida[paredes]);
                        
                        
                        //calle[paredes]=estudiante.getStreet();
                    
            //System.out.println(estudiante.getAvenue());
            //System.out.println(estudiante.getStreet());
                    //paredes++;
                    
                }
                estudiante.move();
                paredes++;
            }
            for(int i=0; i<100; i++){
                            for(int j=99; j>i; j--){
                                if(avenida[i]==avenida[j]){
                                    avenida[j]=0;
                                }
                            }
                        }
            /*102-101-90-81-71-62-52-41-31-21-10-1-2-3-14-24-34-25-16-7-8-9-20-29-38-
                    47-56-67-78-89-100-109-108-107-96-85-84-95-104-*/
            //estudiante.turnLeft();
            for(int i=0; i<100; i++){
                System.out.println(avenida[i]);
            }
            System.out.println("areaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            int area=0;
            for(int i=0; i<20; i++){
                for(int j=1; j<20; j++){
                if(calle[i]==calle[j] && avenida[i]!=avenida[j]){
                    int ap=avenida[j]-avenida[i]-1;
                    area=area+ap;
                    System.out.println(area);
                }
                
            }
            }
            System.out.println("El area es: "+area);
            System.out.println("Perimetro"+(paredes+1));
            //60 lados
            System.out.println("El area debe ser de 46m^2");
            //si fuera un rectangulo seria: 81= 9x9
            // 35 es lo que hay por fuera en area 
            // 40 movimientos
}
}
