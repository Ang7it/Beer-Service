package com.angshit.domain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Beer {

	@Id
	@GeneratedValue(generator= "UUID")
	@GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 36,updatable = false,columnDefinition = "varchar",nullable = false)
	private UUID uuid;
	
	@Version
	private Long version;
	
	@CreationTimestamp
	@Column(updatable = false)
	private OffsetDateTime createdDatetime;
	
	@UpdateTimestamp
	private OffsetDateTime updatedDatetime;
	
	private String beerName;
	private String beerStyle;
	
	@Column(unique = true)
	private Long upc;
	
	private BigDecimal price;
	
	private Integer minOnHand;
	private Integer quantityToBrew;
}
