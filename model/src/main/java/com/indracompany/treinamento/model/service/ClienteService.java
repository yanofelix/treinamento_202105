package com.indracompany.treinamento.model.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.indracompany.treinamento.exception.AplicacaoException;
import com.indracompany.treinamento.exception.ExceptionValidacoes;
import com.indracompany.treinamento.model.dto.ClienteDTO;
import com.indracompany.treinamento.model.entity.Cliente;
import com.indracompany.treinamento.model.repository.ClienteRepository;
import com.indracompany.treinamento.util.CpfUtil;

@Service
public class ClienteService extends GenericCrudService<Cliente, Long, ClienteRepository>{

	  public ClienteDTO buscarClientePorCpf(String cpf) {
		  
		  if (!cpfEhValido(cpf)) {
			  throw new AplicacaoException(ExceptionValidacoes.ERRO_CPF_INVALIDO);
		  }
		  
		  Cliente cli = getRepository().findByCpf(cpf);
		  
		  ClienteDTO retorno = new ClienteDTO();
		  retorno.setEmail(cli.getEmail());
		  retorno.setNome(cli.getNome());
		  retorno.setCpf(cli.getCpf());
		  retorno.setId(cli.getId());
		  
		  return retorno;
	  }
	  
	  public ClienteDTO buscarClientePorNome(String nome) {
		  Optional<Cliente> clienteFiltro = getRepository().findByNome(nome);
		  
		  if(clienteFiltro.isEmpty())
			  throw new AplicacaoException(ExceptionValidacoes.ERRO_NOME_NAO_ENCONTRADO);
		  
		  Cliente cliente = clienteFiltro.get();
		  ClienteDTO clienteDTO = new ClienteDTO();
		  clienteDTO.setEmail(cliente.getEmail());
		  clienteDTO.setNome(cliente.getNome());
		  clienteDTO.setCpf(cliente.getCpf());
		  clienteDTO.setId(cliente.getId());
		  
		  return clienteDTO;
	  }
	  
	  private boolean cpfEhValido(String cpf) {
		  return CpfUtil.validaCPF(cpf);
	  }
	  
}
