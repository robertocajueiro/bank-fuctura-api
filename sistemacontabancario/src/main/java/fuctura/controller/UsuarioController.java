package fuctura.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fuctura.model.Usuario;
import fuctura.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("{id}")
	public Optional<Usuario> buscarPeloId(@PathVariable("id") Long id) {
		return usuarioRepository.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") Long id) {
    	 usuarioRepository
    	 .findById(id)
    	 .map(usuario -> {
    		usuarioRepository.delete(usuario);
    		return Void.TYPE;
    	 })
    	 .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado") );
    }
    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable("id") Long id, @RequestBody @Valid Usuario usuarioAtualizado) {
    	usuarioRepository
	   	 .findById(id)
	   	 .map(usuario -> {
	   		usuario.setNome(usuarioAtualizado.getNome());
	   		usuario.setCpf(usuarioAtualizado.getCpf());
	   		usuario.setEmail(usuarioAtualizado.getEmail());
	   		usuario.setIdade(usuarioAtualizado.getIdade());
	   		return usuarioRepository.save(usuario);
	   	 })
	   	 .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado") );
	    }

}
