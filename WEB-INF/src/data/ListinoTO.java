package data;

public class ListinoTO implements TO{

    private int id;
    private int fornitore_id;
    private String nome;
    private String descrizione;

    public ListinoTO(int id, int fornitore_id, String nome, String descrizione) {
        this.id = id;
        this.fornitore_id = fornitore_id;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public int getId() {
        return id;
    }

    public int getFornitore_id() {
        return fornitore_id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
