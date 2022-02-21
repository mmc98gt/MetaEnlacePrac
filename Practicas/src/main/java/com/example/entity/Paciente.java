package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PACIENTE")
@PrimaryKeyJoinColumn(referencedColumnName = "USER_ID")
public class Paciente extends Usuario {

	@Column(name = "NSS")
	private String NSS;
	@Column(name = "NUM_TARJETA")
	private String numTarjeta;
	@Column(name = "TELEFONO")
	private String telefono;
	@Column(name = "DIRECCION")
	private String direccion;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "PACIENTE_MEDICO", joinColumns = { @JoinColumn(name = "ID_PACIENTE") }, inverseJoinColumns = {
	@JoinColumn(name = "ID_MEDICO") })
	private List<Medico> medicos;
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Cita> citas;
	

	/**
	 * @param userID, Entero. que identifica a un usuario
	 * @param usuario, String. Nombre de usuario
	 * @param nombre, String. Nombre real
	 * @param apellidos, String. Apellidos
	 * @param clave, String. Contraseña
	 * @param NSS, String. Nombre en la seguridad social
	 * @param numTarjeta, String. Numero de la tarjeta 
	 * @param telefono, String. Telefono del paciente
	 * @param direccion, String. Resicencia del paciente
	 * @param medicos, List. Lista de medicos que atienden al paciente
	 * @param cita, Cita. Cita actual del paciente
	 */
	public Paciente(Integer userID, String usuario, String nombre, String apellidos, String clave, String nSS,
			String numTarjeta, String telefono, String direccion, List<Medico> medicos, List<Cita> citas) {
		super(userID, usuario, nombre, apellidos, clave);
		//tras la llamada al contructor heradado, se inicializan el resto de propiedades
		NSS = nSS;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
		this.medicos = medicos;
		this.citas = citas;
	}

	/**
	 * @return el nSS
	 */
	public String getNSS() {
		return NSS;
	}

	/**
	 * @param nSS nSS del paciente
	 */
	public void setNSS(String nSS) {
		NSS = nSS;
	}

	/**
	 * @return el numTarjeta
	 */
	public String getNumTarjeta() {
		return numTarjeta;
	}

	/**
	 * @param numTarjeta numTarjeta del paciente
	 */
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	/**
	 * @return el telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono telefono del paciente
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return la direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion direccion del paciente
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return los medicos
	 */
	public List<Medico> getMedicos() {
		return medicos;
	}

	/**
	 * @param medicos medicos del paciente
	 */
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}


	/**
	 * @return las citas
	 */
	public List<Cita> getCitas() {
		return citas;
	}

	/**
	 * @param citas citas del paciente
	 */
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

}
