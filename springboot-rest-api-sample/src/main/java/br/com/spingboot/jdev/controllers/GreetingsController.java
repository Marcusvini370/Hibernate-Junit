package br.com.spingboot.jdev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.spingboot.jdev.model.Usuario;
import br.com.spingboot.jdev.repository.UsuarioRepository;


	
	@RestController
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
	    
	 
	    
	    @GetMapping(value = "listatodos") /* Nosso primeiro método de API */
	    @ResponseBody /* Retorna os  dados para o corpo da resposta */
	    public ResponseEntity<List<Usuario>> listaUsuario(){
	    	
	    	  List<Usuario> usuarios =  usuarioRepository.findAll();
	    	  
	    	  return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK); /* Retorna a lista em Json */
	    }
	        
	    	@PostMapping(value = "salvar") /* mapeia a url */
	    	@ResponseBody /* Descrição da resposta */
	    	public ResponseEntity<Usuario> salvar (@RequestBody Usuario usuario){ /* salvar usuário */
	    		
	    		Usuario user = usuarioRepository.save(usuario);
	    		
	    		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	    		
	    	}
	    	
	    	@DeleteMapping(value = "delete") /* mapeia a url */
	    	@ResponseBody /* Descrição da resposta */
	    	public ResponseEntity<String> delete (@RequestParam Long idUser){
	    		
	    		 usuarioRepository.deleteById(idUser);
	    		
	    		return new ResponseEntity<String>("User deletado com Sucesso", HttpStatus.OK);
	    		
	    	}
	    	
	    	@GetMapping(value = "buscauserid") /* mapeia a url */
	    	@ResponseBody /* Descrição da resposta */
	    	public ResponseEntity<Usuario> buscauserid (@RequestParam(name = "idUser") Long idUser){ /* Recebe os dados para consultar*/
	    		
	    		 Usuario usuario = usuarioRepository.findById(idUser).get();
	    		
	    		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	    		
	    	}
	    	
	    	@PutMapping(value = "atualizar") /* mapeia a url */
	    	@ResponseBody /* Descrição da resposta */
	    	public ResponseEntity<?> atualizar (@RequestBody Usuario usuario){
	    		
	    		if(usuario.getId() == null) {
	    			
	    			return new ResponseEntity<String>("O id não foi informado para atualização.", HttpStatus.OK);
	    			
	    		}
	    		
	    		Usuario user = usuarioRepository.saveAndFlush(usuario);
	    		
	    		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	    		
	    	}
	    	
	    	@GetMapping(value = "buscarPorNome") /* mapeia a url */
	    	@ResponseBody /* Descrição da resposta */
	    	public ResponseEntity<List<Usuario>> buscarPorNome (@RequestParam(name = "name") String name){ /* Recebe os dados para consultar*/
	    		
	    		 List<Usuario> usuario = usuarioRepository.buscarPorNome(name.trim().toUpperCase());
	    		
	    		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	    		
	    	}
	    
	    	
    
}

