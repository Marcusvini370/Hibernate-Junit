package br.com.spingboot.jdev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.spingboot.jdev.model.Usuario;
import br.com.spingboot.jdev.repository.UsuarioRepository;


	
	@RestController
	@RequestMapping("/greetings");
	public class GreetingsController {
		
		@Autowired /*IC / CD OU CDI - Injeção de dependencia */
		private UsuarioRepository usuarioRepository;
		
		@RequestMapping(value = "/mostrarnome/{name}", method = RequestMethod.GET)
	    @ResponseStatus(HttpStatus.OK)
	    public String greetingText(@PathVariable String name) {
	        return "Spring Boot API: " + name + "!";
	    }
	    
		@RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
	    @ResponseStatus(HttpStatus.OK)
	    public String retornaOlaMundo(@PathVariable String nome) {
	    	
	    	Usuario usuario =  new Usuario();
	    	
	    	usuario.setNome(nome);

	    	usuarioRepository.save(usuario);
	    	
	    	return "Ola mundo " + nome; 
	    	
	    }
	    
	    @GetMapping
	    public List<Usuario> listar() {
	    	return usuarioRepository.findAll();
	    }
    
}

