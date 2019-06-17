package data;

public class RigaOrdineTO extends TO{

    private int id;
    private int ordine_id;
    private int articolo_id;
    private double prezzUnitario;
    private int quantita;
    private String stato;

    RigaOrdineTO(int id, int ordine_id, int articolo_id, double prezzUnitario, int quantita, String stato) {
        this.id = id;
        this.ordine_id = ordine_id;
        this.articolo_id = articolo_id;
        this.prezzUnitario = prezzUnitario;
        this.quantita = quantita;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public int getOrdine_id() {
        return ordine_id;
    }

    public int getArticolo_id() {
        return articolo_id;
    }

    public double getPrezzUnitario() {
        return prezzUnitario;
    }

    public int getQuantita() {
        return quantita;
    }

    public String getStato() {
        return stato;
    }
}
