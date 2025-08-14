package com.odma.api.dto;




public class DireccionDTO {

    private String estado;
    private String municipio;
    private String asentamiento;
    
	public DireccionDTO(String estado, String municipio, String asentamiento) {
		super();
		this.estado = estado;
		this.municipio = municipio;
		this.asentamiento = asentamiento;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getAsentamiento() {
		return asentamiento;
	}
	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}
    
    
    

}
