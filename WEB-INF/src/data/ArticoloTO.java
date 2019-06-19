package data;

public class ArticoloTO implements TO{

    private int id;
    private int listino_id;
    private double prezzo;
    private int quantita;
    private String nome;
    private String descrizione;
    private String tipo;

    ArticoloTO(int id, int listino_id, double prezzo, int quantita, String nome, String descrizione, String tipo) {
        this.id = id;
        this.listino_id = listino_id;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.nome = nome;
        this.descrizione = descrizione;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public int getListino_id() {
        return listino_id;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getTipo() {
        return tipo;
    }
}
