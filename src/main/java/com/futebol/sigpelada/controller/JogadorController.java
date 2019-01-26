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

import com.futebol.sigpelada.dominio.Jogador;
import com.futebol.sigpelada.service.JogadorService;
/**
 * Controller da Classe Jogador
 * @author sergioluna
 *
 */
@Controller
@RequestMapping("times/{timeId}/jogadores")
public class JogadorController {
	/**
	 * Service de Jogador
	 */
    @Autowired
    private JogadorService jogadorService;
    
    /**
     * Listar jogadores
     * @param timeId
     * @param model
     * @return
     */
    @GetMapping("/listar")
    public ModelAndView listar(@PathVariable("timeId") long timeId, ModelMap model) {
        model.addAttribute("jogadores", jogadorService.recuperarPorTime(timeId));
        model.addAttribute("timeId", timeId);
        return new ModelAndView("/jogador/list", model);
    }
    
    /**
     * Redireciona para a página form - cadastro de jogador
     * @param jogador
     * @param timeId
     * @return
     */
    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("jogador") Jogador jogador, @PathVariable("timeId") long timeId) {
        return "/jogador/form";
    }
    
    /**
     * Salvar jogador
     * @param timeId
     * @param jogador
     * @param result
     * @param attr
     * @return
     */
    @PostMapping("/salvar")
    public String salvar(@PathVariable("timeId") long timeId, @Valid @ModelAttribute("jogador") 
          Jogador jogador, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/jogador/form";
        }
 
        jogadorService.salvar(jogador, timeId);
        attr.addFlashAttribute("mensagem", "Jogador salvo com sucesso.");
        return "redirect:/times/" + timeId + "/jogadores/listar";
    }
    
    /**
     * Redireciona para a página form - edição de um jogador
     * @param timeId
     * @param jogadorId
     * @param model
     * @return
     */
    @GetMapping("/{jogadorId}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("timeId") long timeId, @PathVariable("jogadorId") 
          long jogadorId, ModelMap model) {
        Jogador jogador = jogadorService.recuperarPorTimeIdEJogadorId(timeId, jogadorId);
        model.addAttribute("jogador", jogador);
        model.addAttribute("timeId", timeId);
        return new ModelAndView("/jogador/form", model);
    }
    
    /**
     * Atualizar jogador
     * @param timeId
     * @param jogador
     * @param result
     * @param attr
     * @return
     */
    @PutMapping("/salvar")
    public ModelAndView atualizar(@PathVariable("timeId") long timeId, @Valid @ModelAttribute("jogador") 
          Jogador jogador, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/jogador/form");
        }
 
        jogadorService.atualizar(jogador, timeId);
        attr.addFlashAttribute("mensagem", "Jogador atualizado com sucesso.");
        return new ModelAndView("redirect:/times/" + timeId + "/jogadores/listar");
    }
    
    /**
     * Remover um jogador
     * @param timeId
     * @param jogadorId
     * @param attr
     * @return
     */
    @GetMapping("/{jogadorId}/remover")
    public String remover(@PathVariable("timeId") long timeId, @PathVariable("jogadorId") 
          long jogadorId, RedirectAttributes attr) {
        jogadorService.excluir(timeId, jogadorId);
        attr.addFlashAttribute("mensagem", "Jogador excluído com sucesso.");
        return "redirect:/times/" + timeId + "/jogadores/listar";
    }
}
