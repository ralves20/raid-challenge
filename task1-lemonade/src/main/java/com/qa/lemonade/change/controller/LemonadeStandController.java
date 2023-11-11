package com.qa.lemonade.change.controller;

import com.qa.lemonade.change.model.LemonadeStandProducts;
import com.qa.lemonade.change.service.LemonadeStandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/products/")
@Api(value = "ProductsControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class LemonadeStandController {

    private LemonadeStandService lemonadeStandService;

    private Logger LOG = LoggerFactory.getLogger(LemonadeStandController.class);

    @Autowired
    public void setProductsService(LemonadeStandService lemonadeStandService) {
        this.lemonadeStandService = lemonadeStandService;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Gets the product with specific id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = LemonadeStandProducts.class)})
    public ResponseEntity<LemonadeStandProducts> getProduct(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(lemonadeStandService.getProduct(id));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public LemonadeStandProducts saveProduct(@RequestBody LemonadeStandProducts lemonadeStandProductsToSave) {
        return lemonadeStandService.saveProduct(lemonadeStandProductsToSave);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public LemonadeStandProducts updateProduct(@RequestBody LemonadeStandProducts lemonadeStandProductsToUpdate, @PathVariable(name = "id") String id) throws Exception {
        return lemonadeStandService.updateProduct(lemonadeStandProductsToUpdate, id);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(name = "id") String id) {
        lemonadeStandService.deleteProduct(id);
    }
}
