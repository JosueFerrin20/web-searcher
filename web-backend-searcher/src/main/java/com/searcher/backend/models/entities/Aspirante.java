package com.searcher.backend.models.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table (name="aspirante")
public class Aspirante implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@EmbeddedId
	private AspiranteKey id;
	
	@Column (name="fechaRegistro")
	private Calendar fechaRegistro;
	@Column (name="aspiracionSalarial")
	private float aspiracionSalarial;
	
	@ManyToOne
	@MapsId("idOfertaEmpleo")
	@JoinColumn(name="idOfertaEmpleo")
	private ofertaEmpleo ofertaEmpleo;
	
	@ManyToOne
	@MapsId("idTrabajador")
	@JoinColumn(name="idTrabajador")
	private Trabajador trabajador;
	
	
	
//	@OneToMany(mappedBy="aspirante", fetch= FetchType.LAZY)
//	private List<Experiencia> experiencias;
//	
//	public List<Experiencia> getExperiencias() {
//		return experiencias;
//	}
//
//	public void setExperiencias(List<Experiencia> experiencias) {
//		this.experiencias = experiencias;
//	}

	public Aspirante() {
		super();
	}

	public Aspirante(AspiranteKey id) {
	super();
	this.id = id;
	}

	public ofertaEmpleo getOfertaEmpleo() {
		return ofertaEmpleo;
	}

	public void setOfertaEmpleo(ofertaEmpleo ofertaEmpleo) {
		this.ofertaEmpleo = ofertaEmpleo;
	}

	public Calendar getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Calendar fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public float getAspiracionSalarial() {
		return aspiracionSalarial;
	}

	public void setAspiracionSalarial(float aspiracionSalarial) {
		this.aspiracionSalarial = aspiracionSalarial;
	}

	public AspiranteKey getId() {
		return id;
	}

	public void setId(AspiranteKey id) {
		this.id = id;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}	
	 
}
