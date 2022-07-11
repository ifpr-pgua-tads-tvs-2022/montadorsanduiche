package ifpr.pgua.eic.tvs.sanduiche.controler;

import ifpr.pgua.eic.tvs.sanduiche.models.Item;
import ifpr.pgua.eic.tvs.sanduiche.models.Sanduiche;
import ifpr.pgua.eic.tvs.sanduiche.models.TipoItem;


/***
 * A classe avaliador é utilizada para verificar se um
 * sanduiche possui os mínimos corretos. Considera-se as seguinte regras:
 * TipoItem.PAO == 1
 * TipoItem.MOLHO >= 1
 * TipoItem.QUEIJO >= 1 e TipoItem.QUEIJO <= 3
 */


public class Avaliador {



    /***
     * Verifica se um sanduiche atende as regras para a montagem de um sanduiche.
     * @param sanduiche objeto a ser avaliado
     * @return true se o sanduiche contem os itens mínimos da regra. false caso contrário
     */
    public boolean avalia(Sanduiche sanduiche){

        int contPaes = 0;

        for(Item item:sanduiche.getItens()){
            if(item.getTipo() == TipoItem.PAO){
                contPaes +=1;
            }
        }

        if(contPaes != 1){
            return false;
        }

        return true;
    }
}
