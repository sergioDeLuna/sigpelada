package com.futebol.sigpelada.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
/**
 * Classe domínio para os Jogadores
 * @author sergioluna
 *
 */
@Entity
@Table(name = "jogadores")
public class Jogador {
	
	/**
	 * Id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   
    /**
     * Nome do Jogador
     */
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String nome;
    
    /**
     * Setor onde o jogador (funcionário) trabalha
     */
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String setor;
    
    /**
     * Posição em que o jogador joga
     */
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String posicao;
    
    /**
     * Número da Camisa do Jogador
     */
    @Range(min = 0, max = 10)
    @Column(nullable = false)
    private int numeroCamisa;
    
    /**
     * Time no qual o jogador está vinculado
     */
    @ManyToOne
    @JoinColumn(name = "id_time_fk")
    private Time time;

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
	 * @return the setor
	 */
	public String getSetor() {
		return setor;
	}

	/**
	 * @param setor the setor to set
	 */
	public void setSetor(String setor) {
		this.setor = setor;
	}

	/**
	 * @return the posicao
	 */
	public String getPosicao() {
		return posicao;
	}

	/**
	 * @param posicao the posicao to set
	 */
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	/**
	 * @return the numeroCamisa
	 */
	public int getNumeroCamisa() {
		return numeroCamisa;
	}

	/**
	 * @param numeroCamisa the numeroCamisa to set
	 */
	public void setNumeroCamisa(int numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
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
 
}
