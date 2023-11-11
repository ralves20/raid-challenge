package com.qa.lemonade.change.repository;

import com.qa.lemonade.change.model.LemonadeStandProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LemonadeStandProductsRepository extends JpaRepository<LemonadeStandProducts, String> {
}
