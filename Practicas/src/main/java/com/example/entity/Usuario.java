package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer userID;
	@Column(name = "USUARIO")
	private String usuario;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDOS")
	private String apellidos;
	@Column(name = "CLAVE")
	private String clave;
	
	/**
	 * @param userID, Entero. que identifica a un usuario
	 * @param usuario, String. Nombre de usuario
	 * @param nombre, String. Nombre real
	 * @param apellidos, String. Apellidos
	 * @param clave, String. Contraseña
	 */
	public Usuario(Integer userID, String usuario, String nombre, String apellidos, String clave) {
		this.userID = userID;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.clave = clave;
	}

	/**
	 * @return el userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID del usuario
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	/**
	 * @return el usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario del usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return los apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos del usuario
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return la clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave del usuario
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}



}
