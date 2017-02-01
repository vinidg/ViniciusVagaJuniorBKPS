package br.com.Vinicius.VagaJunior.BKPS.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.Vinicius.VagaJunior.BKPS.Cliente.Cliente;

@ManagedBean(name="ICliente")
@ViewScoped
public class ClienteBean {
	private ListDataModel<Cliente> pegarCliente;

	public ListDataModel<Cliente> getPegarCliente() {
		return pegarCliente;
	}

	public void setPegarCliente(ListDataModel<Cliente> pegarCliente) {
		this.pegarCliente = pegarCliente;
	}

	
	
}
