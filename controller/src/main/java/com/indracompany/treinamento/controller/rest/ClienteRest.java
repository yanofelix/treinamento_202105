package com.indracompany.treinamento.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indracompany.treinamento.model.dto.ClienteDTO;
import com.indracompany.treinamento.model.entity.Cliente;
import com.indracompany.treinamento.model.service.ClienteService;

@RestController
@RequestMapping("rest/clientes")
public class ClienteRest extends GenericCrudRest<Cliente, Long, ClienteService>{
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/buscar-por-cpf/{cpf}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ClienteDTO buscarClientePorCpf(@PathVariable String cpf) {
		ClienteDTO retorno = clienteService.buscarClientePorCpf(cpf);
		return retorno;
	}
	
	@RequestMapping(value = "/buscar-por-nome/{nome}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ClienteDTO buscarClientePorNome(@PathVariable String nome) {
		ClienteDTO retorno = clienteService.buscarClientePorNome(nome);
		return retorno;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ClienteDTO salvarCliente(@RequestBody Cliente cliente) {
		ClienteDTO retorno = clienteService.salvarCliente(cliente);
		return retorno;
	}

}
