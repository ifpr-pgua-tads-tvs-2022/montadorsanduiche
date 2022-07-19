package ifpr.pgua.eic.tvs.sanduiche.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class SanduicheTest {
    
    private ArrayList<Item> geraListaItens(){
        ArrayList<Item> itens = new ArrayList<>();

        itens.add(new Item("Item 1",1,1,TipoItem.PAO));
        itens.add(new Item("Item 2",2,2,TipoItem.MOLHO));
        itens.add(new Item("Item 3",3,3,TipoItem.COMPLEMENTO));
        itens.add(new Item("Item 4",4,4,TipoItem.QUEIJO));

        return itens;
    }


    @Test
    void testCalculaValor() {
        //cenário

        ArrayList<Item> itens = new ArrayList<>();

        itens.add(new Item("Item 1",1,1,TipoItem.PAO));
        itens.add(new Item("Item 2",2,2,TipoItem.MOLHO));
        itens.add(new Item("Item 3",3,3,TipoItem.COMPLEMENTO));
        itens.add(new Item("Item 4",4,4,TipoItem.QUEIJO));
        
        double valorEsperado = itens.stream()
                                    .map((item)->item.getValor())
                                    .reduce(0.0, Double::sum);
        /*
         * double valorEsperado = 0.0;
         * for(Item item:itens){
         *     valorEsperado += item.getValor();
         * }
         */
        Sanduiche sanduiche = new Sanduiche(itens);

        //ação
        sanduiche.calculaValor();
        
        //verificação
        double valorCalculado = sanduiche.getValorFinal();
        assertEquals(valorEsperado, valorCalculado,0.001);
    }


    @Test
    void testDeveRetornaValorZeroListaVazia(){
        Sanduiche sanduiche = new Sanduiche(new ArrayList<>());
        double valorEsperado = 0.0;

        sanduiche.calculaValor();
        double valorCalculado = sanduiche.getValorFinal();

        assertEquals(valorEsperado, valorCalculado,0.001);

    }

    @Test
    void testCalcularPeso() {

        //cenário
        ArrayList<Item> itens = geraListaItens();

        double valorEsperado = itens.stream()
                                    .map((item)->item.getPeso())
                                    .reduce(0.0,Double::sum);


        Sanduiche sanduiche = new Sanduiche(itens);

        //ação
        sanduiche.calcularPeso();
        double valorCalculado = sanduiche.getPesoFinal();


        //verificação
        assertEquals(valorEsperado,valorCalculado,0.001);

    }
}
