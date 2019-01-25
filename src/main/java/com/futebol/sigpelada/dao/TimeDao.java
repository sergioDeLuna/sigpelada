package com.futebol.sigpelada.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.futebol.sigpelada.dominio.Time;
/**
 * Classe Dao de Time
 * @author sergioluna
 *
 */
@Repository
public class TimeDao {
	/**
	 * Gerencia a dependencia de um Ententy Manager
	 */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Salva elemento
     * @param time
     */
    public void salvar(Time time) {
        em.persist(time);
    }
    
    /**
     * Recupera lista de elementos cadastrados
     * @return
     */
    public List<Time> recuperar() {
        return em.createQuery("select p from Time p", Time.class).getResultList();
    }
    
    /**
     * Recupera elemento por Id
     * @param id
     * @return
     */
    public Time recuperarPorID(long id) {
        return em.find(Time.class, id);
    }
    
    /**
     * Atualiza elemento
     * @param time
     */
    public void atualizar(Time time) {
        em.merge(time);
    }
    
    /**
     * Exclui elemento
     * @param id
     */
    public void excluir(long id) {
        em.remove(em.getReference(Time.class, id));
    }
 
}
