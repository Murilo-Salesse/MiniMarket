package io.github.com.salesse.MiniMarket.infrastructure.repositorys;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.com.salesse.MiniMarket.infrastructure.persistence.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {

	@Query("""
			    select c
			    from CategoryEntity c
			    where upper(trim(c.description)) like upper(concat('%', ?1, '%'))
			""")
	List<CategoryEntity> findCategoryDescription(String description);
}
