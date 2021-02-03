package com.andreia.osworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//caso enviar null, tirar o campo
//@JsonInclude(Include.NON_NULL)
public class Problema {
	
	private Integer status;
	private OffsetDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class Campo{
		private String nome;
		private String campo;
	}

}
