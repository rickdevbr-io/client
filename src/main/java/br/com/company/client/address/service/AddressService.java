package br.com.company.client.address.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.company.client.address.model.Address;
import br.com.company.client.address.model.AddressRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AddressService {

	private final AddressRepository addressRepository;
	
	public List<Address> loadAddressList(Long clientId){
		return addressRepository.findAllByClientId(clientId);
	}
	
	@Transactional
	public Address save (Address address) {
		return addressRepository.save(address);
	}
	
	@Transactional
	public void deleteByClientId (Long id) {
		addressRepository.deleteByClientId(id);
	}	
}
