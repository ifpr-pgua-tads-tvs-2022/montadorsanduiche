package ifpr.pgua.eic.tvs.sanduiche.repositories;

import java.util.List;

import ifpr.pgua.eic.tvs.sanduiche.controler.Avaliador;
import ifpr.pgua.eic.tvs.sanduiche.daos.SanduicheDAO;
import ifpr.pgua.eic.tvs.sanduiche.exceptions.SanduicheException;
import ifpr.pgua.eic.tvs.sanduiche.models.Item;
import ifpr.pgua.eic.tvs.sanduiche.models.Sanduiche;

public class SanduicheRepositorio {
    
    private SanduicheDAO sanduicheDAO;
    private Avaliador avaliador;

    public SanduicheRepositorio(SanduicheDAO sanduicheDAO, Avaliador avaliador) {
        this.sanduicheDAO = sanduicheDAO;
        this.avaliador = avaliador;
    }


    /**
     * Recebe uma lista de itens, cria um sanduiche e insere na base de dados
     * através do sanduicheDAO. 
     * 
     * 
     * @param itens lista de itens que compõem o sanduiche
     * @return sanduiche atualizado com o novo id
     * @throws SanduicheException gera exceção caso a lista de itens seja vazia ou o sanduiche não esteja montado 
     * corretamente.
     */

    public Sanduiche cadastrar(List<Item> itens) throws SanduicheException{
        
        Sanduiche sanduiche = new Sanduiche(itens);
        
        return sanduicheDAO.create(sanduiche);
    }
    

}
