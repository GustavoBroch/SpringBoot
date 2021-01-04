package com.leao.farmarcia.services;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.leao.farmarcia.model.Funcionario;
import com.leao.farmarcia.model.FuncionarioLogin;
import com.leao.farmarcia.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	public Funcionario CadastrarFuncionario(Funcionario funcionario) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<Funcionario> funcionarioPresente = repository.findByEmail(funcionario.getEmail()); 
		//Alteração Marcelo - if
		if(funcionarioPresente.isPresent()) {
			return null;
		}

		String senhaEncoder = encoder.encode(funcionario.getPassword());
		funcionario.setPassword(senhaEncoder);

		return repository.save(funcionario);
	}

	public Optional<FuncionarioLogin> Logar(Optional<FuncionarioLogin> funcionarioLogin) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Funcionario> funcionario = repository.findByEmail(funcionarioLogin.get().getEmail());

		if (funcionario.isPresent()) {
			if (encoder.matches(funcionarioLogin.get().getPassword(), funcionario.get().getPassword())) {

				String auth = funcionarioLogin.get().getEmail() + ":" + funcionarioLogin.get().getPassword();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));

				String authHeader = "Basic " + new String(encodedAuth);

				funcionarioLogin.get().setToken(authHeader);
				funcionarioLogin.get().setName(funcionario.get().getName());

				return funcionarioLogin;
			}
		}
		return null;
	}

}
