package com.andreia.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.andreia.osworks.domain.exception.NegocioException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
		
	@ManyToOne
	private Cliente cliente;	
	
	private String descricao;	
	private BigDecimal preco;	
	
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;	
	
	private OffsetDateTime dataAbertura;	
	private OffsetDateTime dataFinalizacao;
	
	@OneToMany(mappedBy = "ordemServico")
	private List<Comentario> comentarios = new ArrayList<>();
	
	public Boolean podeSerFinalizada() {
		return StatusOrdemServico.ABERTA.equals(getStatus());
	}
	
	public Boolean nãoPodeSerFinalizada() {
		return !podeSerFinalizada();
	}

	public void finalizar() {		
		if (podeSerFinalizada()) {
			throw new NegocioException("Ordem de serviço não pode ser finalizada.");
			
		}		
		setStatus(StatusOrdemServico.FINALIZADA);
		setDataFinalizacao(OffsetDateTime.now());
		
	}

}
