package com.example.demo.dtos;

public class PlatoDTO {
  private  String denominacion;
  private int total;

  public PlatoDTO() {
}

public PlatoDTO(String denominacion, int total) {
    this.denominacion = denominacion;
    this.total = total;
}
  public String getDenominacion() {
      return denominacion;
  }

  public void setDenominacion(String denominacion) {
      this.denominacion = denominacion;
  }

  public int getTotal() {
      return total;
  }

  public void setTotal(int total) {
      this.total = total;
  }

 
  
}