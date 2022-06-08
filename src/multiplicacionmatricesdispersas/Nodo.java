package multiplicacionmatricesdispersas;

public class Nodo {

    int valor1;
    double valor2;

    Nodo siguienteFila;
    Nodo siguienteColumna;

    public Nodo() {
        this.valor1 = 0;
        this.valor2 = 0;
        this.siguienteFila = null;
        this.siguienteColumna = null;
    }

    public Nodo(int valor1, double valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.siguienteFila = null;
        this.siguienteColumna = null;
    }

}
