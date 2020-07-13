package com.leandroprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandroprojeto.entites.Product;

//UserRepository vai ser uma interfcace pq o Repository é uma interface também
//tipo da entidade e o tipo do ID.
//nao criamos uma implementação pq o JpaRepository ja tem uma implementação
//Não marcamos @Repository pq o JpaRepository ja é marcado como @Repository
public interface ProductRepository extends JpaRepository<Product, Long>{



}
