package com.game.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.game.store.model.Cart;
@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Long> {

}
