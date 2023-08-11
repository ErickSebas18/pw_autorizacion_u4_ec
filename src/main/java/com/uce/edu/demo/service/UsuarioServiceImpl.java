package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IUsuarioRepository;
import com.uce.edu.demo.repository.modelo.Usuario;

import static java.util.Collections.emptyList;;

@Service
public class UsuarioServiceImpl implements UserDetailsService{
	
	@Autowired
	private IUsuarioRepository iUsuarioRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario user = this.iUsuarioRepository.buscarPorUserName(username);
		return new User(user.getUserName(),user.getPassword(),emptyList());
	}

	
}
