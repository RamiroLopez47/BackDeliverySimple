package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

public class ClienteDTO {
    private long id;

    private String nombre;

    private String apellido;
private List<PlatoDTO> platosDTO= new ArrayList();


public ClienteDTO() {
}

public ClienteDTO(long id, String nombre, String apellido, List<PlatoDTO> platosDTO) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.platosDTO = platosDTO;
}

public ClienteDTO(long id, String nombre, String apellido) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<PlatoDTO> getPlatosDTO() {
        return platosDTO;
    }

    public void setPlatosDTO(List<PlatoDTO> platosDTO) {
        this.platosDTO = platosDTO;
    }

    
}