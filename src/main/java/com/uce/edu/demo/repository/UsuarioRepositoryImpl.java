package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Usuario;

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
