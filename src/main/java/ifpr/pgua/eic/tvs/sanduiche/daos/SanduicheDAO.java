package ifpr.pgua.eic.tvs.sanduiche.daos;

import ifpr.pgua.eic.tvs.sanduiche.models.Sanduiche;


/***
 * Interface para a definição de operações com a base de dados de itens.
 */
public interface SanduicheDAO {
    

    /***
     * Método utilizado para criar um novo sanduiche na base de dados. Deve armazenar
     * todos os atributos do sanduiche. Assume que os itens já estão salvos.
     * @param sanduiche objeto da classe sanduiche a ser salvo na base de dados
     * @return o objeto sanduiche atualizado com o id (chave primária criada)
     */
    Sanduiche create(Sanduiche sanduiche);

}
