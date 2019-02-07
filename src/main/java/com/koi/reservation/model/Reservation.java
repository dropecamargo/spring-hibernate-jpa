/**
 * 
 */
package com.koi.reservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Class Reservation
 * @author @dropecamargo
 *
 */

@Entity
@Table(name="reservation")
@Data
public class Reservation {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idReservation;
	@Temporal(TemporalType.DATE)
	private Date dateInReservation;
	@Temporal(TemporalType.DATE)
	private Date dateOutReservation;
	private String descReserva;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="idCompany")
	private Company company;
	
}
