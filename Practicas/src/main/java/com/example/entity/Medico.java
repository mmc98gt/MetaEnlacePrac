package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICO")
@PrimaryKeyJoinColumn(referencedColumnName = "USER_ID")
public class Medico extends Usuario {

	@Column(name = "NUM_COLEGIADO")
	private String numColegiado;
	@ManyToMany(mappedBy = "medicos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Paciente> pacientes;
	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
	private List<Cita> citas;

	/**
	 * @param userID, Entero. que identifica a un usuario
	 * @param usuario, String. Nombre de usuario
	 * @param nombre, String. Nombre real
	 * @param apellidos, String. Apellidos
	 * @param clave, String. Contraseña
	 * @param numColegiado, String. Numero de colegiado del medico
	 * @param pacientes, List. Lista de pacientes
	 * @param cita, Cita. Cita actual del medico
	 */
	public Medico(Integer userID, String usuario, String nombre, String apellidos, String clave, String numColegiado,
			List<Paciente> pacientes, List<Cita> citas) {
		super(userID, usuario, nombre, apellidos, clave);
		this.numColegiado = numColegiado;
		this.pacientes = pacientes;
		this.citas = citas;
	}

	/**
	 * @return el numColegiado
	 */
	public String getNumColegiado() {
		return numColegiado;
	}

	/**
	 * @param numColegiado numColegiado del medico
	 */
	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	/**
	 * @return los pacientes
	 */
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	/**
	 * @param pacientes pacientes del medico
	 */
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	/**
	 * @return las citas
	 */
	public List<Cita> getCitas() {
		return citas;
	}

	/**
	 * @param citas las citas del medico
	 */
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

}
