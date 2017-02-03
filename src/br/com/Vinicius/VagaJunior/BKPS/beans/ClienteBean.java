package br.com.Vinicius.VagaJunior.BKPS.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.com.Vinicius.VagaJunior.BKPS.Cliente.Cliente;
import br.com.Vinicius.VagaJunior.BKPS.Cliente.ClienteDAO;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ListDataModel<Cliente> pegarCliente;
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ListDataModel<Cliente> getPegarCliente() {
		return pegarCliente;
	}

	public void setPegarCliente(ListDataModel<Cliente> pegarCliente) {
		this.pegarCliente = pegarCliente;
	}

	@PostConstruct
	public void cadastrar() {
		preCadastrar();
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.cadastrar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void preCadastrar() {
		cliente = new Cliente();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
