package io.github.com.salesse.MiniMarket.infrastructure.repositorys;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.com.salesse.MiniMarket.infrastructure.persistence.StoresEntity;

@Repository
public interface StoresRepository extends JpaRepository<StoresEntity, UUID> {

	@Query("""
			    select s
			    from StoresEntity s
			    where s.active = true
			      and upper(trim(s.name)) like upper(concat('%', ?1, '%'))
			""")
	List<StoresEntity> findStoresName(String name);

	@Query("""
			    select s
			    from StoresEntity s
			    where s.active = true
			""")
	List<StoresEntity> findAllActive();

	boolean existsByCnpjAndActiveTrue(String cnpj);

	@Query("""
			    select s
			    from StoresEntity s
			    where s.id = :id
			      and s.active = true
			""")
	Optional<StoresEntity> findActiveById(UUID id);
}
