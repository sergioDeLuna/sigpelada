package com.futebol.sigpelada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futebol.sigpelada.dao.JogadorDao;
import com.futebol.sigpelada.dominio.Jogador;

/**
 * Service de Jogador
 * @author sergioluna
 *
 */
@Service
@Transactional
public class JogadorService {
	
	/**
	 * Jogador Dao
	 */
	@Autowired
	private JogadorDao jogadorDao;
	
	/**
	 * Time Service
	 */
	@Autowired
	private TimeService timeService;
	
	/**
	 * Salvar jogador
	 * @param jogador
	 * @param timeId
	 */
	public void salvar(Jogador jogador, long timeId) {
		jogador.setTime(timeService.recuperarPorId(timeId));
		jogadorDao.salvar(jogador);
	}
	
	/**
	 * Recuperar jogadores
	 * @param timeId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Jogador> recuperarPorTime(long timeId) {
		return jogadorDao.recuperarPorTime(timeId);
	}
	
	/**
	 * Recuperar jogador de um time
	 * @param timeId
	 * @param jogadorId
	 * @return
	 */
	@Transactional(readOnly = true)
	public Jogador recuperarPorTimeIdEJogadorId(long timeId, long jogadorId) {
		return jogadorDao.recuperarPorTimeIdEJogadorId(timeId, jogadorId);
	}

	/**
	 * Atualizar jogador
	 * @param jogador
	 * @param timeId
	 */
	public void atualizar(Jogador jogador, long timeId) {
		jogador.setTime(timeService.recuperarPorId(timeId));
		jogadorDao.atualizar(jogador);
	}
	
	/**
	 * Excluir jogador
	 * @param timeId
	 * @param jogadorId
	 */
	public void excluir(long timeId, long jogadorId) {
		jogadorDao.excluir(recuperarPorTimeIdEJogadorId(timeId, jogadorId).getId());
	}

}
