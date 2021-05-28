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
		  
		  List<Cliente> clientes = getRepository().findByNomeContainingIgnoreCase(nome);
		  
		  if(clientes.size() == 0) {
			  throw new AplicacaoException(ExceptionValidacoes.ALERTA_NENHUM_REGISTRO_ENCONTRADO);
		  }
		  
		  List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		  clientes.forEach(cli->{
			  ClienteDTO retorno = new ClienteDTO();
			  retorno.setEmail(cli.getEmail());
			  retorno.setNome(cli.getNome());
			  retorno.setCpf(cli.getCpf());
			  retorno.setId(cli.getId());
			  clientesDTO.add(retorno);
		  });
		  
		  return clientesDTO;
	  }
	  
}
