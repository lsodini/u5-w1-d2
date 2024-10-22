package LucaSodini.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ordine {
    private static int counter = 1;

    private int numeroOrdine;
    private Tavolo tavolo;
    private List<MenuItem> items;
    private String stato;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione;
    private double costoCoperto;

    public Ordine(Tavolo tavolo, int numeroCoperti, double costoCoperto) {
        this.numeroOrdine = counter++;
        this.tavolo = tavolo;
        this.items = new ArrayList<>();
        this.stato = "in corso";
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = LocalDateTime.now();
        this.costoCoperto = costoCoperto;
        tavolo.occupaTavolo();
    }

    public void aggiungiItem(MenuItem item) {
        items.add(item);
    }

    public double calcolaTotale() {
        double totale = items.stream().mapToDouble(MenuItem::getPrice).sum();
        totale += numeroCoperti * costoCoperto;
        return totale;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordine numero: ").append(numeroOrdine).append("\n");
        sb.append("Tavolo: ").append(tavolo).append("\n");
        sb.append("Stato: ").append(stato).append("\n");
        sb.append("Numero coperti: ").append(numeroCoperti).append("\n");
        sb.append("Ora di acquisizione: ").append(oraAcquisizione).append("\n");
        sb.append("Items:\n");
        for (MenuItem item : items) {
            sb.append("- ").append(item.getName()).append(" (€").append(item.getPrice()).append(")\n");
        }
        sb.append("Costo coperti: ").append(numeroCoperti).append(" x €").append(costoCoperto).append(" = €").append(numeroCoperti * costoCoperto).append("\n");
        sb.append("Totale: €").append(calcolaTotale()).append("\n");
        return sb.toString();
    }
}
