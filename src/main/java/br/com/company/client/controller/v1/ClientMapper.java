package br.com.company.client.controller.v1;

import java.util.Objects;

import br.com.company.client.model.Client;

public class ClientMapper {
	
	public static ClientDto entityToClientDto(Client entity) {
		if(Objects.isNull(entity))
			new ClientDto();
		
		return ClientDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.identification(entity.getIdentification())
				.createdDate(entity.getCreatedDate())
				.modifiedDate(entity.getModifiedDate())
				.build();
		
	}
	
	public static Client dtoToClient(ClientDto dto) {
		if(Objects.isNull(dto))
			new Client();
		
		return Client.builder()
				.id(dto.getId())
				.name(dto.getName())
				.identification(dto.getIdentification())
				.createdDate(dto.getCreatedDate())
				.modifiedDate(dto.getModifiedDate())				
				.build();
		
	}

}
