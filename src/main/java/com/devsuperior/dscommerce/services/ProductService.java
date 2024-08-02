package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDto;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
}
