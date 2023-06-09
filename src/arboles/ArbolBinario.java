package arboles;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ArbolBinario {

    Nodo Punta;

    public void Construir(String Cadena) {
        char[] A = Cadena.toCharArray();
        int i = 0;
        Nodo x, p;

        while (i < A.length) {
            x = new Nodo(A[i]);
            p = Punta;
            Insertar(p, x);
            if (i > 1) {
                AVL();
            }
            i++;
        }
    }

    public void Recorrer(Nodo R) {
        Nodo P = R;
        while (P != null) {
            if (P.getLizq() != null) {
                Recorrer(P.getLizq());
            } else {
                System.out.println(P.getDato());
            }
            P = P.getLder();
        }
    }

    public void Insertar(Nodo p, Nodo x) {
        if (p == null) {
            Punta = x;
        } else {
            if (p.getDato() > x.getDato()) {
                if (p.getLizq() == null) {
                    p.setLizq(x);
                } else {
                    p = p.getLizq();
                    Insertar(p, x);
                }
            } else {
                if (p.getDato() < x.getDato()) {
                    if (p.getLder() == null) {
                        p.setLder(x);
                    } else {
                        p = p.getLder();
                        Insertar(p, x);
                    }
                }
            }
        }
    }

    public void InOrden(Nodo R) {
        if (R != null) {
            InOrden(R.getLizq());
            System.out.print(R.getDato());
            InOrden(R.getLder());
        }
    }

    public void PreOrden(Nodo R) {
        if (R != null) {
            System.out.print(R.getDato());
            PreOrden(R.getLizq());
            PreOrden(R.getLder());
        }
    }

    public void PosOrden(Nodo R) {
        if (R != null) {
            PosOrden(R.getLizq());
            PosOrden(R.getLder());
            System.out.print(R.getDato());
        }
    }

    public int CantHojas(Nodo R, int cont) {
        if (R != null) {
            cont = CantHojas(R.getLizq(), cont);
            cont = CantHojas(R.getLder(), cont);
            if (R.getLizq() == null && R.getLder() == null) {
                cont++;
                System.out.print(R.getDato());
            }
        }
        return cont;
    }

    public int CantPadres(Nodo R, int cont) {
        if (R != null) {
            if (R.getLizq() != null || R.getLder() != null) {
                cont++;
                System.out.print(R.getDato());
            }
            cont = CantPadres(R.getLizq(), cont);
            cont = CantPadres(R.getLder(), cont);
        }
        return cont;
    }

    public int CantHijosUnicos(Nodo R, int cont) {
        if (R != null) {
            cont = CantHijosUnicos(R.getLizq(), cont);
            if ((R.getLizq() == null && R.getLder() != null) || (R.getLizq() != null && R.getLder() == null)) {
                cont++;
                System.out.print(R.getDato());
            }
            cont = CantHijosUnicos(R.getLder(), cont);
        }
        return cont;
    }

    public void Mostrar_Hermano(char Dato) {
        Nodo p = Punta;
        boolean Find = true;
        while (p != null) {
            if (p.getLizq() != null) {
                if ((p.getLizq().getDato() == Dato) && p.getLder() != null) {
                    System.out.println("El hermano de " + Dato + " es: " + p.getLder().getDato());
                    Find = false;
                }
            }
            if (p.getLder() != null) {
                if ((p.getLder().getDato() == Dato) && p.getLizq() != null) {
                    System.out.println("El hermano de " + Dato + " es: " + p.getLizq().getDato());
                    Find = false;
                }
            }
            if (p.getDato() < Dato) {
                p = p.getLder();
            } else {
                p = p.getLizq();
            }
        }
        if (Find) {
            System.out.println("El dato (" + Dato + ") no tiene hermano");
        }
    }

    public void PrimosHermanos(char Dato) {
        int Niv = Nivel(Punta, Dato), Niv2 = Niv - 2;
        Nodo P = Punta;

        if (Niv <= 2) {
            System.out.println("El dato " + Dato + " no tiene primos hermanos.");
        } else {
            while (Nivel(Punta, P.getDato()) != Niv2) {
                if (Dato > P.getDato()) {
                    P = P.getLder();
                } else {
                    P = P.getLizq();
                }
            }
            if (P.getLder() == null || P.getLizq() == null) {
                System.out.println("El dato " + Dato + " no tiene primos hermanos.");
            } else {
                if (Dato > P.getDato()) {
                    P = P.getLizq();
                } else {
                    P = P.getLder();
                }
                if (P.getLder() == null && P.getLizq() == null) {
                    System.out.println("El dato " + Dato + " no tiene primos hermanos.");
                } else {
                    if (P.getLder() == null) {
                        System.out.println("El primo hermano de " + Dato + " es " + P.getLizq().getDato());
                    } else {
                        if (P.getLizq() == null) {
                            System.out.println("El primo hermano de " + Dato + " es " + P.getLder().getDato());
                        } else {
                            System.out.println("Los primos hermanos de " + Dato + " son " + P.getLizq().getDato() + " y " + P.getLder().getDato());
                        }
                    }
                }
            }
        }
    }

    public int Altura(Nodo R) {
        int cont1 = 0, cont2 = 0;
        if (R != null) {
            if (R.getLizq() != null) {
                cont1 = Altura(R.getLizq()) + 1;
            }
            if (R.getLder() != null) {
                cont2 = Altura(R.getLder()) + 1;
            }
        }
        if (cont1 >= cont2) {
            return cont1;
        } else {
            return cont2;
        }
    }

    public int Nivel(Nodo P, char Dato) {
        int Niv = 0;

        if (Dato != P.getDato()) {
            if (Dato > P.getDato()) {
                Niv = Nivel(P.getLder(), Dato) + 1;
                return Niv;
            } else {
                Niv = Nivel(P.getLizq(), Dato) + 1;
                return Niv;
            }
        } else {
            return 1;
        }
    }

    public Nodo Buscar(Nodo P, char Dato) {
        Nodo Q;

        if (P != null) {
            if (Dato != P.getDato()) {
                if (Dato > P.getDato()) {
                    Q = Buscar(P.getLder(), Dato);
                    return Q;
                } else {
                    Q = Buscar(P.getLizq(), Dato);
                    return Q;
                }
            } else {
                return P;
            }
        } else {
            return null;
        }
    }

    public void Ancestros(Nodo P, char Dato) {
        if (Dato != P.getDato()) {
            if (Dato > P.getDato()) {
                Ancestros(P.getLder(), Dato);
            } else {
                Ancestros(P.getLizq(), Dato);
            }
            System.out.print(P.getDato());
        } else {
            System.out.print("Los ancestros de " + P.getDato() + " son ");
        }
    }

    public void AVL() {
        Nodo Q, R, C;
        Nodo P = Desbalance(this.Punta);
        int DesH;
        if (P != null) {
            if (P.getFB() == 2 || P.getFB() == -2) {
                int AD = Altura(P.getLder());
                int AI = Altura(P.getLizq());

                if (AD < AI) {
                    DesH = P.getLizq().getFB();
                    Q = P.getLizq();
                } else {
                    DesH = P.getLder().getFB();
                    Q = P.getLder();
                }
                C = Buscar2(this.Punta, null, P.getDato());
                if (P.getFB() == 2 && DesH == 1) {
                    RD(P, Q, C);
                } else {
                    if (P.getFB() == -2 && DesH == -1) {
                        RI(P, Q, C);
                    } else {
                        int ADD = Altura(Q.getLder());
                        int AID = Altura(Q.getLizq());

                        if(Q.getLizq() != null && Q.getLder() != null){
                            if (ADD < AID) {
                                R = Q.getLizq();
                            } else {
                                R = Q.getLder();
                            }
                        }else{
                            if(Q.getLizq() == null){
                                R = Q.getLder();
                            }else{
                                R = Q.getLizq();
                            }
                        }
                        
                        if (P.getFB() == -2 && DesH == 1) {
                            RDI(P, Q, R, C);
                        } else {
                            if (P.getFB() == 2 && DesH == -1) {
                                RDD(P, Q, R, C);
                            }
                        }
                    }
                }
            }
        }
    }

    private void RI(Nodo P, Nodo Q, Nodo C) {
        P.setLder(Q.getLizq());
        Q.setLizq(P);
        if (P == Punta) {
            Punta = Q;
        } else {
            if (C.getLizq() == P) {
                C.setLizq(Q);
            } else {
                C.setLder(Q);
            }
        }
    }

    private void RD(Nodo P, Nodo Q, Nodo C) {
        P.setLizq(Q.getLder());
        Q.setLder(P);
        if (P == Punta) {
            Punta = Q;
        } else {
            if (C.getLizq() == P) {
                C.setLizq(Q);
            } else {
                C.setLder(Q);
            }
        }
    }

    private void RDI(Nodo P, Nodo Q, Nodo R, Nodo C) {
        P.setLder(R.getLizq());
        R.setLizq(P);
        Q.setLizq(R.getLder());
        R.setLder(Q);
        if (P == Punta) {
            Punta = R;
        } else {
            if (C.getLizq() == P) {
                C.setLizq(R);
            } else {
                C.setLder(R);
            }
        }
    }

    private void RDD(Nodo P, Nodo Q, Nodo R, Nodo C) {
        P.setLizq(R.getLder());
        R.setLder(P);
        Q.setLder(R.getLizq());
        R.setLizq(Q);
        if (P == Punta) {
            Punta = R;
        } else {
            if (C.getLizq() == P) {
                C.setLizq(R);
            } else {
                C.setLder(R);
            }
        }
    }

    public Nodo Desbalance(Nodo R) {
        Nodo P = null;
        if (R != null) {
            P = Desbalance(R.getLizq());
            if (P != null) {
                return P;
            }
            P = Desbalance(R.getLder());
            if (P != null) {
                return P;
            }
            int B = FactorBalance(R);
            R.setFB(B);
            if (B == 2 || B == -2) {
                return R;
            }
        }
        return P;
    }

    public Nodo Buscar2(Nodo P, Nodo R, char Dato) {
        Nodo Q;

        if (P != null) {
            if (Dato != P.getDato()) {
                if (Dato > P.getDato()) {
                    R = P;
                    Q = Buscar2(P.getLder(), R, Dato);
                    return Q;
                } else {
                    R = P;
                    Q = Buscar2(P.getLizq(), R, Dato);
                    return Q;
                }
            } else {
                return R;
            }
        } else {
            return null;
        }
    }

    private int FactorBalance(Nodo X) {
        Nodo P = Punta;
        int FB = 0;
        if (X != null) {
            if (X.getLder() == null && X.getLizq() != null) {
                FB = ((Altura(X.getLizq()) + 1) - 0);
            } else {
                if (X.getLder() != null && X.getLizq() == null) {
                    FB = (0 - (Altura(X.getLder()) + 1));
                } else {
                    FB = ((Altura(X.getLizq()) + 1) - (Altura(X.getLder()) + 1));
                }
            }
        }
        return FB;
    }

    public int Nivel_Arbol() {
        return Altura(Punta) + 1;
    }

    private Nodo[][] Nodos_Arbol() {
        Nodo[][] M = new Nodo[Nivel_Arbol()][DatosNivel()];
        M[0][0] = Punta;

        for (int i = 0; i < M.length - 1; i++) {
            boolean ban = true;
            int j = 0;
            do {
                if (M[i][j] != null) {
                    if ((i + 1) < M.length) {
                        if (M[i][j].getLizq() != null) {
                            M[i + 1][2 * j] = M[i][j].getLizq();
                        }
                        if (M[i][j].getLder() != null) {
                            M[i + 1][(2 * j) + 1] = M[i][j].getLder();
                        }
                    }
                }
                j++;
            } while (j < M[0].length);
        }
        return M;
    }

    public void Mostrar_Arbol() {
        Nodo[][] Arbol = Nodos_Arbol();
        String A = "";
        int p = 0;
        for (int i = 1; i < Arbol.length; i++) {
            int cont = 0;
            int j = 0;
            int k = 0;
            while (j < Arbol[0].length) {

                if (Arbol[i][j] != null) {
                    A += (Arbol[i - 1][k].getDato() + "->" + Arbol[i][j].getDato() + "\n");
                } else {
                    if (Arbol[i - 1][k] != null) {
                        p++;
                        A += (Arbol[i - 1][k].getDato() + "->null0" + p + "\n");
                    }
                }
                cont++;
                j++;
                if (cont == 2) {
                    k++;
                    cont = 0;
                }
            }
        }
        CrearArchivo(A);
        CrearIMG();
    }

    private int DatosNivel() {
        int cant = 1;
        for (int i = 1; i < Nivel_Arbol(); i++) {
            cant *= 2;
        }
        return cant;
    }

    private void CrearArchivo(String A) {
        try {
            FileWriter a = new FileWriter("ImagenArbol.txt");
            BufferedWriter escribir = new BufferedWriter(a);
            escribir.write("digraph ImagenArbol\n{\n");
            escribir.write(A);
            escribir.write("}");
            escribir.close();
        } catch (Exception e) {
        }
    }

    private void CrearIMG() {
        try {

            String dotPath = "./src/bin/dot.exe";
            String fileInputPath = "ImagenArbol.txt";
            String fileOutputPath = "./src/arboles/grafico.jpg";

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}