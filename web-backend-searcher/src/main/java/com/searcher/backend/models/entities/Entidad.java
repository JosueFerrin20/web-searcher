package com.searcher.backend.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="entidad")
public class Entidad implements Serializable{
	
	private static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name="idEntidad")
	private Integer idEntidad;
	
	@Column (name="nombre")
	private String nombre;
	@Column (name="descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy="ofertaEmpleo", fetch= FetchType.LAZY)
	private List<ofertaEmpleo> ofertaEmpleos;
	
	@JoinColumn(name="fk_experiencia", nullable=false)
	@OneToOne
	private Experiencia experiencia;
	
	public Entidad() {
		super();
	}
	
	public Entidad(Integer id) {
		super();
		this.idEntidad=id;
	}
	
	public List<ofertaEmpleo> getOfertaEmpleos() {
		return ofertaEmpleos;
	}

	public void setOfertaEmpleos(List<ofertaEmpleo> ofertaEmpleos) {
		this.ofertaEmpleos = ofertaEmpleos;
	}

	public Integer getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Integer idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
