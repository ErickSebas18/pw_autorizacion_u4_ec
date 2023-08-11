package com.uce.edu.demo.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements IUsuarioRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Usuario buscarPorUserName(String userName) {
		// TODO Auto-generated method stub
		TypedQuery<Usuario> myQuery = this.entityManager.createQuery("Select u from Usuario u where u.userName = :userName", Usuario.class);
		myQuery.setParameter("userName", userName);
		return myQuery.getSingleResult();
	}

	
}
