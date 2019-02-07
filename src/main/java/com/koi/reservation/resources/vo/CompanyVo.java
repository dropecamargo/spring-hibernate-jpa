/**
 * 
 */
package com.koi.reservation.resources.vo;

import java.util.Date;

import lombok.Data;

/**
 * CompanyBo
 * @author @dropecamargo
 *
 */

@Data
public class CompanyVo {
	private String idCompany;
	private String nameCompany;
	private String addressCompany;
	private Date dateCompany;
	private Integer ageCompany;
}
