package com.bank.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class RefAddressTypes {
	@Column(name="ADDRESS_TYPE_CODE")
	@Id
	private String addressTypeCode;
	
	@Column(name="ADDRESS_DESCRIPTION")
	private String addressDescription;
	
	//private Collection

}
