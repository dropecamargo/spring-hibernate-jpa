/**
 * 
 */
package com.koi.reservation.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koi.reservation.model.Company;
import com.koi.reservation.repository.CompanyRepository;

/**
 * Company Sevice
 * 
 * @author @dropecamargo
 *
 */
@Service
@Transactional(readOnly = true)
public class CompanyService {
	public CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	/**
	 * Crete company
	 * @param company
	 * @return
	 */
	@Transactional
	public Company create(Company company) {
		return this.companyRepository.save(company);
	}

}
