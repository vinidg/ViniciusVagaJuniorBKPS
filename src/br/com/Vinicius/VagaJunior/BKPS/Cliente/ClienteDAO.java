package br.com.Vinicius.VagaJunior.BKPS.Cliente;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteDAO {

	private EntityManager getEntityManager() throws SQLException {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;

		try {
			factory = Persistence.createEntityManagerFactory("default");
			entityManager = factory.createEntityManager();

		}catch (Exception ex) {
            System.err.println("Erro ao criar a factory: "
                    + ex);
        }
		return entityManager;
	}

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

	
	public void excluir(Long id) throws SQLException {
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
	
	public Cliente consultar(Long id) throws SQLException {
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
