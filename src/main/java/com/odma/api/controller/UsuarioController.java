package com.odma.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.odma.api.entities.Usuario;
import com.odma.api.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

	@Autowired
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) throws Exception {
		Usuario nuevoUsuario = usuarioService.crear(usuario);
		return ResponseEntity.ok(nuevoUsuario);
	}

	@GetMapping
	public List<Usuario> listar() {
		return usuarioService.listar();
	}

	@GetMapping("/{id}")
	public Usuario buscar(@PathVariable Long id) {
		return usuarioService.buscar(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) throws Exception {
		Usuario usuarioActualizado = usuarioService.actualizar(id, usuario);
		return ResponseEntity.ok(usuarioActualizado);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		usuarioService.eliminar(id);
	}

}
