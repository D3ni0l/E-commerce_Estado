package com.senai.ecommerce.services;

import com.senai.ecommerce.dto.ProdutoDTO;
import com.senai.ecommerce.entities.Produto;
import com.senai.ecommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo;
	
	public List <ProdutoDTO> buscarTodos() {
	List<Produto> list = repo.findAll();
	return list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
	}

	public Page<ProdutoDTO> buscarPagina(Pageable pagina){
		Page<Produto> result = repo.findAll(pagina);
		return result.map(x -> new ProdutoDTO(x));
	};

}