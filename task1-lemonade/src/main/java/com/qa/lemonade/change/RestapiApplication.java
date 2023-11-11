package com.qa.lemonade.change;

import com.qa.lemonade.change.model.LemonadeStandProducts;
import com.qa.lemonade.change.repository.LemonadeStandProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {

	private LemonadeStandProductsRepository lemonadeStandProductsRepository;

	@Autowired
	public void productRepository(LemonadeStandProductsRepository lemonadeStandProductsRepository) {
		this.lemonadeStandProductsRepository = lemonadeStandProductsRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		LemonadeStandProducts testLemonadeStandProducts = new LemonadeStandProducts();

		testLemonadeStandProducts.setBillValue("20");
		testLemonadeStandProducts.setPositionInLine("3");
		testLemonadeStandProducts.setRequestedLemonades("2");

		lemonadeStandProductsRepository.save(testLemonadeStandProducts);

	}
}
