package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDto;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //como o service devolve um DTO para o controller,
    //a função retornará um DTO
    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {
        //busca no banco de dados
        Optional<Product> result = productRepository.findById(id);

        //pegamos o objeto de cima
        Product product = result.get();

        //lembrar que no DTO foi criado um construtor
        //específico para receber um Product
        ProductDto dto = new ProductDto(product);

        return dto;
    }

    @Transactional(readOnly = true)
    public Page<ProductDto> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);

        //pode fazer .map direto pois Page já é uma stream
        return products.map(x -> new ProductDto(x));
    }

    @Transactional
    public ProductDto insert (ProductDto productDto) {
        //criando um Product para receber os dados do DTO
        Product entity = new Product();


        //salvando os dados do DTO no Product
        entity.setName(productDto.getName());
        entity.setDescription(productDto.getDescription());
        entity.setPrice(productDto.getPrice());
        entity.setImgUrl(productDto.getImgUrl());

        //salvando entidade no banco de dados
        entity = productRepository.save(entity);

        //reconvertendo para DTO
        return new ProductDto(entity);
    }
}
