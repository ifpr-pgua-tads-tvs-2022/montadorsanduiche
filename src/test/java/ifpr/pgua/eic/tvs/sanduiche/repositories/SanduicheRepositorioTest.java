package ifpr.pgua.eic.tvs.sanduiche.repositories;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifpr.pgua.eic.tvs.sanduiche.controler.Avaliador;
import ifpr.pgua.eic.tvs.sanduiche.daos.SanduicheDAO;
import ifpr.pgua.eic.tvs.sanduiche.exceptions.SanduicheException;
import ifpr.pgua.eic.tvs.sanduiche.models.Item;
import ifpr.pgua.eic.tvs.sanduiche.models.Sanduiche;
import ifpr.pgua.eic.tvs.sanduiche.models.TipoItem;

public class SanduicheRepositorioTest {
    
    private ArrayList<Item> geraListaItens(){
        ArrayList<Item> itens = new ArrayList<>();

        itens.add(new Item("Item 1",1,1,TipoItem.PAO));
        itens.add(new Item("Item 2",2,2,TipoItem.MOLHO));
        itens.add(new Item("Item 3",3,3,TipoItem.COMPLEMENTO));
        itens.add(new Item("Item 4",4,4,TipoItem.QUEIJO));

        return itens;
    }
    
    @Test
    void testCadastrar() {

        //cenário

        ArrayList<Item> itens = geraListaItens();

        Avaliador avaliador = Mockito.mock(Avaliador.class);
        SanduicheDAO sanduicheDAO = Mockito.mock(SanduicheDAO.class); 

        Sanduiche sanduiche = new Sanduiche(itens);

        when(sanduicheDAO.create(any())).thenReturn(sanduiche);
        when(avaliador.avalia(any())).thenReturn(true);

        SanduicheRepositorio repositorio = new SanduicheRepositorio(sanduicheDAO, avaliador);

        //ação
        Sanduiche criado = repositorio.cadastrar(itens);

        //verificação
        assertIterableEquals(itens, criado.getItens());
        verify(avaliador,times(1)).avalia(any());
        verify(sanduicheDAO,times(1)).create(any());

    }


    @Test
    void deveGerarExcessaoListaVazia(){
        //cenario
        Avaliador avaliador = Mockito.mock(Avaliador.class);
        SanduicheDAO sanduicheDAO = Mockito.mock(SanduicheDAO.class); 
        SanduicheRepositorio repositorio = new SanduicheRepositorio(sanduicheDAO, avaliador);


        //ação e verificação
        SanduicheException exception = assertThrows(SanduicheException.class, ()->{
            repositorio.cadastrar(new ArrayList<>());
        });

        assertTrue(exception.getMessage().contains("Lista Vazia!"));
    }
}
