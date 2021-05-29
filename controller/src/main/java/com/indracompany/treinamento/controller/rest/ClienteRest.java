package com.indracompany.treinamento.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indracompany.treinamento.model.dto.ClienteDTO;
import com.indracompany.treinamento.model.entity.Cliente;
import com.indracompany.treinamento.model.service.ClienteService;

@RestController
@RequestMapping("rest/Clientes")
public class ClienteRest extends GenericCrudRest<Cliente, Long, ClienteService> {
	
	@RequestMapping(value = "/busca-por-cpf/{cpf}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public  @ResponseBody ClienteDTO buscarClientePorCpf(String cpf) {
		ClienteDTO retorno = getService().buscarClientePorCpf(cpf);
		return retorno;
	}
	
	@RequestMapping(value = "/busca-por-cpf/{cpf}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public  @ResponseBody ClienteDTO buscarClientePorNome(String nome) {
		ClienteDTO retorno = getService().buscarClientePorNome(nome);
		return retorno;
	}
}
