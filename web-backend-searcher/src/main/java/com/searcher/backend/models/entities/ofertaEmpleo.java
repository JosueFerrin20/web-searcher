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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="ofertaEmpleo")
public class ofertaEmpleo implements Serializable{
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name="idOfertaEmpleo")
	private Integer idOfertaEmpleo;
	
	@Column (name="puesto")
	private String puesto;
	@Column (name="rangoSueldo")
	private float rangoSueldo;
	
	
	@JoinColumn(name="fk_entidad", referencedColumnName="idEntidad")
	@ManyToOne
	private Entidad entidad;
	
	public ofertaEmpleo() {
		super();
	}
	
	public ofertaEmpleo(int id) {
		super();
		this.idOfertaEmpleo=id;
	}
	
	
	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public Integer getIdOfertaEmpleo() {
		return idOfertaEmpleo;
	}

	public void setIdOfertaEmpleo(Integer idOfertaEmpleo) {
		this.idOfertaEmpleo = idOfertaEmpleo;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public float getRangoSueldo() {
		return rangoSueldo;
	}

	public void setRangoSueldo(float rangoSueldo) {
		this.rangoSueldo = rangoSueldo;
	}
	
	
}
