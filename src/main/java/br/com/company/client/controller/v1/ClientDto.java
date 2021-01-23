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
public class ClientDto {

	private Long id;
	private String name;
	private String identification;
	private Date createdDate;
	private Date modifiedDate;
	
}
