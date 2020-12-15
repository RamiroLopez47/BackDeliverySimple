package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<E extends BaseEntity, R extends JpaRepository<E, Long>> implements IBaseService<E> {
	
	@Autowired
	protected R repository;

	@Override
	public E findById(long id) throws Exception {
		try {
			// se usa para atrapar un null
			Optional<E> varOptional = repository.findById(id);
			E entity = varOptional.get();
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}

	@Override
	public E save(E entityForm) throws Exception {
		try {
			entityForm.setStatus(true);
			entityForm = repository.save(entityForm);
			return entityForm;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public E update(long id, E entityForm) throws Exception {
		try {
			Optional<E> entityOptional = repository.findById(id);
			entityForm.setId(entityOptional.get().getId());
			entityForm = repository.save(entityForm);
			return entityForm;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public int countPages(int size) throws Exception {
		try {
			Pageable pageable = PageRequest.of(0, size);
			return repository.findAll(pageable).getTotalPages();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<E> findAll(int page, int size) throws Exception {
		
		try {
			Pageable pageable = PageRequest.of(page, size);
			return repository.findAll(pageable).getContent();			

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	public boolean delete(long id) throws Exception{
		try {
//			Optional<E> entityOptional = repository.findById(id);
			Optional<E> entityOptional = repository.findById(id).filter(data -> data.getStatus());
			E entity = entityOptional.get();
			entity.setStatus(false);
			repository.save(entity);
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

}
