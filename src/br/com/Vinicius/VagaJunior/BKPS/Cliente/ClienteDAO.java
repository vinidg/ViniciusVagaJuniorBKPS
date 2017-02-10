package br.com.Vinicius.VagaJunior.BKPS.Cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClienteDAO {

	EntityManagerFactory factory = null;
	EntityManager entityManager = null;

	private EntityManager getEntityManager() {

		try {
			factory = Persistence.createEntityManagerFactory("default");
			entityManager = factory.createEntityManager();

		} catch (Exception ex) {
			System.err.println("Erro ao criar a factory: " + ex);
		}
		return entityManager;
	}

	public Cliente cadastrar(Cliente cliente) {
		entityManager = getEntityManager();

		try {
			entityManager.getTransaction().begin();
			if(consultar(cliente.getId()) == null){
				entityManager.persist(cliente);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return cliente;
	}
	
	public Cliente editar(Cliente cliente) {
		entityManager = getEntityManager();

		try {
			entityManager.getTransaction().begin();
			if(consultar(cliente.getId()) != null){				
				entityManager.merge(cliente);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return cliente;
	}

	public void excluir(Long id) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();

			Cliente cliente = entityManager.find(Cliente.class, id);

			entityManager.remove(cliente);

			entityManager.getTransaction().commit();

		} finally {
			entityManager.close();
		}
	}

	public Cliente consultar(Long id) {
		entityManager = getEntityManager();
		Cliente cliente = null;
		try {
			cliente = entityManager.find(Cliente.class, id);
		} finally {

			entityManager.close();
		}
		return cliente;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarTodos() {
		entityManager = getEntityManager();

		Query consulta = entityManager.createQuery("select c from Cliente c");
		List<Cliente> clientes = consulta.getResultList();

		entityManager.close();

		return clientes;
	}

}
