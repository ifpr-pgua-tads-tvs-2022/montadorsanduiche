package ifpr.pgua.eic.tvs.sanduiche.controler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ifpr.pgua.eic.tvs.sanduiche.models.Item;
import ifpr.pgua.eic.tvs.sanduiche.models.Sanduiche;
import ifpr.pgua.eic.tvs.sanduiche.models.TipoItem;

public class AvaliadorTest {

    private ArrayList<Item> geraListaItensValida(){
        ArrayList<Item> itens = new ArrayList<>();

        itens.add(new Item("Item 1",1,1,TipoItem.PAO));
        itens.add(new Item("Item 2",2,2,TipoItem.MOLHO));
        itens.add(new Item("Item 3",3,3,TipoItem.COMPLEMENTO));
        itens.add(new Item("Item 4",4,4,TipoItem.QUEIJO));

        return itens;
    }

    private ArrayList<Item> geraListaItensValida2(){
        ArrayList<Item> itens = new ArrayList<>();

        itens.add(new Item("Item 1",1,1,TipoItem.PAO));
        itens.add(new Item("Item 2",2,2,TipoItem.MOLHO));
        itens.add(new Item("Item 3",3,3,TipoItem.COMPLEMENTO));
        itens.add(new Item("Item 4",4,4,TipoItem.QUEIJO));
        itens.add(new Item("Item 5",5,5,TipoItem.QUEIJO));
        
        return itens;
    }

    private ArrayList<Item> geraListaItensInvalida1(){
        ArrayList<Item> itens = new ArrayList<>();

        //itens.add(new Item("Item 1",1,1,TipoItem.PAO));
        itens.add(new Item("Item 2",2,2,TipoItem.MOLHO));
        itens.add(new Item("Item 3",3,3,TipoItem.COMPLEMENTO));
        itens.add(new Item("Item 4",4,4,TipoItem.QUEIJO));
        itens.add(new Item("Item 5",5,5,TipoItem.QUEIJO));
        
        return itens;
    }



    @Test
    void testAvaliaDeveRetornarTrueListaValida() {
        //cenário
        ArrayList<Item> itens = geraListaItensValida();

        Sanduiche sanduiche = new Sanduiche(itens);
        
        boolean esperado = true;
        
        Avaliador avaliador = new Avaliador();

        //ação
        boolean calculado = avaliador.avalia(sanduiche);

        //verificação
        assertEquals(esperado, calculado);
        //assertTrue(calculado);
    }

    @Test
    void testAvaliaDeveRetornarTrueListaValida2() {
        //cenário
        ArrayList<Item> itens = geraListaItensValida2();

        Sanduiche sanduiche = new Sanduiche(itens);
        
        boolean esperado = true;
        
        Avaliador avaliador = new Avaliador();

        //ação
        boolean calculado = avaliador.avalia(sanduiche);

        //verificação
        assertEquals(esperado, calculado);
        //assertTrue(calculado);
    }

    @Test
    void testAvaliaDeveRetornarTrueListaInvalida1() {
        //cenário
        ArrayList<Item> itens = geraListaItensInvalida1();

        Sanduiche sanduiche = new Sanduiche(itens);
        
        boolean esperado = false;
        
        Avaliador avaliador = new Avaliador();

        //ação
        boolean calculado = avaliador.avalia(sanduiche);

        //verificação
        assertEquals(esperado, calculado);
        //assertTrue(calculado);
    }



}
