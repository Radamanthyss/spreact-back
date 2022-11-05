package com.brunob.api.spreact.Repository;

import com.brunob.api.spreact.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
