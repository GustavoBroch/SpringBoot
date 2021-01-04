package com.leao.farmarcia.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leao.farmarcia.model.Funcionario;
import com.leao.farmarcia.repository.FuncionarioRepository;

@Service
public class FuncionarioDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Funcionario> funcionario = funcionarioRepository.findByEmail(email);
		funcionario.orElseThrow(() -> new UsernameNotFoundException(email + "not found."));
		
		return funcionario.map(FuncionarioDetailsImpl::new).get();
	}


}
