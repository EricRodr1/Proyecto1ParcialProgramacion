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
                System.out.println("Ingrese la cantidad a depositar en lempiras");
        double cantidad = sc.nextDouble();
        efectivocaja += cantidad;
        System.out.println("Se ha agregado Lps. "+cantidad+" a caja");
                break;
                
                case 2 :
                System.out.println("*****VENTA*******");
        System.out.println("Ingrese el tipo de cliente: ");
        //TRANSFORMAR A MAYUSCULA
        //ESTUDIAR E INVESTIGAR
        String tipodecliente = sc.nextLine().toUpperCase();
        if (!tipodecliente.equals("A") && !tipodecliente.equals("B") && !tipodecliente.equals("C") ) {
            System.out.println("Tipo de cliente no valido, intente de nuevo!");
            return;
        }
        boolean seguircompra = true;
        double subtotalventa =0.0;
        //Guardar el resumen de los productos vendidos
        String resumirventa = "";
        
        while(seguircompra){
            System.out.println("Ingrese el codigo del producto a vender 1-Azucar 2-Avena 3-Trigo 4-Maiz");
            int codigoproducto = sc.nextInt();
            String nombredelproducto = "";
            double preciodelaventa = 0.0;
            boolean puedecomprar = true;
            
            switch (codigoproducto){
                case 1:
                    nombredelproducto = "Azucar";
                    preciodelaventa = 30.0;
                    puedecomprar = true;
                    break;
                case 2:
                    nombredelproducto = "Avena";
                    preciodelaventa = 25.0;  
                    if (tipodecliente.equals("A") || tipodecliente.equals("C")){
                       puedecomprar = true;
                       
                    }
                    break;
                case 3:
                    nombredelproducto = " Trigo";
                    preciodelaventa = 32.0;
                    if (tipodecliente.equals("A") || tipodecliente.equals("B")){
                        puedecomprar = true;
                    }
                    break;
                case 4:
                    nombredelproducto = "Maiz";
                    preciodelaventa = 20.0;
                    if(tipodecliente.equals("A") || tipodecliente.equals("C")){
                        puedecomprar = true;
                    }
                    break;
            }
            //?
            if(nombredelproducto.equals("")){
                continue;
            }
            if (puedecomprar){
                System.out.println("Su producto es: "+nombredelproducto+",Precio por Kilogramos: Lps."+preciodelaventa);
                System.out.println("Ingrese la cantidad en Kilogramos a comprar: ");
                double cantidadkilo = sc.nextDouble();
                
                double subtotalproducto = cantidadkilo * preciodelaventa;
                subtotalventa += subtotalproducto;
                resumirventa += cantidadkilo + "Kilogramos de "+nombredelproducto+ " a Lempiras " +preciodelaventa+ "= Lps." +subtotalproducto + "\n";
                        
            }else{
                System.out.println("No puede comprar el producto");
            }
            System.out.println("Desea comprar mas productos? (si/no)");
            String respuestasino = sc.nextLine().toLowerCase();
            if(!respuestasino.equals("si")){
                seguircompra = false;
            }
        }
        //FACTURA
        System.out.println("\n********F A C T U R A **********");
        System.out.println(resumirventa);
        
        double descuento = 0.0;
        if (subtotalventa >= 5000){
            descuento = subtotalventa *0.10;
            System.out.println("Descuento aplicado: Lps."+ descuento);
        } else if (subtotalventa >= 1000){
            descuento = subtotalventa * 0.05;
            System.out.println("Descuento aplicado: Lps. "+ descuento);
        } else {
            System.out.println("Su compra no aplica a descuento");
        }
        double subtotalcondescuento = subtotalventa - descuento;
        double impuesto = subtotalcondescuento * 0.07;
        System.out.println("Su impuesto es de: Lps."+ impuesto);
        double totalapagar = subtotalcondescuento + impuesto;
        System.out.println("Su total a pagar es de: Lps. "+efectivocaja);
        
        efectivocaja += totalapagar;
        System.out.println("Efectivo en caja: Lps."+efectivocaja);
        
        
                break;
                case 3 :
                    //Ventas
                     
                    System.out.println("Favor ingrese el tipo de proveedor");
                    String proveedor = sc.next();
                    if (!proveedor.equals("A") && !proveedor.equals("B") && !proveedor.equals("C") && !proveedor.equals("a") && !proveedor.equals("b") && !proveedor.equals("c")){
                        System.out.println("Tipo de proveedor no valido. Intente de nuevo");
                        return;
                    }
                    System.out.println("Ingrese el código del producto a comprar (1-Azúcar, 2-Avena, 3-Trigo, 4-Maíz): ");
                    int codigoproducto = sc.nextInt();
                    
                    String nombredelproducto ="";
                    double preciodelacompra = 0.0;
                    boolean hayproducto = false;
                    
                    switch (codigoproducto){
                        case 1:
                            nombredelproducto = "Azucar";
                            if(proveedor.equals("A") && proveedor.equals("a")){
                                preciodelacompra = 25.0;
                                hayproducto = true;
                            }
                            break;
                        case 2:
                            nombredelproducto = "Avena";
                            if (proveedor.equals("B") || proveedor.equals("b") || proveedor.equals("C") || proveedor.equals("c")){
                                if (proveedor.equals("B") || proveedor.equals("b")){
                                    preciodelacompra = 20.0;
                                    
                                }else{
                                    preciodelacompra = 22.0;
                                }
                                hayproducto = true;
                            }
                            break;
                        case 3:
                            nombredelproducto = "Trigo";
                            if (proveedor.equals("B") || proveedor.equals("b")){
                                preciodelacompra = 30.0;
                                hayproducto = true;
                                
                            }
                            break;
                        default:
                            System.out.println("Opcion no valida. Intente de nuevo");
                            break;
                    }
                    if(!nombredelproducto.equals("") && hayproducto){
                        System.out.println("Proveedor:"+proveedor+"vende:" +nombredelproducto);
                        double cantidadacomprar = sc.nextDouble();
                        double totalacomprar = cantidadacomprar * preciodelacompra;
                        if (efectivocaja >= totalacomprar){
                            efectivocaja -= totalacomprar;
                            System.out.println("Compra realizada! Efectivo restante: Lps. "+efectivocaja);
                            
                            
                         }else {
                            System.out.println("No se puede realizar la compra. Efectivo insuficiente");
                        }
                        
                    }else if (!nombredelproducto.equals("")){
                        System.out.println("Este proveedor no vende este producto");
                        
                    }
                    System.out.println("Fin de la compra");
                    
                    
                break;
                case 4 :
                //reportes();
                break;
                case 5 :
               // cierrecaja();
                break;
                case 6 :
                    System.out.println("Saliendo del sistema");
                break;
                default:
                    System.out.println("Opcion no valida, Intente de nuevo");
        }                
        } while (opcion != 6);
       } 
    
     
    
    }
  
        
               
                
                    
                
            
        

        
    

    
    

