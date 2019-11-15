package com.componentes.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;

/**
 * Entity implementation class for Entity: Formulario
 *
 */
@Entity


@NamedNativeQueries({
	@NamedNativeQuery(
			name="Formulario.findAll", 
			query="SELECT * FROM formulario", 
			resultClass=Formulario.class), 
	@NamedNativeQuery(
			name="Formulario.findAllSQLWithParam", 
			query="SELECT * FROM formulario ", 
			resultClass=Formulario.class)			
})


public class Formulario implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Nombre;
	private boolean Favorito;
	@OneToMany(mappedBy="FormularioPadre",cascade= CascadeType.ALL)
	//@JoinColumn(name="IdFormulario")
	//@IndexColumn(name="Id")
	private List<Seccion> Secciones;
	
    //Usuario
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_Usuario")
	private Usuario UsuarioPadre; 
	

	
	
	private static final long serialVersionUID = 1L;

	public Formulario() {
		super();
	}   
	public List<Seccion> GetSecciones(){
		return this.Secciones;
	}
	public void SetSecciones(List<Seccion> secciones){
		this.Secciones = secciones; 
	}
	
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public boolean getFavorito() {
		return this.Favorito;
	}

	public void setFavorito(boolean Favorito) {
		this.Favorito = Favorito;
	}
	public Usuario getUsuarioPadre() {
		return this.UsuarioPadre; 
	}
	
	public void setUsuarioPadre(Usuario usuarioPadre) {
		this.UsuarioPadre = usuarioPadre; 
	}
}
