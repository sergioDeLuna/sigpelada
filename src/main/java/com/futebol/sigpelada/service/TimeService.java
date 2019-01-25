package com.futebol.sigpelada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futebol.sigpelada.dao.TimeDao;
import com.futebol.sigpelada.dominio.Time;
/**
 * Service de Time
 * @author sergioluna
 *
 */
@Service
@Transactional
public class TimeService {
	/**
	 * TimeDao
	 */
    @Autowired
    private TimeDao timeDao;
    
    /**
     * Salvar time
     * @param time
     */
    public void salvar(Time time) {
        timeDao.salvar(time);
    }
    
    /**
     * Recuperar times
     * @return
     */
    @Transactional(readOnly = true)
    public List<Time> recuperar() {
        return timeDao.recuperar();
    }
    
    /**
     * Recuperar um time passando id
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Time recuperarPorId(long id) {
        return timeDao.recuperarPorID(id);
    }
    
    /**
     * Atualizar time
     * @param time
     */
    public void atualizar(Time time) {
        timeDao.atualizar(time);
    }
    
    /**
     * Excluir time
     * @param id
     */
    public void excluir(long id) {
        timeDao.excluir(id);
    }
 
}
