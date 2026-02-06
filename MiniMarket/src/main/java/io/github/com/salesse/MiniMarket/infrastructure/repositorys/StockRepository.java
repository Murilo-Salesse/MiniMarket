package io.github.com.salesse.MiniMarket.infrastructure.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.com.salesse.MiniMarket.infrastructure.persistence.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, UUID> {

}
