package com.indracompany.treinamento.model.dto;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"nome",
	"cpf",
	"email",
	"ativo",
})

public class ClienteDTO implements Serializable {
	
	private final static long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("cpf")
	private String cpf;
	@JsonProperty("email")
	private String email;
	@JsonProperty("ativo")
	private boolean ativo;
}