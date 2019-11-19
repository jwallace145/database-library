package com.finance.databaselibrary.controller;

import com.finance.databaselibrary.model.Stock;
import com.finance.databaselibrary.repository.StocksRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StocksController {

    // this is a git intellij test

    @Autowired
    private StocksRepository repository;

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "{ \"status\" : \"healthy\" }";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Stock> getAllStocks() {
        return this.repository.findAll();
    }

    @RequestMapping(value = "/{symbol}", method = RequestMethod.GET)
    public List<Stock> getStocks(@PathVariable("symbol") String symbol) {
        return this.repository.findBySymbol(symbol);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Stock createStock(@Valid @RequestBody Stock stock) {
        stock.set_id(ObjectId.get());
        this.repository.save(stock);
        return stock;
    }

    @RequestMapping(value = "/drop/all", method = RequestMethod.DELETE)
    public void deleteStocks() {
        this.repository.deleteAll();
    }
}
