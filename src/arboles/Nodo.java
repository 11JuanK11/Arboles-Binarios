/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;
public class Nodo {
    private Nodo Lizq;
    private Nodo Lder;
    private char Dato;

    public Nodo() {
        Lizq = null;
        Lder = null;
        Dato = ' ';
    }
    
    public Nodo(char C) {
        Lizq = null;
        Lder = null;
        Dato = C;
    }

    public Nodo getLizq() {
        return Lizq;
    }

    public void setLizq(Nodo Lizq) {
        this.Lizq = Lizq;
    }

    public Nodo getLder() {
        return Lder;
    }

    public void setLder(Nodo Lder) {
        this.Lder = Lder;
    }

    public char getDato() {
        return Dato;
    }

    public void setDato(char Dato) {
        this.Dato = Dato;
    }
    
    
    

    
    
}

