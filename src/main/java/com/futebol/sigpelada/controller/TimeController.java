package com.futebol.sigpelada.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.futebol.sigpelada.dominio.Time;
import com.futebol.sigpelada.service.TimeService;
/**
 * Classe controller para Time
 * @author sergioluna
 *
 */
@Controller
@RequestMapping("times")
public class TimeController {
	/**
	 * Injeção do Service de Time
	 */
    @Autowired
    private TimeService timeService;
    
    /**
     * Listagem de times
     * @param model
     * @return
     */
    @GetMapping("/listar")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("times", timeService.recuperar());
        return new ModelAndView("/time/list", model);
    }
    
    /**
     * Redireciona para a página form - cadastro do time
     * @param time
     * @return
     */
    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("time") Time time) {
        return "/time/form";
    }
    
    /**
     * Salvar time
     * @param time
     * @param result
     * @param attr
     * @return
     */
    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("time") Time time, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/time/form";
        }
 
        timeService.salvar(time);
        attr.addFlashAttribute("mensagem", "Time criado com sucesso.");
        return "redirect:/times/listar";
    }
    
    /**
     * Redireciona para a página form - edição do time
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
        Time time = timeService.recuperarPorId(id);
        model.addAttribute("time", time);
        return new ModelAndView("/time/form", model);
    }
    
    /**
     * Atualizar time
     * @param time
     * @param result
     * @param attr
     * @return
     */
    @PutMapping("/salvar")
    public ModelAndView atualizar(@Valid @ModelAttribute("time") Time time, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/time/form");
        }
 
        timeService.atualizar(time);
        attr.addFlashAttribute("mensagem", "Time atualizado com sucesso.");
        return new ModelAndView("redirect:/times/listar");
    }
 
    /**
     * Remover time
     * @param id
     * @param attr
     * @return
     */
    @GetMapping("/{id}/remover")
    public String remover(@PathVariable("id") long id, RedirectAttributes attr) {
        timeService.excluir(id);
        attr.addFlashAttribute("mensagem", "Time excluído com sucesso.");
        return "redirect:/times/listar";
    }
 
}
