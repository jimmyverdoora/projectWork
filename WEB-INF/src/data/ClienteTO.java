package data;

public class ClienteTO implements TO{

    private int id;
    private String username;
    private String password;
    private String nome;
    private String descrizione;
    private String email;

    ClienteTO(int id, String username, String password, String nome, String descrizione, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.descrizione = descrizione;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getEmail() {
        return email;
    }
}
