package br.com.company.client.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tb_client_clie")
@SequenceGenerator(name = "sq_client_clie", initialValue = 1, allocationSize = 1)
public class Client {

	@Id
	@GeneratedValue(generator = "sq_client_clie", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_client", nullable = false)
	private Long id;
	
	@Column(name = "st_name", nullable = false)
	private String name;
	
	@Column(name = "st_identification", nullable = false)
	private String identification;
	
	@Column(name = "dt_created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "dt_modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
}
