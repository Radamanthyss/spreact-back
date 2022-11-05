package com.brunob.api.spreact.Controller;

import com.brunob.api.spreact.Dto.ResponseDto;
import com.brunob.api.spreact.Entity.Produto;
import com.brunob.api.spreact.Service.Impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @GetMapping
    public Iterable<Produto> getProdutos(){
        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduto(@PathVariable Long id){
        return produtoService.listarPorId(id);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto){
        return produtoService.cadastrarAlterar(produto,0);
    }

    @PutMapping
    public ResponseEntity<?> alterar(@RequestBody Produto produto){
        return produtoService.cadastrarAlterar(produto,1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deletar(@PathVariable Long id){
        return produtoService.deletar(id);
    }
}
