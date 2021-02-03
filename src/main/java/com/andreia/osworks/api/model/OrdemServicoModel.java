package com.andreia.osworks.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.andreia.osworks.domain.model.StatusOrdemServico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoModel { //classe para representar o modelo
	
	private Long id;
	
	private ClienteResumoModel cliente;
	private String descricao;
	private BigDecimal preco;
	private StatusOrdemServico status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizada;

}
