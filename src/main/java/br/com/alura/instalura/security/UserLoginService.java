package br.com.alura.instalura.security;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.alura.instalura.models.Usuario;

@Repository
public class UserLoginService implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String jpql = "select u from Usuario u where u.login = :login";

		try {
			return manager.createQuery(jpql, Usuario.class)
					.setParameter("login", username)
					.getSingleResult();
			
		} catch (NoResultException e) {
			throw new UsernameNotFoundException("O usuário " + username + " não foi encontrado!");
		}
	}

}
