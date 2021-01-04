package com.leao.farmarcia.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.leao.farmarcia.model.Funcionario;

public class FuncionarioDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String email;
	
	private String password;
	
	public FuncionarioDetailsImpl(Funcionario funcionario) {
		this.email = funcionario.getEmail();
		this.password = funcionario.getPassword();
	}
	
	public FuncionarioDetailsImpl() {
		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	

}
