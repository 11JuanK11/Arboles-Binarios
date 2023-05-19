package arboles;

public class Nodo {
    private char Dato;
    private int FB;
    private Nodo Lizq, Lder;

    public Nodo() {
        this.Dato = ' ';
        this.FB = 0;
        this.Lizq = null;
        this.Lder = null;
    }

    public Nodo(char Dato) {
        this.Dato = Dato;
        this.FB = 0;
        this.Lizq = null;
        this.Lder = null;
    }

    public char getDato() {
        return Dato;
    }

    public void setDato(char Dato) {
        this.Dato = Dato;
    }

    public int getFB() {
        return FB;
    }

    public void setFB(int FB) {
        this.FB = FB;
    }

    public Nodo getLizq() {
        return Lizq;
    }

    public void setLizq(Nodo LI) {
        this.Lizq = LI;
    }

    public Nodo getLder() {
        return Lder;
    }

    public void setLder(Nodo LD) {
        this.Lder = LD;
    }
    
}