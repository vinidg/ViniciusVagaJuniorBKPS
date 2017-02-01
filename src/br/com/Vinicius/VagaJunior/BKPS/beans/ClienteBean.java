package br.com.Vinicius.VagaJunior.BKPS.beans;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.Vinicius.VagaJunior.BKPS.Cliente.Cliente;
import br.com.Vinicius.VagaJunior.BKPS.Cliente.ClienteDAO;

@ManagedBean(name="ICliente")
@ViewScoped
public class ClienteBean {
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
	public void cadastrar(){
		preCadastrar();
		try{
			ClienteDAO dao = new ClienteDAO();
			dao.cadastrar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void preCadastrar(){
		cliente = new Cliente();
	}
	
	
}
