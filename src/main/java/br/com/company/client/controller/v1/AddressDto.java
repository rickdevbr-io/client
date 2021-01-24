package br.com.company.client.controller.v1;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

	private Long id;
	private Long clientId;
	private String street;
	private String complement;
	private String neighbordhood;
	private String city;
	private String state;
	private String country;
	private Date createdDate;
	private Date modifiedDate;
	
}
