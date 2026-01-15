package io.github.com.salesse.MiniMarket.infrastructure.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.com.salesse.MiniMarket.infrastructure.persistence.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

}
