package com.futebol.sigpelada.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 * Classe domínio para Time
 * @author sergioluna
 *
 */
@Entity
@Table(name = "times")
public class Time {
	/**
	 * Id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * Nome do Time
     */
    @NotBlank
    @Size(min = 2, max = 60)
    @Column(nullable = false, length = 60)
    private String nome;
    
    /**
     * Uniforme do Time
     */
    @NotBlank
    @Column(nullable = false)
    private String uniforme;
    
    /**
     * Jogadores de um time
     */
    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<Jogador> jogadores;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the uniforme
	 */
	public String getUniforme() {
		return uniforme;
	}

	/**
	 * @param uniforme the uniforme to set
	 */
	public void setUniforme(String uniforme) {
		this.uniforme = uniforme;
	}

	/**
	 * @return the jogadores
	 */
	public List<Jogador> getJogadores() {
		return jogadores;
	}

	/**
	 * @param jogadores the jogadores to set
	 */
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
    
 
}
