package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cantidadproducto;
        int indiceproducto;
        int indiceproductomayor;
        int indicesucursal;
        double montomayor;
        double montoporsucursal;
        String nombreproductomayor;
        double precioproducto;
        int producto;
        String producto_matrix[];
        double producto_precio_matrix[];
        double producto_sucursal_cantidad[][];
        double producto_sucursal_monto[][];
        int sucursal;
        String sucursal_matrix[];
        double total;
        double unidades;
        double vendedor;
        String vendedor_matrix[];
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
        // Dimension VENTAS(5, 4)
        producto_sucursal_monto = new double[4][4];
        producto_sucursal_cantidad = new double[4][4];
        // Se indica el ingreso de datos del vendedor.
        System.out.println("Ingrese el codigo de vendedor [0=Percy; 1= Felipe; 2=Alejandra; 3=Jorge; 4=Juan; -1=Fin]");
        vendedor = sc.nextInt();
        // Si vendedor es -1 se dejará de ingresar datos de vendedores.
        while (vendedor!=-1) {
            System.out.println("Ingrese el codigo de Sucursal [0=Arequipa; 1= Trujillo; 2=Lima; 3=Cuzco; -1=Fin]");
            sucursal = sc.nextInt();
            // Se indica el ingreso de datos del producto.
            System.out.println("Ingrese el codigo de producto [0=Pollo; 1=Carne; 2=Cerdo; 3=Pavo; -1=Fin]");
            producto = sc.nextInt();
            // Inicializamos la variable sumatoria de las ventas del vendedor en la sucursal.
            montoporsucursal = 0;
            while (producto!=-1) {
                System.out.println("Ingrese la cantidad vendida");
                unidades = sc.nextInt();
                // Recupera el precio del producto en el arreglo PRODUCTO_PRECIO_MATRIX.
                precioproducto = producto_precio_matrix[producto];
                // Calculamos el monto total de la venta del producto.
                total = precioproducto*unidades;
                // Sumar el monto total en la variable montoPorSucursal
                // montoPorSucursal = montoPorSucursal + total
                // Grabamos el total del producto en la sucursal en curso.
                producto_sucursal_monto[sucursal][producto] = producto_sucursal_monto[sucursal][producto]+total;
                producto_sucursal_cantidad[sucursal][producto] = producto_sucursal_cantidad[sucursal][producto]+unidades;
                System.out.println("Ingrese el codigo de producto [0=Pollo; 1=Carne; 2=Cerdo; 3=Pavo; -1=Fin]");
                producto = sc.nextInt();
            }
            // Grabamos la venta del vendedor en la sucursal actual para posterior uso en el indicador.
            // VENTAS(vendedor, sucursal) = montoPorSucursal
            // Se vuelve a ingresar el vendedor.
            System.out.println("Ingrese el codigo de vendedor [0=Percy; 1= Felipe; 2=Alejandra; 3=Jorge; 4=Juan; -1=Fin]");
            vendedor = sc.nextDouble();
        }
        System.out.println("Se termino el ingreso de datos");
        System.out.println("Generando indicador");
        for (indicesucursal=0;indicesucursal<=3;indicesucursal++) {
            System.out.println(sucursal_matrix[indicesucursal]+": ");
            // contSucursal = 0
            montomayor = 0;
            cantidadproducto = 0;
            nombreproductomayor = "";
            indiceproductomayor = 0;
            for (indiceproducto=0;indiceproducto<=3;indiceproducto++) {
                if (producto_sucursal_monto[indicesucursal][indiceproducto]>montomayor) {
                    montomayor = producto_sucursal_monto[indicesucursal][indiceproducto];
                    cantidadproducto = producto_sucursal_cantidad[indicesucursal][indiceproducto];
                    nombreproductomayor = producto_matrix[indiceproducto];
                    indiceproductomayor = indiceproducto;
                }
            }
            if (montomayor>0) {
                System.out.println("    El producto "+nombreproductomayor+" es el mas vendido en la sucursal con una cantidad de "+cantidadproducto+" al precio de S/. "+producto_precio_matrix[indiceproductomayor]);
                System.out.println("    Se ha generado un total de "+montomayor);
            }
        }
    }
}