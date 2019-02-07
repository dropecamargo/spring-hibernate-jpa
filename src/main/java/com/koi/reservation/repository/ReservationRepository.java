/**
 * 
 */
package com.koi.reservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.koi.reservation.model.Reservation;

/**
 * Reservation Repository
 * 
 * @author @dropecamargo
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, String> {

	@Query("Select r from Reservation r where r.dateInReservation =: dateIn and dateOutReservation =: dateOut")
	public List<Reservation> find(@Param("dateIn") Date dateIn, @Param("dateOut") Date dateOut);
}
