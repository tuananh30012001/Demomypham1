/*
 * (C) Copyright 2022. All Rights Reserved.
 *
 * @author DongTHD
 * @date Mar 10, 2022
*/
package vn.fs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.fs.entity.Cart;
import vn.fs.entity.CartDetail;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

	List<CartDetail> findByCart(Cart cart);

	@Query("select SUM(ct.price) from CartDetail ct join Cart c on ct.cart.cartId = c.cartId where c.cartId =:cartId")
	Double findByCartId(@Param("cartId") Long cartId);

	void deleteByCart(Cart cart);

}
