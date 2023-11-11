package com.qa.lemonade.change.service;

import com.qa.lemonade.change.model.LemonadeStandProducts;
import com.qa.lemonade.change.repository.LemonadeStandProductsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LemonadeStandService {

    private Logger LOG = LoggerFactory.getLogger(LemonadeStandService.class);

    private LemonadeStandProductsRepository lemonadeStandProductsRepository;

    @Autowired
    public void setProductRepository(LemonadeStandProductsRepository lemonadeStandProductsRepository) {
        this.lemonadeStandProductsRepository = lemonadeStandProductsRepository;
    }

    public LemonadeStandProducts getProduct(String id) {
        return lemonadeStandProductsRepository.findById(id).orElseThrow();
    }

    public LemonadeStandProducts saveProduct(LemonadeStandProducts lemonadeStandProducts) {
        LemonadeStandProducts lemonadeStandProductsToSave;
        try {
            LOG.info("Saving product...");
            lemonadeStandProductsToSave = lemonadeStandProductsRepository.save(lemonadeStandProducts);
            return lemonadeStandProductsToSave;
        } catch (Exception e) {
            LOG.error("An error occurred during product saving:" + e.getMessage());
        }
        return new LemonadeStandProducts();
    }

    public LemonadeStandProducts updateProduct(LemonadeStandProducts lemonadeStandProductsToUpdate, String id) throws Exception {
        Optional<LemonadeStandProducts> foundLemonadeStandProducts = lemonadeStandProductsRepository.findById(id);
        foundLemonadeStandProducts.ifPresent(
                lemonadeStandProducts -> {
                    lemonadeStandProducts.setBillValue(lemonadeStandProductsToUpdate.getBillValue());
                    lemonadeStandProducts.setPositionInLine(lemonadeStandProductsToUpdate.getPositionInLine());
                    lemonadeStandProducts.setRequestedLemonades(lemonadeStandProductsToUpdate.getPositionInLine());
                }
        );
        foundLemonadeStandProducts.orElseThrow(() -> new Exception("An error ocurred while updating"));
        return lemonadeStandProductsToUpdate;
    }

    public void deleteProduct(String id) {
        try {
            lemonadeStandProductsRepository.deleteById(id);
        } catch (Exception e) {
            LOG.error("An error occurred during deleting of product:" + e.getMessage());
        }
    }
}
