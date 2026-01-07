package io.github.com.salesse.MiniMarket.infrastructure.repositorys;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.com.salesse.MiniMarket.infrastructure.persistence.UserEntity;

@Repository
public interface UserRespository extends JpaRepository<UserEntity, UUID> {

	@Query("""
			    select u
			    from UserEntity u
			    where u.id = :id
			      and u.active = true
			""")
	Optional<UserEntity> findActiveById(UUID id);

	@Query("""
			    select u
			    from UserEntity u
			    where u.active = true
			      and upper(trim(u.name)) like upper(concat('%', ?1, '%'))
			""")
	List<UserEntity> findUserName(String name);

	@Query("""
			    select u
			    from UserEntity u
			    where u.active = true
			      and upper(trim(u.email)) like upper(concat('%', ?1, '%'))
			""")
	List<UserEntity> findUserEmail(String email);
}
