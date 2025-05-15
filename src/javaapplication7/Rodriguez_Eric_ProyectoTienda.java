/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication7;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 *
 * @author Eric Rodriguez
 */
public class Rodriguez_Eric_ProyectoTienda {

    static Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");
    static double efectivocaja = 0.0;
    static int numerodeventas = 0;
    static int numerodecompras = 0;
    static double volumendeventas = 0.0;
    static double totaldecompras = 0.0;
    static double mayorganancia = 0.0;
    static double mayorgasto = 0.0;

    public static void main(String[] args) {
        boolean estadocaja = false;
        boolean ingresarefectivo = false;
        int opcion;
        int contadorazucar = 0;
        int contadoravena = 0;
        int contadortrigo = 0;
        int contadormaiz = 0;
        double cantidad = 0;
        boolean proveedorvalido = false;
        boolean seguircompra = false;
        boolean puedevender = false;

        do {
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
            switch (opcion) {
                case 1:
                    if (ingresarefectivo == false) {
                        System.out.print("Ingrese una cantidad en lempiras para comenzar: Lps. ");
                        cantidad = sc.nextDouble();

                        if (cantidad <= -1) {
                            System.out.println("Cantidad no valida intente de nuevo");
                        } else {
                            efectivocaja += cantidad;
                            System.out.println("Se ha agregado Lps. " + cantidad + " a caja");
                        }
                        numerodeventas = 0;
                        numerodecompras = 0;
                        volumendeventas = 0.0;
                        totaldecompras = 0.0;
                        mayorganancia = 0.0;
                        mayorgasto = 0.0;
                        estadocaja = true;
                        ingresarefectivo = true;
                    } else if (ingresarefectivo == true) {
                        System.out.print("Ingrese la cantidad a depositar en lempiras: Lps. ");
                        cantidad = sc.nextDouble();

                        if (cantidad <= -1) {
                            System.out.println("Cantidad no valida intente de nuevo");
                        } else {
                            efectivocaja += cantidad;
                            System.out.println("Se ha agregado Lps. " + cantidad + " a caja");
                        }
                    }
                    break;
                //VENTAS
                case 2:
                    if (estadocaja == true & puedevender == true) {
                        String tipodecliente = "";

                         do{
                            System.out.println("*****VENTA*******");
                            System.out.println("Ingrese el tipo de cliente: ");
                            System.out.println("A - Puede comprar cualquier producto");
                            System.out.println("B - Puede comprar producto: 1,2 y 3");
                            System.out.println("C - Puede comprar producto: 4");
                            tipodecliente = sc.nextLine().toUpperCase();
                            if (!tipodecliente.equals("A") && !tipodecliente.equals("B") && !tipodecliente.equals("C")) {
                                System.out.println("Tipo de cliente no valido, intente de nuevo!");
                                seguircompra = false;
                            } else{
                                seguircompra = true;
                            }
                        } while (!tipodecliente.equals("A") || !tipodecliente.equals("B") || !tipodecliente.equals("C"));

                        
                        double subtotalventa = 0.0;
                        String resumirventa = "";
                        double preciodelaventa = 0.0;
                        String nombredelproductoavender = "";

                            boolean puedecomprar = true;
                        do {
                            System.out.println("Ingrese el codigo del producto a vender \n1-Azucar - Lps. 30 x Kilo \n2-Avena - Lps. 25 x Kilo \n3-Trigo - Lps. 32 x Kilo \n4-Maiz - Lps. 20 x Kilo");
                            int codigoproducto = sc.nextInt();
                            sc.nextLine();
                             
                            if (codigoproducto == 1 && tipodecliente.equals("A") ||tipodecliente.equals("B")){
                                nombredelproductoavender = "Azucar";
                                preciodelaventa = 30.0;
                                puedecomprar = true;
                                seguircompra = false;
                                contadorazucar++;
                            } else if (codigoproducto == 2 && tipodecliente.equals("A") || tipodecliente.equals("B")){
                                nombredelproductoavender = "Avena";
                                preciodelaventa = 25.0;
                                puedecomprar = true;
                                seguircompra = false;
                                contadoravena++;
                            } else if (codigoproducto == 3 && tipodecliente.equals("A") || tipodecliente.equals("B")){
                                nombredelproductoavender = "Trigo";
                                preciodelaventa = 32.0;
                                puedecomprar = true;
                                seguircompra = false;
                                contadortrigo++;
                            } else if (codigoproducto == 4 && tipodecliente.equals("A") || tipodecliente.equals("C")){
                                nombredelproductoavender = "Maiz";
                                preciodelaventa = 20.0;
                                puedecomprar = true;
                                seguircompra = false;
                                contadormaiz++;
                            } else {
                                System.out.println("Lo siento, no puede comprar dicho producto, intente de nuevo");
                                seguircompra = true;
                                puedecomprar = false;
                            }

                           /* switch (codigoproducto) {
                                case 1:
                                    sc.next();
                                    if (tipodecliente.equals("A") || tipodecliente.equals("B")) {
                                        nombredelproducto = "Azucar";
                                        preciodelaventa = 30.0;
                                        puedecomprar = true;
                                        seguircompra = false;
                                        contadorazucar++;
                                    } else {
                                        System.out.println("No puede comprar el producto");
                                        seguircompra = true;
                                    }
                                    break;
                                case 2:
                                    sc.next();
                                    if (tipodecliente.equals("A") || tipodecliente.equals("B")) {
                                        nombredelproducto = "Avena";
                                        preciodelaventa = 25.0;
                                        puedecomprar = true;
                                        seguircompra = false;
                                        contadoravena++;
                                    } else {
                                        System.out.println("No puede comprar este producto");
                                        puedecomprar = false;
                                        seguircompra = true;
                                    }
                                    break;
                                case 3:
                                    sc.next();
                                    if (tipodecliente.equals("A") || tipodecliente.equals("B")) {
                                        nombredelproducto = " Trigo";
                                        preciodelaventa = 32.0;
                                        puedecomprar = true;
                                        seguircompra = false;
                                        contadortrigo++;
                                    } else {
                                        System.out.println("No puede comprar este producto");
                                        puedecomprar = false;
                                        seguircompra = true;
                                    }
                                    break;
                                case 4:
                                    sc.next();
                                    if (tipodecliente.equals("A") || tipodecliente.equals("C")) {
                                        puedecomprar = true;
                                        nombredelproducto = "Maiz";
                                        preciodelaventa = 20.0;
                                        seguircompra = false;
                                        contadormaiz++;
                                    } else {
                                        System.out.println("No puede comprar este producto ");
                                        puedecomprar = false;
                                        seguircompra = true;
                                    }
                                    break;
                                default:
                                    System.out.println("Codigo de producto no valido");
                                    seguircompra = true; */
                            

                            if (puedecomprar = true) {
                                System.out.println("Su producto es: " + nombredelproductoavender + ",Precio por Kilogramos: Lps." + preciodelaventa);
                                System.out.println("Ingrese la cantidad en Kilogramos a comprar: ");
                                double cantidadkilo = sc.nextDouble();
                                sc.nextLine();
                                double subtotalproducto = cantidadkilo * preciodelaventa;
                                subtotalventa += subtotalproducto;
                                resumirventa += cantidadkilo + "Kilogramos de " + nombredelproductoavender + " a Lempiras " + preciodelaventa + "= Lps." + subtotalproducto + "\n";
                            } else {
                                System.out.println("No puede comprar el producto");
                            }

                            System.out.println("Desea comprar mas productos? (si/no)");
                            String respuestasino = sc.nextLine().toLowerCase();
                            if (respuestasino.equals("si")) {
                                seguircompra = true;
                            } else if (respuestasino.equals("no")) {
                                seguircompra = false;
                            }
                        } while (seguircompra == true);

                        System.out.println("\n********F A C T U R A **********");
                        System.out.println(resumirventa);

                        double descuento = 0.0;
                        if (subtotalventa >= 5000) {
                            descuento = subtotalventa * 0.10;
                            System.out.println("Descuento aplicado (10%): Lps. " + String.format("%.2f", descuento));
                        } else if (subtotalventa >= 1000) {
                            descuento = subtotalventa * 0.05;
                            System.out.println("Descuento aplicado (5%) : Lps. " + String.format("%.2f", descuento));
                        } else {
                            System.out.println("Descuento aplicado (0%) : Lps. 0.00 ");
                        }

                        double subtotalcondescuento = subtotalventa - descuento;
                        double impuesto = subtotalcondescuento * 0.07;
                        System.out.println("Impuesto (7%): Lps." + String.format("%.2f", impuesto));
                        double totalapagar = subtotalcondescuento + impuesto;
                        System.out.println("Su total a pagar es de: Lps. " + String.format("%.2f", totalapagar));

                        efectivocaja += totalapagar;
                        System.out.println("Efectivo en caja: Lps." + efectivocaja);

                        numerodeventas++;
                        volumendeventas += totalapagar;
                    } else if (estadocaja == false) {
                        System.out.println("Caja Cerrada, Favor intente de nuevo");
                    } else if (puedevender == false){
                        System.out.println("Necesita comprar producto para comenzar a vender");
                    }
                    break;
                    
                //COMPRAS
                   
                case 3:
                    String nombredelproducto = "";
                        double preciodelacompra = 0.0;
                        boolean hayproducto = false;
                         
                    if (estadocaja == true ){
                         boolean proveedorr = false;
                          boolean productovalido = false;
                        do{
                        System.out.println("Favor ingrese el tipo de proveedor");
                        System.out.println("A - Producto codigo 1 y 4\nB - Productos con codigo 2 y 3\nC - Producto con codigo 2");
                        String proveedor = sc.nextLine().toUpperCase();
                        proveedorr = true;
                        if (proveedor.equals("A") || proveedor.equals("B") || proveedor.equals("C")){
                            proveedorr = true;
                             
                            do { 
                                System.out.println("Ingrese el codigo del producto a comprar \n1-Azucar\n2-Avena\n3-Trigo\n4-Maiz ");
                                int productoacomprar = sc.nextInt();
                                if (productoacomprar == 1 && proveedor.equals("A")) {
                                  nombredelproducto = "Azucar";
                                  preciodelacompra = 25.0;
                                  hayproducto = true; 
                                  productovalido = true;
                                } else if (productoacomprar == 2 && proveedor.equals("B"))     {
                                  nombredelproducto = "Avena";
                                  preciodelacompra = 20.0;
                                  hayproducto = true;
                                  productovalido = true;
                                } else if (productoacomprar == 2 && proveedor.equals("C"))  {
                                  nombredelproducto = "Avena";
                                  preciodelacompra = 22.0;
                                  hayproducto = true;
                                  productovalido = true;
                                } else if (productoacomprar == 3 && proveedor.equals("B")) {
                                  nombredelproducto = "Trigo";
                                  preciodelacompra = 30.0;
                                  hayproducto = true;
                                  productovalido = true;
                                } else if (productoacomprar == 4 && proveedor.equals("A")) {
                                   nombredelproducto = "Maiz";
                                  preciodelacompra = 18.0;
                                  hayproducto = true;
                                   productovalido = true;
                                } else {
                                    System.out.println("Este proveedor no vende dicho producto");
                                    productovalido = false;
                                }                        
                            } while (productovalido == false );
                             
                        } else  {
                            System.out.println("Proveedor no valido intente de nuevo");
                             proveedorr = false;
                        }
                        } while (proveedorr == false);
                        
                        System.out.print("El proveedor vende " +nombredelproducto+ "\nIngrese la cantidad de kilogramos a comprar: Kg.  ");  
                        double kilogramosacomprar = sc.nextDouble();
                        double totaldecompra = preciodelacompra * kilogramosacomprar;
                        efectivocaja -= totaldecompra;
                        System.out.println("");
                        System.out.println("**** FACTURA DE LA COMPRA ****");
                        System.out.println("Kilogramos de " +nombredelproducto+ " comprados: Kg. "+kilogramosacomprar);
                        System.out.println("Total a pagar: Lps. "+totaldecompra);
                        System.out.println("Compra realizada, monto restante: Lps. "+efectivocaja);
                        System.out.println("");
                        numerodecompras++;
                        puedevender = true;
                    } else if (estadocaja == false) {
                        System.out.println("Caja Cerrada, Favor intente de nuevo");
                        
                    }  
                        break; 
                case 4:
                    if (estadocaja == true) {
                        double margenganancia = volumendeventas - totaldecompras;
                        double valormventa = (numerodeventas > 0) ? (volumendeventas / numerodeventas) : 0;
                        double valormcompra = (numerodecompras > 0) ? (totaldecompras / numerodecompras) : 0;
                        System.out.println("********REPORTES********");
                        System.out.println("a. Cantidad en caja: Lps." + efectivocaja);
                        System.out.println("b. Numero de compras: " + numerodecompras + "\nNumero de Ventas: " + numerodeventas);
                        System.out.println("c. Volumen Total de Compras: " + volumendeventas + "\nVentas efectuadas: " + numerodeventas + "\nMargen de ganancia: Lps. " + margenganancia);
                        System.out.println("d. Valor medio de venta: " + valormventa + " %\nValor medio de compra: Lps. " + valormcompra + " %");
                        System.out.println("e. Venta con mayor ganancia: Lps. \nCompra con mas gasto efectuada: ");

                        String productoestrella = "";
                        if (contadorazucar > contadortrigo && contadorazucar > contadormaiz && contadorazucar > contadoravena) {
                            productoestrella = "Azucar";
                        } else if (contadoravena > contadortrigo && contadoravena > contadormaiz && contadoravena > contadorazucar) {
                            productoestrella = "Avena";
                        } else if (contadortrigo > contadoravena && contadortrigo > contadormaiz && contadortrigo > contadorazucar) {
                            productoestrella = "Trigo";
                        } else {
                            productoestrella = "Maiz";
                        }
                        System.out.println("f. Producto estrella del dia: " + productoestrella);
                    } else if (estadocaja == false) {
                        System.out.println("Caja Cerrada, Favor intente de nuevo");
                    }
                    break;

                case 5:
                    if (estadocaja == true) {
                        estadocaja = false;
                        System.out.println("********CIERRE DE CAJA********");
                        double gananciatot = volumendeventas - totaldecompras;
                        System.out.println("La ganancia total en el dia es de Lps. " + gananciatot);
                        System.out.println("Efectivo a la hora de cierre: Lps. " + efectivocaja);
                        System.out.println("Cuanto desea depositar en el banco? (Maximo el 60%)");
                        double maximodepo = (efectivocaja * 0.60);
                        System.out.println("El maximo a depositar el dia de hoy seria: Lps. " + maximodepo);
                        double deposito = sc.nextDouble();
                        double depositofin = efectivocaja * 0.60;
                        if (deposito > depositofin) {
                            System.out.println("La cantidad excede el 60%");
                        }
                    } else if (estadocaja == false) {
                        System.out.println("Caja Cerrada, Favor intente de nuevo");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema. Que tenga buen dia");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion no valida, Intente de nuevo");
            }
        } while (opcion != 6);
    }
}

