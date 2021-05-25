package com.indracompany.treinamento.model.service;

import java.util.ArrayList;
import java.util.List;

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
	  
	  private boolean cpfEhValido(String cpf) {
		  return CpfUtil.validaCPF(cpf);
	  }
	  
	  public List<ClienteDTO> buscarClientePorNome(String nome) {
		  List<Cliente> cli = getRepository().findByNome(nome);
		  List<ClienteDTO> retorno= new ArrayList<>();
		  for(Cliente c : cli) {
			  ClienteDTO cliDTO = new ClienteDTO();
			  cliDTO.setEmail(c.getEmail());
			  cliDTO.setNome(c.getNome());
			  cliDTO.setCpf(c.getCpf());
			  cliDTO.setId(c.getId());
			  retorno.add(cliDTO);
		  }
		  
		  return retorno;
	  }
	  
}
