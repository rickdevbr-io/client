package br.com.company.client.controller.v1;

import java.util.Objects;

import br.com.company.client.address.model.Address;

public class AddressMapper {
	
	public static AddressDto entityToAddressDto(Address entity) {
		if(Objects.isNull(entity))
			new AddressDto();
		
		return AddressDto.builder()
				.id(entity.getId())
				.clientId(entity.getClientId())
				.street(entity.getStreet())
				.complement(entity.getComplement())
				.neighbordhood(entity.getNeighbordhood())
				.city(entity.getCity())
				.state(entity.getState())
				.country(entity.getCountry())
				.createdDate(entity.getCreatedDate())
				.modifiedDate(entity.getModifiedDate())
				.build();
		
	}
	
	public static Address dtoToAddress(AddressDto dto) {
		if(Objects.isNull(dto))
			new Address();
		
		return Address.builder()
				.id(dto.getId())
				.clientId(dto.getClientId())
				.street(dto.getStreet())
				.complement(dto.getComplement())
				.neighbordhood(dto.getNeighbordhood())
				.city(dto.getCity())
				.state(dto.getState())
				.country(dto.getCountry())
				.createdDate(dto.getCreatedDate())
				.modifiedDate(dto.getModifiedDate())				
				.build();
		
	}

}
