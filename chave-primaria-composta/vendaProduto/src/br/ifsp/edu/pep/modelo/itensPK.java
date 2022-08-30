/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsp.edu.pep.modelo;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author aluno
 */
@Embeddable
public class itensPK implements Serializable {
    @Column(name = "produto_id", insertable = false , updatable = false)
    private int venda;
    @Column(name = "venda_id", insertable = false , updatable = false)
    private int produto;

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.venda;
        hash = 53 * hash + this.produto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final itensPK other = (itensPK) obj;
        if (this.venda != other.venda) {
            return false;
        }
        return this.produto == other.produto;
    }



    
    
}
