/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.velt.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author marcio
 */

@Entity
@Table (name="sexo")
public class Sexo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdSexo",nullable=false)
    private Integer idSexo;
    
    @Column (name="descricao",nullable=false,length=9)
    private String descricao;
    
    @OneToMany(mappedBy="sexo", fetch= FetchType.LAZY)
    @ForeignKey(name="PessoaSexo")
    private List<Pessoa> pessoas;
    

    public Sexo() {
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sexo other = (Sexo) obj;
        if (this.idSexo != other.idSexo && (this.idSexo == null || !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
        return hash;
    }

   
    
    
}
