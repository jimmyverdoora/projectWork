package data;

public class RigaOrdineTO implements TO{

    private int id;
    private int ordine_id;
    private int articolo_id;
    private double prezzoUnitario;
    private int quantita;
    private String stato;

    RigaOrdineTO(int id, int ordine_id, int articolo_id, double prezzoUnitario, int quantita, String stato) {
        this.id = id;
        this.ordine_id = ordine_id;
        this.articolo_id = articolo_id;
        this.prezzoUnitario = prezzoUnitario;
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

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public int getQuantita() {
        return quantita;
    }

    public String getStato() {
        return stato;
    }
}
