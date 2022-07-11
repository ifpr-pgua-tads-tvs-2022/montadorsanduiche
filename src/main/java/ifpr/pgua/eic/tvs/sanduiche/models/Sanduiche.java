package ifpr.pgua.eic.tvs.sanduiche.models;

import java.util.ArrayList;
import java.util.List;

public class Sanduiche {


    private int id;
    private double valorFinal;
    private double pesoFinal;
    
    private List<Item> itens;

    public Sanduiche(int id, double valorFinal, double pesoFinal) {
        this.id = id;
        this.valorFinal = valorFinal;
        this.pesoFinal = pesoFinal;
    }

    public Sanduiche(List<Item> itens){
        this.itens = itens;
    }

    /**
     * Calcula o valor do sanduiche, baseado na lista de itens e atualiza o atributo valorFinal.
     */
    public void calculaValor(){
        double valor = 0;
        for(Item item:itens){
            valor = item.getValor();
        }
        this.valorFinal = valor;
    }

    /**
     * Calcula o peso do sanduiche baseado na lista de itens e atualiza o atributo pesoFinal.
     */
    public void calcularPeso(){
        double peso=0;
        for(Item item:itens){
            peso = item.getPeso();
        }

        this.pesoFinal = peso;
    }


    public Sanduiche(){
        itens = new ArrayList<>();
    }

    public List<Item> getItens(){
        return itens;
    }

    public double getValorFinal(){
        return valorFinal;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
