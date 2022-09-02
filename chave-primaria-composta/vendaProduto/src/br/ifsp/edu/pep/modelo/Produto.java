/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsp.edu.pep.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "descricao", length = 45, nullable = false)
    private String descricao;
    
    @Column(name = "quantidade", nullable = false)
    private int quantitade;
    
    @Column(name = "preco", nullable = false, precision = 8, scale = 2)
    private BigDecimal preco;

    public Produto(String descricao, int quantitade, BigDecimal preco) {
        this.descricao = descricao;
        this.quantitade = quantitade;
        this.preco = preco;
    }

    public Produto() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantitade() {
        return quantitade;
    }

    public void setQuantitade(int quantitade) {
        this.quantitade = quantitade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", quantitade=" + quantitade + ", preco=" + preco + '}';
    }
    
    
    
    
}
