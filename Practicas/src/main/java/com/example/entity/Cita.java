package com.example.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CITA")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CITA_ID")
	private Integer citaID;
	@Column(name = "FECHA_HORA")
	private Date fechaHora;
	@Column(name = "MOTIVO_CITA")
	private String motivoCita;
	@Column(name = "ATRIBUTO_11")
	private Integer attribute11;
	@ManyToOne
	@JoinColumn(name = "PACIENTE")
	private Paciente paciente;
	@ManyToOne
	@JoinColumn(name = "MEDICO")
	private Medico medico;
	@OneToOne(mappedBy = "cita", cascade = CascadeType.ALL, orphanRemoval = true)
	private Diagnostico diagnostico;
	
	/**
	 * @param citaID, Entero. ID de cita
	 * @param fechaHora, Date. fecha para la cita
	 * @param motivoCita, String. Motivo para la cita
	 * @param attribute11,Entero.  ¿?
	 * @param paciente, Paciente. paciente de la cita
	 * @param medico, Medico. medico de la cita
	 */
	public Cita(Integer citaID, Date fechaHora, String motivoCita,Integer attribute11 ,Paciente paciente, Medico medico, Diagnostico diagnostico) {
		this.citaID = citaID;
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.paciente = paciente;
		this.medico = medico;
		this.diagnostico = diagnostico;
		this.attribute11 = attribute11;
	}

	/**
	 * @return el citaID
	 */
	public Integer getCitaID() {
		return citaID;
	}

	/**
	 * @param citaID de la cita
	 */
	public void setCitaID(Integer citaID) {
		this.citaID = citaID;
	}

	/**
	 * @return la fechaHora de la cita
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora de la cita
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return el motivoCita de la cita
	 */
	public String getMotivoCita() {
		return motivoCita;
	}

	/**
	 * @param motivoCita de la cita
	 */
	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	/**
	 * @return el paciente de la cita
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente de la cita
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * @return el medico de la cita
	 */
	public Medico getMedico() {
		return medico;
	}

	/**
	 * @param medico de la cita
	 */
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	/**
	 * @return el diagnostico de la cita
	 */
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico de la cita
	 */
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return el attribute11
	 */
	public Integer getAttribute11() {
		return attribute11;
	}

	/**
	 * @param attribute11 de la cita
	 */
	public void setAttribute11(Integer attribute11) {
		this.attribute11 = attribute11;
	}
	
}
