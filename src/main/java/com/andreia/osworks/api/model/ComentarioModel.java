package com.andreia.osworks.api.model;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioModel {
	
	private Long id;
	private String descricao;
	private OffsetDateTime dataEnvio;

}
