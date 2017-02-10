package br.com.Vinicius.VagaJunior.BKPS.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.Vinicius.VagaJunior.BKPS.Cliente.Cliente;
import br.com.Vinicius.VagaJunior.BKPS.Cliente.ClienteDAO;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Cliente> pegarCliente;
	private Cliente cliente = new Cliente();

	public void cadastrar() {

		ClienteDAO dao = new ClienteDAO();
		try {
			dao.cadastrar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		try {
			clienteDAO.editar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> getListar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		pegarCliente = clienteDAO.listarTodos();

		return pegarCliente;
	}

	public void remover(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		try {
			clienteDAO.excluir(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void consultarPeloId(Long id)
	{
		ClienteDAO clienteDAO = new ClienteDAO();
		try{
			cliente = clienteDAO.consultar(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@PostConstruct
	public void init() {
		cliente = new Cliente();
	}

	public List<Cliente> getPegarCliente() {
		return pegarCliente;
	}

	public void setPegarCliente(List<Cliente> pegarCliente) {
		this.pegarCliente = pegarCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Collection<Estados> getEstados() {

		SortedMap<String, Estados> map = new TreeMap<String, Estados>();
		for (Estados e : Estados.values()) {
			map.put(e.getNome(), e);
		}
		return map.values();
	}

}
