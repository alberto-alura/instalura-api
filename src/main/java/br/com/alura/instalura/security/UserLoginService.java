package br.com.alura.instalura.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.alura.instalura.models.Usuario;

@Repository
public class UserLoginService implements UserDetailsService{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u where u.login = :login",Usuario.class).setParameter("login", login);
		List<Usuario> users = query.getResultList();

		if (users.isEmpty()) {
			throw new UsernameNotFoundException("O usuario " + login + " não existe");
		}
		
		return users.get(0);
	}

}
