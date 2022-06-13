
package Main;

import DAO.*;
import Entidades.*;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        Clientes c = new Clientes();
        ClientesDAO cd = new ClientesDAO();
        Operaciones o = new Operaciones();
        OperacionesDAO od = new OperacionesDAO();

        //menu para elegir entre insertar un cliente o imprimir todos los clientes por consola
        System.out.println("1. Insertar Cliente");
        System.out.println("2. Imprimir todos los clientes");
        System.out.println("3. Imprimir todas las operaciones");
        System.out.println("4. Insertar Una Operacion");
        System.out.println("5. Encontrar un cliente por nombre");
        System.out.println("6. Encontrar operaciones de mas de x cantidad");
        System.out.println("7. Encontrar todos los clientes que han hecho operaciones");
        System.out.println("8. Salir");

        int opcion=0;
        while (opcion!=7){
        opcion=tcl.nextInt();
            switch(opcion){
            case 1:
                System.out.println("Introduce el nombre del cliente");
                c.setNombre(tcl.nextLine());
                System.out.println("Introduce el apellido del cliente");
                c.setApellidos(tcl.nextLine());
                cd.insertar(c);
                break;
            case 2:
                //imprimir por pantalla todos los clientes
                cd.EncontrarTodos().forEach(lista->{System.out.println(lista.toString());});

                break;
            case 3:
                //imprimir por pantalla todas las operaciones
                od.EncontrarTodos().forEach(lista->{System.out.println(lista.toString());});
                break;
            case 4:
                //insertar una operacion
                System.out.println("Introduce la cantidad de la operacion");
                //se comprueba que el valor introducido es un numero entero positivo
                int cantidad = tcl.nextInt();
                if (cantidad > 0) {
                    o.setCantidad(cantidad);
                } else {
                    System.out.println("Introduce un numero entero positivo");
                }

                o.setCantidad(tcl.nextInt());
                System.out.println("Introduce la fecha en la cual se realizo la operacion formato dd/mm/aaaa");
                //se comprueba que tiene un formato de dia mes año valido separado por /
                if(tcl.nextLine().matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")){
                    o.setFecha(tcl.nextLine());
                }else {
                    System.out.println("Formato de fecha invalido");
                }
                od.insertar(o);
                break;
            case 5:
                //salir
                System.out.println("Introduce el nombre del cliente");
                String nombre = tcl.nextLine();
                cd.EncontrarPorNombre(nombre).forEach(lista->{System.out.println(lista.toString());});
                break;
            case 6:
                System.out.println("Introduce las operacioens de mas de x cantidad que quieres encontrar");
                int cantidad2 = tcl.nextInt();
                od.EncontrarPorCantidad(cantidad2).forEach(lista->{System.out.println(lista.toString());});
                break;
            case 7:
                cd.EncontrarPorOperaciones().forEach(lista->{System.out.println(lista.toString());});
                break;
            case 8:
                System.out.println("Saliendo");
                break;
            default:
                System.out.println("Opcion no valida");
                break;





        }
    }}

}