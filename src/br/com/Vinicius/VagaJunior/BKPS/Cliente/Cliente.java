package br.com.Vinicius.VagaJunior.BKPS.Cliente;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.Vinicius.VagaJunior.BKPS.beans.Estados;

@Entity
@Table(name="Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
	@SequenceGenerator(name = "sq_cliente", sequenceName = "sq_cliente", allocationSize = 1, initialValue = 1)
	private Long id;
	private String nome;
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	private String telefone;
	private String email;
	private String Endereco;
	private String Cidade;
	private Estados estados;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public Estados getEstados() {
		return estados;
	}
	public void setEstados(Estados estados) {
		this.estados = estados;
	}
}
