package com.example.demo.services.persona.usuario;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.entities.persona.usuario.Usuario;

import com.example.demo.repositories.persona.usuario.CajeroRepository;
import com.example.demo.repositories.persona.usuario.ClienteRepository;
import com.example.demo.repositories.persona.usuario.UsuarioRepository;
import com.example.demo.services.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {

    
      @Autowired private ClienteRepository clienteRepository;
      
      @Autowired private CajeroRepository cajeroRepository;

    @Override
    public Usuario update(long id, Usuario usuario) throws Exception {
        try {
            Optional<Usuario> entityOptional = this.repository.findById(id);
            usuario.setId(entityOptional.get().getId());
            usuario = this.repository.save(usuario);

            return usuario;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }

    }

    /*
     * public Usuario findByEmail(String email) { // En vez de usuario también puedo
     * devolver Object Optional<Usuario> entityOptional;
     * 
     * try { entityOptional = Optional.of(this.cajeroRepository.findByEmail(email));
     * // El Optional.of deben llevarlo // querys personalizadas, sino da // error
     * de compilación return entityOptional.get();
     * 
     * } catch (Exception e) { // Si llega aca el usuario no tiene ese mail, se pasa
     * al siguiente try/catch y // asi } try { entityOptional =
     * Optional.of(this.clienteRepository.findByEmail(email)); return
     * entityOptional.get();
     * 
     * } catch (Exception ee) {
     * 
     * } return null; }
     */
    public Usuario findByEmail(String email) {
        return this.repository.findByEmail(email);
    }
    
    public List<Usuario> clientesPeriodo(String fechaInicio, String fechaFin) throws Exception{
		
		try {
			return this.repository.clientesPeriodo(fechaInicio, fechaFin);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}	
	
    
}