package com.futebol.sigpelada.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.futebol.sigpelada.dominio.Jogador;
/**
 * Classe Dao de Jogador
 * @author sergioluna
 *
 */
@Repository
public class JogadorDao {
	
	/**
	 * Gerencia a dependencia de um Ententy Manager
	 */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Salva o jogador
     * @param jogador
     */
    public void salvar(Jogador jogador) {
        em.persist(jogador);
    }
    
    /**
     * Retorna os jogadores de um time
     * @param timeId
     * @return
     */
    public List<Jogador> recuperarPorTime(long timeId) {
        return em.createQuery("select j from Jogador j where j.time.id = :timeId", Jogador.class)
                .setParameter("timeId", timeId)
                .getResultList();
    }
    
    /**
     * Retorna jogador
     * @param timeId
     * @param jogadorId
     * @return
     */
    public Jogador recuperarPorTimeIdEJogadorId(long timeId, long jogadorId) {
        return em.createQuery("select j from Jogador j where j.time.id = :timeId and j.id = :jogadorId", Jogador.class)
                .setParameter("timeId", timeId)
                .setParameter("jogadorId", jogadorId)
                .getSingleResult();
    }
    
    /**
     * Atualiza elemento
     * @param jogador
     */
    public void atualizar(Jogador jogador) {
        em.merge(jogador);
    }
    
    /**
     * Exclui elemento
     * @param jogadorId
     */
    public void excluir(long jogadorId) {
        em.remove(em.getReference(Jogador.class, jogadorId));
    }
 
}
