package arboles;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Arboles {

    public static void main(String[] args) {
        ArbolBinario A = new ArbolBinario();
        Scanner Leer = new Scanner(System.in);
        String S = "";
        int Opc = 0;

        System.out.println("Ingrese los caracteres del arbol: ");
        S = Leer.next();
        A.Construir(S);

        do {
            System.out.println("");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Insertar Dato.\n"
                    + "2. Mostrar Arbol.\n"
                    + "3. Recorrer Arbol. \n"
                    + "4. Tipos de Contar. \n"
                    + "5. Tipos de Mostrar . \n"
                    + "6. Salir.");
            Opc = Leer.nextInt();

            switch (Opc) {
                case 1:
                    String Dato;
                    System.out.println("Ingrese el dato nuevo: ");
                    Dato = Leer.next();
                    Nodo C = A.Buscar(A.Punta, Dato.charAt(0));
                    if (C == null){
                        Nodo X = new Nodo(Dato.charAt(0));
                        A.Insertar(A.Punta, X);
                        A.AVL();
                    }else{
                        System.out.println("El dato ya existe en el arbol.");
                    }
                    break;

                case 2:
                    A.Mostrar_Arbol();
                    break;

                case 3:
                    do {
                        System.out.println("");
                        System.out.println("MENU RECORRIDOS");
                        System.out.println("1. Recorrido Inorden.\n"
                                + "2. Recorrido Preorden.\n"
                                + "3. Recorrido Posorden. \n"
                                + "4. Volver.");
                        Opc = Leer.nextInt();

                        switch (Opc) {
                            case 1:
                                A.InOrden(A.Punta);
                                break;

                            case 2:
                                A.PreOrden(A.Punta);
                                break;

                            case 3:
                                A.PosOrden(A.Punta);
                                break;

                            case 4:
                                break;

                            default:
                                JOptionPane.showInternalMessageDialog(null, "Opcion incorrecta.");
                        }
                    } while (Opc != 4);
                    break;

                case 4:
                    do {
                        System.out.println("");
                        System.out.println("MENU CONTAR");
                        System.out.println("1. Contar Padres.\n"
                                + "2. Contar hojas.\n"
                                + "3. Padres con un solo hijo. \n"
                                + "4. Volver.");
                        Opc = Leer.nextInt();

                        switch (Opc) {
                            case 1:
                                System.out.println("\nLa cantidad de padres son " + A.CantPadres(A.Punta, 0));
                                break;

                            case 2:
                                System.out.println("\nLa cantidad de hojas son " + A.CantHojas(A.Punta, 0));
                                break;

                            case 3:
                                System.out.println("\nLa cantidad de padres con un solo hijo son " + A.CantHijosUnicos(A.Punta, 0));
                                break;

                            case 4:
                                break;

                            default:
                                JOptionPane.showInternalMessageDialog(null, "Opcion incorrecta.");
                        }
                    } while (Opc != 4);
                    
                case 5:
                    do {
                        System.out.println("");
                        System.out.println("MENU MOSTRAR");
                        System.out.println("1. Mostrar hermanos de un dato.\n"
                                + "2. Mostrar el nivel de un dato.\n"
                                + "3. Mostrar la altura de un dato. \n"
                                + "4. Mostrar los primos de un dato. \n"
                                + "5. Mostrar los ancestros de un dato. \n"
                                + "0. Volver.");
                        Opc = Leer.nextInt();
                        Nodo B = null;
                        String Dato2 = "";
                        if (Opc != 0){
                            System.out.println("Ingrese el dato: ");
                            Dato2 = Leer.next();
                            B = A.Buscar(A.Punta, Dato2.charAt(0));
                        }

                        switch (Opc) {
                            case 1:
                                if (B != null){
                                    A.Mostrar_Hermano(Dato2.charAt(0));
                                }else{
                                    System.out.println("El dato no se encuentra en el arbol.");
                                }
                                break;

                            case 2:
                                if (B != null){
                                    System.out.println("El nivel de " + Dato2 + " es " + A.Nivel(A.Punta, Dato2.charAt(0)));
                                }else{
                                    System.out.println("El dato no se encuentra en el arbol.");
                                }
                                break;

                            case 3:
                                if (B != null){
                                    System.out.println("La altura de " + Dato2 + " es " + A.Altura(B));
                                }else{
                                    System.out.println("El dato no se encuentra en el arbol.");
                                }
                                break;

                            case 4:
                                if (B != null){
                                    A.PrimosHermanos(Dato2.charAt(0));
                                }else{
                                    System.out.println("El dato no se encuentra en el arbol.");
                                }
                                break;

                            case 5:
                                if (B != null){
                                    A.Ancestros(A.Punta, Dato2.charAt(0));
                                }else{
                                    System.out.println("El dato no se encuentra en el arbol.");
                                }
                                break;

                            case 0:
                                break;

                            default:
                                JOptionPane.showInternalMessageDialog(null, "Opcion incorrecta.");
                        }
                    } while (Opc != 0);

                case 6:
                    break;

                default:
                    JOptionPane.showInternalMessageDialog(null, "Opcion incorrecta.");
            }
        } while (Opc != 6);
    }
}