package br.com.Vinicius.VagaJunior.BKPS.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

public class ClienteDAO {

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;

		try {
			factory = Persistence.createEntityManagerFactory("cadastro_clientes");
			entityManager = factory.createEntityManager();

		} finally {
			factory.close();
		}
		return entityManager;
	}

	@Transactional
	public Cliente cadastrar(Cliente cliente) throws Exception {
		EntityManager entityManager = getEntityManager();

		try {
			entityManager.getTransaction().begin();

			if (cliente.getId() == null) {
				entityManager.merge(cliente);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return cliente;
	}

	@Transactional
	public void excluir(Long id) {
		EntityManager entityManager = getEntityManager();
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
	    EntityManager entityManager = getEntityManager();
	    
	    Cliente cliente = null;
	    
	    try {
	    	
	    	cliente = entityManager.find(Cliente.class, id);
	    	
	    } finally {
	    	
	      entityManager.close();
	    }
	    return cliente;
	  }
}
