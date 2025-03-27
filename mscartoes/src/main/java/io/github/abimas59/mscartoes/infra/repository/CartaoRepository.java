package io.github.abimas59.mscartoes.infra.repository;

import io.github.abimas59.mscartoes.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao,Long> {
    List<Cartao> findByRendaLessThanEqual(BigDecimal renda);
}
