package com.odma.api.service;

import com.odma.api.entities.Usuario;
import com.odma.api.exception.UsuarioException;
import com.odma.api.repository.UsuarioRepository;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

	private final CopomexService copomexService;
	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository, CopomexService copomexService) {
		this.usuarioRepository = usuarioRepository;
		this.copomexService = copomexService;
	}

	public Usuario crear(Usuario usuario) {
		var direccion = copomexService.obtenerDireccionPorCodigoPostal(usuario.getCodigoPostal());
		usuario.setEstado(direccion.getEstado());
		usuario.setMunicipio(direccion.getMunicipio());
		usuario.setColonia(direccion.getAsentamiento());
		try {
			return usuarioRepository.save(usuario);
		} catch (DataIntegrityViolationException e) {
			throw new UsuarioException("El correo: " + usuario.getCorreo() + " ya esta regitrado");
		}
	}

	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	public Usuario buscar(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

	}

	public Usuario actualizar(Long id, Usuario usuario) {
		Usuario usuarioExistente = buscar(id);
		usuarioExistente.setNombre(usuario.getNombre());
		usuarioExistente.setApellidoPaterno(usuario.getApellidoPaterno());
		usuarioExistente.setApellidoMaterno(usuario.getApellidoMaterno());
		usuarioExistente.setCorreo(usuario.getCorreo());
		usuario.setCodigoPostal(usuario.getCodigoPostal());

		var direccion = copomexService.obtenerDireccionPorCodigoPostal(usuario.getCodigoPostal());
		usuarioExistente.setEstado(direccion.getEstado());
		usuarioExistente.setMunicipio(direccion.getMunicipio());
		usuarioExistente.setColonia(direccion.getAsentamiento());

		return usuarioRepository.save(usuarioExistente);
	}

	public void eliminar(Long id) {
		Usuario usuarioEliminar = buscar(id);
		usuarioRepository.delete(usuarioEliminar);
	}

}
