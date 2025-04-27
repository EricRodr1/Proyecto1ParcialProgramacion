/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication7;

import java.util.Scanner;

/**
 *
 * @author Eric Rodriguez
 */
public class JavaApplication7 {
static Scanner sc = new Scanner (System.in);
static double efectivocaja = 0.0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    
        int opcion;
         
        do{
        System.out.println("**** BIENVENIDO A LA TIENDA ****");
        System.out.println("Seleccione una opcion para comenzar!!");
        System.out.println("1. ABRIR CAJA");
        System.out.println("2. VENTAS");
        System.out.println("3. COMPRAS");
        System.out.println("4. REPORTES");
        System.out.println("5. CIERRE DE CAJA");
        System.out.println("6. SALIR DEL SISTEMA");
        opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion){
            case 1 :
                abrircaja();
                break;
                case 2 :
                hacerventa();
                break;
                case 3 :
                compra();
                break;
                case 4 :
                reportes();
                break;
                case 5 :
                cierrecaja();
                break;
                case 6 :
                    System.out.println("Saliendo del sistema");
                break;
                default:
                    System.out.println("Opcion no valida, Intente de nuevo");
        }                
        } while (opcion != 6);
       } 
    static void abrircaja(){
        System.out.println("Ingrese la cantidad a depositar en lempiras");
        double cantidad = sc.nextDouble();
        efectivocaja += cantidad;
        System.out.println("Se ha agregado Lps. "+cantidad+"a caja");
    }
    static void hacerventa(){
        
    }
    }
  
        
               
                
                    
                
            
        

        
    

    
    

