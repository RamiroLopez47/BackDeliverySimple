package com.example.demo.services.persona.usuario;

import org.springframework.stereotype.Service;

import com.example.demo.entities.persona.usuario.Rol;
import com.example.demo.repositories.persona.usuario.RolRepository;
import com.example.demo.services.BaseService;

@Service
public class RolService extends BaseService<Rol, RolRepository> {

}
