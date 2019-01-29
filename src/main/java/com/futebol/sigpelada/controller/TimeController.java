package com.futebol.sigpelada.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.futebol.sigpelada.config.Mensagem;
import com.futebol.sigpelada.dominio.Time;
import com.futebol.sigpelada.service.TimeService;
/**
 * Classe controller para Time
 * @author sergioluna
 *
 */
@Named
@Scope("session")
public class TimeController implements Serializable {

	private static final long serialVersionUID = -1025252140353914359L;

	private Time time;
	private List<Time> times;
	
	@Inject
	private TimeService timeService;

	public void iniciarBean() {
		times = timeService.recuperar();
	}

	public void novotime() {
		time = new Time();
	}

	public void salvar() {
		timeService.salvar(time);
		Mensagem.mensagemInformacao("time cadastrado com sucesso");
		times = timeService.recuperar();
		time = null;
	}

	public void editar(Time time) {
		this.time = time;
	}

	public void voltar() {
		this.time = null;
	}

	/**
	 * @return the time
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Time time) {
		this.time = time;
	}

	/**
	 * @return the times
	 */
	public List<Time> getTimes() {
		return times;
	}

	/**
	 * @param times the times to set
	 */
	public void setTimes(List<Time> times) {
		this.times = times;
	}

}
