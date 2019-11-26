package com.finance.databaselibrary.controller;

import com.finance.databaselibrary.model.StockDetails;
import com.finance.databaselibrary.repository.StockDetailsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stockDetails")
public class StockDetailsController {

    @Autowired
    private StockDetailsRepository repository;

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "{ \"status\" : \"healthy\" }";
    }

    @RequestMapping(value = "/{symbol}", method = RequestMethod.GET)
    public List<StockDetails> getStockDetails(@PathVariable("symbol") String symbol) {
        return this.repository.findBySymbol(symbol);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<StockDetails> getAllStockDetails() {
        return this.repository.findAll();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public StockDetails insertStockDetails(@Valid @RequestBody StockDetails stockDetails) {
        stockDetails.set_id(ObjectId.get());
        this.repository.save(stockDetails);
        return stockDetails;
    }

    @RequestMapping(value = "/drop", method = RequestMethod.DELETE)
    public void deleteStockDetails() {
        this.repository.deleteAll();
    }
}