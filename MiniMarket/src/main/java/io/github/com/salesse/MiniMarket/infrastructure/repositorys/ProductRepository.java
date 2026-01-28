package io.github.com.salesse.MiniMarket.infrastructure.repositorys;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.com.salesse.MiniMarket.infrastructure.persistence.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

	@Query("""
			    select p
			    from ProductEntity p
			    where p.active = true
			      and upper(trim(p.name)) like upper(concat('%', ?1, '%'))
			""")
	List<ProductEntity> findProductsName(String name);
}
