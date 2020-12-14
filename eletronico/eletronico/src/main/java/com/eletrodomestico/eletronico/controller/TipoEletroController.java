package com.eletrodomestico.eletronico.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eletrodomestico.eletronico.model.TipoEletro;
import com.eletrodomestico.eletronico.repository.TipoEletroRepository;

@RestController
@RequestMapping("/tipo")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class TipoEletroController {

	@Autowired
	private TipoEletroRepository repository;

	@GetMapping()
	public ResponseEntity<List<TipoEletro>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoEletro> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping()
	public ResponseEntity<TipoEletro> post(@RequestBody TipoEletro tipoEletro) {
		tipoEletro.setDescricao(tipoEletro.getDescricao().toLowerCase());

		if (tipoEletro.getDescricao().equals("eletro-domestico")
				|| tipoEletro.getDescricao().equals("eletro-eletronico")) {
			for (TipoEletro verifica : repository.findAll()) {
				// System.out.println(verifica.getDescricao());
				if (verifica.getDescricao().equals(tipoEletro.getDescricao())) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tipoEletro));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PutMapping()
	public ResponseEntity<TipoEletro> put(@RequestBody TipoEletro tipoEletro) {
		tipoEletro.setDescricao(tipoEletro.getDescricao().toLowerCase());

		if (tipoEletro.getDescricao().equals("eletro-domestico")
				|| tipoEletro.getDescricao().equals("eletro-eletronico")) {
			for (TipoEletro verifica : repository.findAll()) {
				// System.out.println(verifica.getDescricao());
				if (verifica.getDescricao().equals(tipoEletro.getDescricao())) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}
			}
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(tipoEletro));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<TipoEletro> delete(@PathVariable long id) {

		Optional<TipoEletro> idTeste = repository.findById(id);

		if (idTeste.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
