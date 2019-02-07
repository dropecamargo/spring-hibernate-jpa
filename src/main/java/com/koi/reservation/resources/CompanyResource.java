/**
 * 
 */
package com.koi.reservation.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koi.reservation.model.Company;
import com.koi.reservation.resources.vo.CompanyVo;
import com.koi.reservation.services.CompanyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Company Resourse
 * 
 * @author @dropecamargo
 *
 */
@RestController
@RequestMapping("/api/company")
@Api(tags = "company")
public class CompanyResource {
	private CompanyService companyService;
	
	public CompanyResource(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear empresa", notes = "Servicio para crear una nueva empresa")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Empresa creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<Company> creted(@RequestBody CompanyVo companyvo) {
		Company company = new Company();
		company.setIdCompany(companyvo.getIdCompany());
		company.setNameCompany(companyvo.getNameCompany());
		company.setAddressCompany(companyvo.getAddressCompany());
		company.setAgeCompany(companyvo.getAgeCompany());
		company.setDateCompany(companyvo.getDateCompany());
		return new ResponseEntity<>(this.companyService.create(company), HttpStatus.CREATED);
	}
}
