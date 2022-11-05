package com.brunob.api.spreact.Service.Impl;

import com.brunob.api.spreact.Dto.ResponseDto;
import com.brunob.api.spreact.Entity.Produto;
import com.brunob.api.spreact.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoServiceImpl {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ResponseDto produtoResponseDto;

    public ResponseEntity<?> cadastrarAlterar(Produto produto,Integer acao){

        if(produto.getNome().equals("")){
            produtoResponseDto.setMensagem("O nome do produto é obrigatório");
            return new ResponseEntity<ResponseDto>(produtoResponseDto,HttpStatus.BAD_REQUEST);
        }
        else if(produto.getMarca().equals("")){
            produtoResponseDto.setMensagem("A marca do produto é obrigatória");
            return new ResponseEntity<ResponseDto>(produtoResponseDto,HttpStatus.BAD_REQUEST);
        }else{
            if(acao == 0){
                return new ResponseEntity<Produto>(produtoRepository.save(produto),HttpStatus.CREATED);
            }else{
                return new ResponseEntity<Produto>(produtoRepository.save(produto),HttpStatus.OK);
            }
        }

    }

    public Iterable<Produto> listar(){
        return produtoRepository.findAll();
    }

    public ResponseEntity<ResponseDto> deletar(Long id) {
        produtoRepository.deleteById(id);
        produtoResponseDto.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<ResponseDto>(produtoResponseDto,HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorId(Long id) {

        Optional<Produto> retorno = produtoRepository.findById(id);
        if(retorno.isEmpty()){
            produtoResponseDto.setMensagem("Não foi encontrado produto com este ID");
            return new ResponseEntity<ResponseDto>(produtoResponseDto,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Produto>(retorno.get(),HttpStatus.OK);

    }
}
