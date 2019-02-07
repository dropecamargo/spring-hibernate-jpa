/**
 * 
 */
package com.koi.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koi.reservation.model.Company;

/**
 * Company Repository
 * @author @dropecamargo
 *
 */
public interface CompanyRepository extends JpaRepository<Company, String>  {
	
	/**
	 * Find Company by id
	 * @param idCompany
	 * @return
	 */
	public Company findByIdCompany(String idCompany);
}
