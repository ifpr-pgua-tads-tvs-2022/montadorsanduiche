package ifpr.pgua.eic.tvs.sanduiche.models;


/**
 * Classe que representa um item que compõe um sanduíche.
 * 
 */
public class Item {

    private int id;
    private String descricao;
    private double valor;
    private double peso;
    private TipoItem tipo;

    public Item(String descricao, double valor, double peso, TipoItem tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.peso = peso;
        this.tipo = tipo;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }
}
