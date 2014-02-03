/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.velt.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author marcio
 */
@Entity
@Table (name="pessoa")
public class Pessoa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column (name="idPessoa",nullable=false)
    private Integer idPessoa;
    @Column (name="Nome",nullable=false)
    private String nome;
    @Column (name="Email",nullable=false)
    private String email;
    @Column (name="Telefone",nullable=false)
    private String telefone;
    @Column (name="CPF",nullable=false)
    private String cpf;
    @Column (name="DataDeNascimento",nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimeto;
    @Column (name="DataDeCadastro",nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;

    @ManyToOne (optional=false)
    @ForeignKey (name="PessoaSexo")
    private Pessoa pessoa;
    
    public Pessoa() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public Date getDataDeNascimeto() {
        return dataDeNascimeto;
    }

    public void setDataDeNascimeto(Date dataDeNascimeto) {
        this.dataDeNascimeto = dataDeNascimeto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
        return hash;
    }
    
    
    
    
}
