package LucaSodini.entities;

public class Tavolo {
    private int numero;
    private int maxCoperti;
    private boolean occupato;

    public Tavolo(int numero, int maxCoperti, boolean occupato) {
        this.numero = numero;
        this.maxCoperti = maxCoperti;
        this.occupato = occupato;
    }


    public int getNumero() {
        return numero;
    }

    public int getMaxCoperti() {
        return maxCoperti;
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void occupaTavolo() {
        this.occupato = true;
    }

    public void liberaTavolo() {
        this.occupato = false;
    }

    @Override
    public String toString() {
        return "Tavolo " + numero + " (max coperti: " + maxCoperti + ", " + (occupato ? "occupato" : "libero") + ")";
    }
}
