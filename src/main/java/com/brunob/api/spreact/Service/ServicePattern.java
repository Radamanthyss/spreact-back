package com.brunob.api.spreact.Service;

import com.brunob.api.spreact.Dto.ProdutoDto;
import com.brunob.api.spreact.Dto.Response.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface ServicePattern {

    ResponseEntity<?> insertOrUpdate(ProdutoDto produtoDto, Integer action);

    Iterable<ProdutoDto> getProdutos();

    ResponseEntity<ResponseDto> delete(Long id);

    ResponseEntity<?> getProduto(Long id);
}
