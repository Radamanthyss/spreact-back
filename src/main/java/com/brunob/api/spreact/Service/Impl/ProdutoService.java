package com.brunob.api.spreact.Service.Impl;

import com.brunob.api.spreact.Dto.ProdutoDto;
import com.brunob.api.spreact.Dto.Response.ResponseDto;
import com.brunob.api.spreact.Entity.Produto;
import com.brunob.api.spreact.Repository.ProdutoRepository;
import com.brunob.api.spreact.Service.ServicePattern;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements ServicePattern {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ResponseDto responseDto;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<?> insertOrUpdate(ProdutoDto produtoDto, Integer action){
        try {
            produtoRepository.save(modelMapper.map(produtoDto, Produto.class));
            if (action == 0) {
                return new ResponseEntity<ProdutoDto>(produtoDto, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<ProdutoDto>(produtoDto, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseDto.setMensagem("Ocorreu um erro na operação!");
            return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.BAD_REQUEST);
        }

    }

    public Iterable<ProdutoDto> getProdutos(){
        return modelMapper.map(produtoRepository.findAll(), new TypeToken<List<ProdutoDto>>(){}.getType());
    }

    public ResponseEntity<ResponseDto> delete(Long id) {
        produtoRepository.deleteById(id);
        responseDto.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }

    public ResponseEntity<?> getProduto(Long id) {

        Optional<Produto> retorno = produtoRepository.findById(id);
        if(retorno.isEmpty()){
            responseDto.setMensagem("Não foi encontrado produto com este ID");
            return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ProdutoDto>(modelMapper.map(retorno.get(),ProdutoDto.class),HttpStatus.OK);

    }
}
