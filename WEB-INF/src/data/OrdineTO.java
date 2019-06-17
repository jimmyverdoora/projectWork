package data;

public class OrdineTO extends TO{

    private int id;
    private int cliente_id;

    public OrdineTO(int id, int cliente_id) {
        this.id = id;
        this.cliente_id = cliente_id;
    }

    public int getId() {
        return id;
    }

    public int getCliente_id() {
        return cliente_id;
    }
}
