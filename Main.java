package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contadorsucursal;
        int contadorvendedor;
        double montomayor;
        double montoporsucursal;
        double precioproducto;
        int producto;
        String producto_matrix[];
        double producto_precio_matrix[];
        int sucursal;
        int sucursalconmayorventa;
        String sucursal_matrix[];
        double total;
        double unidades;
        int vendedor;
        int vendedorconmayorventa;
        String vendedor_matrix[];
        double ventas[][];
        // Se declara matriz de datos de 5 vendedores.
        vendedor_matrix = new String[5];
        vendedor_matrix[0] = "Percy    ";
        vendedor_matrix[1] = "Felipe   ";
        vendedor_matrix[2] = "Alejandra";
        vendedor_matrix[3] = "Jorge    ";
        vendedor_matrix[4] = "Juan     ";
        // Se declara matriz de datos de 4 sucursales.
        sucursal_matrix = new String[4];
        sucursal_matrix[0] = "Arequipa";
        sucursal_matrix[1] = "Trujillo";
        sucursal_matrix[2] = "Lima";
        sucursal_matrix[3] = "Cuzco";
        // Se declara matriz de datos de 4 productos.
        producto_matrix = new String[4];
        producto_matrix[0] = "Pollo";
        producto_matrix[1] = "Carne";
        producto_matrix[2] = "Cerdo";
        producto_matrix[3] = "Pavo";
        // Se declara matriz de datos de precios de los 4 productos declarados lineas arriba.
        producto_precio_matrix = new double[4];
        producto_precio_matrix[0] = 12;
        producto_precio_matrix[1] = 20;
        producto_precio_matrix[2] = 25;
        producto_precio_matrix[3] = 6;
        // Arreglo donde se almacenará las ventas de vendedor por sucursal.
        ventas = new double[5][4];
        // Se indica el ingreso de datos del vendedor.
        System.out.println("Ingrese el codigo de vendedor [0=Percy; 1= Felipe; 2=Alejandra; 3=Jorge; 4=Juan; -1=Fin]");
        vendedor = sc.nextInt();
        // Si vendedor es -1 se dejará de ingresar datos de vendedores.
        while (vendedor!=-1) {
            System.out.println("Ingrese el codigo de Sucursal [0=Arequipa; 1= Trujillo; 2=Lima; 3=Cuzco; -1=Fin]");
            sucursal = sc.nextInt();
            // Se indica el ingreso de datos del producto.
            System.out.println("Ingrese el codigo de producto  [0=Pollo; 1=Carne; 2=Cerdo; 3=Pavo; -1=Fin]");
            producto = sc.nextInt();
            // Inicializamos la variable sumatoria de las ventas del vendedor en la sucursal.
            montoporsucursal = 0;
            while (producto!=-1) {
                System.out.println("Ingrese la cantidad vendida");
                unidades = sc.nextDouble();
                // Recupera el precio del producto en el arreglo PRODUCTO_PRECIO_MATRIX.
                precioproducto = producto_precio_matrix[producto];
                // Calculamos el monto total de la venta del producto.
                total = precioproducto*unidades;
                // Sumar el monto total en la variable montoPorSucursal
                montoporsucursal = montoporsucursal+total;
                System.out.println("Ingrese el codigo de producto [0=Pollo; 1=Carne; 2=Cerdo; 3=Pavo; -1=Fin]");
                producto = sc.nextInt();
            }
            // Grabamos la venta del vendedor en la sucursal actual para posterior uso en el indicador.
            ventas[vendedor][sucursal] = montoporsucursal;
            // Se vuelve a ingresar el vendedor.
            System.out.println("Ingrese el codigo de vendedor [0=Percy; 1= Felipe; 2=Alejandra; 3=Jorge; 4=Juan; -1=Fin]");
            vendedor = sc.nextInt();
        }
        System.out.println("Se termino el ingreso de datos");
        System.out.println("Generando indicador");
        montomayor = 0;
        vendedorconmayorventa = 0;
        sucursalconmayorventa = 0;
        // Recorremos el arreglo de vendedores
        for (contadorvendedor=0;contadorvendedor<=4;contadorvendedor++) {
            for (contadorsucursal=0;contadorsucursal<=3;contadorsucursal++) {
                // Compara montoTotal de venta vendedor-sucursal por el 'monto mayor'
                if (ventas[contadorvendedor][contadorsucursal]>montomayor) {
                    // Conversamos el mayor monto de venta.
                    montomayor = ventas[contadorvendedor][contadorsucursal];
                    // Conservamos el vendedor con la mayor venta.
                    vendedorconmayorventa = contadorvendedor;
                    // Conservamos la sucursal con la mayor venta.
                    sucursalconmayorventa = contadorsucursal;
                }
            }
        }
        System.out.println("El mayor importe de ventas lo ha obtenido el vendedor "+vendedor_matrix[vendedorconmayorventa]+" en la sucursal "+sucursal_matrix[sucursalconmayorventa]);
    }
}