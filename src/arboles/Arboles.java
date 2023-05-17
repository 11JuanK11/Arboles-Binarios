/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author 57301
 */
public class Arboles {

    /**
     * @param args the command line arguments
     * gbadcfhm
     */
    public static void main(String... args) {
        String S = "hdkaeinp";
        ArbolBinario A = new ArbolBinario();
        A.Construir(S);
        A.Mostrar_Arbol();
    }
    
}
