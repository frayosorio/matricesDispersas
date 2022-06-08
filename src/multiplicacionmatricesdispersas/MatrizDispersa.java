package multiplicacionmatricesdispersas;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MatrizDispersa {

    Nodo cabeza;

    public MatrizDispersa(int filas, int columnas) {
        cabeza = new Nodo(filas, columnas);
        Nodo apuntador = cabeza;
        for (int i = 0; i < filas; i++) {
            Nodo n = new Nodo();
            apuntador.siguienteFila = n;
            apuntador = n;
        }
    }

    public Nodo obtenerNodoFila(int fila) {
        Nodo apuntador = null;
        if (fila >= 1 && fila <= cabeza.valor1) {
            apuntador = cabeza.siguienteFila;
            for (int i = 1; i < fila; i++) {
                apuntador = apuntador.siguienteFila;
            }
        }
        return apuntador;
    }

    public Nodo existe(int fila, int columna) {
        Nodo apuntador = obtenerNodoFila(fila);
        boolean encontrado = false;
        while (apuntador != null && !encontrado) {
            if (apuntador.valor1 == columna) {
                encontrado = true;
            } else {
                apuntador = apuntador.siguienteColumna;
            }
        }
        return apuntador;
    }

    public void asignar(int fila, int columna, double valor) {
        Nodo n = existe(fila, columna);
        if (n != null) {
            n.valor2 = valor;
        } else {
            if (columna >= 1 && columna <= cabeza.valor2) {
                n = new Nodo(columna, valor);
                Nodo apuntador = obtenerNodoFila(fila);
                while (apuntador.siguienteColumna != null) {
                    apuntador = apuntador.siguienteColumna;
                }
                apuntador.siguienteColumna = n;
            }
        }
    }

    public double obtener(int fila, int columna) {
        Nodo n = existe(fila, columna);
        return n != null ? n.valor2 : 0;
    }

    public void mostrar(JTable tbl) {
        int c = (int) cabeza.valor2;
        int f = cabeza.valor1;

        String[] encabezados = new String[c];
        for (int i = 1; i <= c; i++) {
            encabezados[i - 1] = String.valueOf(i);
        }
        String[][] datos = new String[f][c];
        for (int i = 1; i <= f; i++) {
            for (int j = 1; j <= c; j++) {
                datos[i - 1][j - 1] = String.valueOf(obtener(i, j));
            }
        }

        tbl.setModel(new DefaultTableModel(datos, encabezados));

    }
}
