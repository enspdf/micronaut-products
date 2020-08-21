package me.enspdf.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import io.micronaut.transaction.annotation.ReadOnly;
import me.enspdf.domain.Product;
import me.enspdf.domain.dto.CreateProductDto;
import me.enspdf.domain.dto.UpdateProductDto;
import me.enspdf.repository.ProductRepository;

@Singleton
public class ProductRepositoryImpl implements ProductRepository {
    // @PersistenceContext
    // private EntityManager entityManager;

    private final EntityManager entityManager;

    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public Optional<Product> findById(@NotNull Long id) {
        return Optional.ofNullable(entityManager.find(Product.class, id));
    }

    @Override
    @Transactional
    public Product save(@NotNull CreateProductDto createProductDto) {
        Product product = new Product();
        product.setName(createProductDto.getName());
        product.setDescription(createProductDto.getDescription());
        product.setPrice(createProductDto.getPrice());

        entityManager.persist(product);

        return product;
    }

    @Override
    @Transactional
    public void deleteById(@NotNull Long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    @Override
    @ReadOnly
    public List<Product> getAll() {
        String sqlQuery = " SELECT product FROM Product AS product ";

        Query query = entityManager.createQuery(sqlQuery);

        return query.getResultList();
    }

    @Override
    @Transactional
    public int update(@NotNull UpdateProductDto updateProductDto) {
        StringBuilder strQuery = new StringBuilder(" UPDATE ");
        strQuery.append(" Product g ");
        strQuery.append(" SET ");
        strQuery.append(" name = :name, ");
        strQuery.append(" description = :description, ");
        strQuery.append(" price = :price ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :productId ");

        Query query = entityManager.createQuery(strQuery.toString()).setParameter("name", updateProductDto.getName())
                .setParameter("description", updateProductDto.getDescription())
                .setParameter("price", updateProductDto.getPrice()).setParameter("productId", updateProductDto.getId());

        return query.executeUpdate();
    }
}