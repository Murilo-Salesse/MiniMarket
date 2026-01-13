package io.github.com.salesse.MiniMarket.infrastructure.gateway;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.com.salesse.MiniMarket.core.entities.Category;
import io.github.com.salesse.MiniMarket.core.exceptions.NotFoundException;
import io.github.com.salesse.MiniMarket.core.gateways.CategoryGateway;
import io.github.com.salesse.MiniMarket.infrastructure.mappers.CategoryEntityMapper;
import io.github.com.salesse.MiniMarket.infrastructure.persistence.CategoryEntity;
import io.github.com.salesse.MiniMarket.infrastructure.repositorys.CategoryRepository;

@Component
public class CategoryRepositoryGateway implements CategoryGateway {

	private final CategoryRepository categoryRepository;

	public CategoryRepositoryGateway(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category create(Category category) {
		return CategoryEntityMapper.toDomain(categoryRepository.save(CategoryEntityMapper.toEntity(category)));

	}

	@Override
	public Category findById(UUID id) {

		return CategoryEntityMapper.toDomain(
				categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("ID não encontrado")));
	}

	@Override
	public List<Category> findAll() {

		return categoryRepository.findAll().stream().map(CategoryEntityMapper::toDomain).collect(Collectors.toList());

	}

	@Override
	public List<Category> findByDesc(String desc) {

		return categoryRepository.findCategoryDescription(desc).stream().map(CategoryEntityMapper::toDomain)
				.collect(Collectors.toList());

	}

	@Override
	public Category update(UUID id, Category category) {
		CategoryEntity founded = categoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("ID não encontrado"));

		founded.setDescription(category.getDescription());

		categoryRepository.save(founded);

		return CategoryEntityMapper.toDomain(founded);
	}

	@Override
	public Void delete(UUID id) {
		CategoryEntity founded = categoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("ID não encontrado"));

		if (founded != null) {
			categoryRepository.delete(founded);
		}

		return null;
	}

}
