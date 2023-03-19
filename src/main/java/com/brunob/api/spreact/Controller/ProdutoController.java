package com.brunob.api.spreact.Controller;

import com.brunob.api.spreact.Dto.ProdutoDto;
import com.brunob.api.spreact.Dto.Response.ResponseDto;
import com.brunob.api.spreact.Service.Impl.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Iterable<ProdutoDto> getProdutos(){
        return produtoService.getProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduto(@PathVariable Long id){
        return produtoService.getProduto(id);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ProdutoDto produtoDto){
        return produtoService.insertOrUpdate(produtoDto,0);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProdutoDto produtoDto){
        return produtoService.insertOrUpdate(produtoDto,1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id){
        return produtoService.delete(id);
    }
}
