package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DIAGNOSTICO")
public class Diagnostico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DIAGNOSTICO_ID")
	private Integer diagnosticoID;
	@Column(name = "VALORACION_ESPECIALISTA")
	private String valoracionEspecialista;
	@Column(name = "ENFERMEDAD")
	private String enfermedad;
	@OneToOne
	@JoinColumn(name = "CITA")
	private Cita cita;
	
	/**
	 * @param diagnosticoID, Entero. ID del diagnostico
	 * @param valoracionEspecialista, String. Valoracion del medico
	 * @param enfermedad, String. enfermedad detectada por el medico
	 * @param cita, Cita. Cita a la cual pertenece el diagnostico
	 */
	public Diagnostico(Integer diagnosticoID, String valoracionEspecialista, String enfermedad, Cita cita) {
		this.diagnosticoID = diagnosticoID;
		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
		this.cita = cita;
	}

	/**
	 * @return el diagnosticoID del dignostico
	 */
	public int getDiagnosticoID() {
		return diagnosticoID;
	}

	/**
	 * @param diagnosticoID del dignostico
	 */
	public void setDiagnosticoID(Integer diagnosticoID) {
		this.diagnosticoID = diagnosticoID;
	}

	/**
	 * @return valoracionEspecialista del dignostico
	 */
	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}

	/**
	 * @param valoracionEspecialista la valoracionEspecialista del dignostico
	 */
	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}

	/**
	 * @return la enfermedad del dignostico
	 */
	public String getEnfermedad() {
		return enfermedad;
	}

	/**
	 * @param enfermedad del dignostico
	 */
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	/**
	 * @return la cita del dignostico
	 */
	public Cita getCita() {
		return cita;
	}

	/**
	 * @param cita del dignostico
	 */
	public void setCita(Cita cita) {
		this.cita = cita;
	}

}
