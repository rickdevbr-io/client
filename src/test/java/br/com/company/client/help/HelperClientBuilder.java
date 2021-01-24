package br.com.company.client.help;

import java.util.Calendar;

import br.com.company.client.model.Client;

public class HelperClientBuilder {

	public static Client mockDtoToClient() {
        Calendar createdDate = Calendar.getInstance();
        createdDate.set(1990, 05, 10, 23, 0, 0);
        Calendar modifiedDate = Calendar.getInstance();
        modifiedDate.set(2020, 11, 10, 14, 0, 0);
		
		return Client.builder()
				.id(1L)
				.name("client name")
				.identification("client identification")
				.createdDate(createdDate.getTime())
				.modifiedDate(modifiedDate.getTime())				
				.build(); 
	}
}
