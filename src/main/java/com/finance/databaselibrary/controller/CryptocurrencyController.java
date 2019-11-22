package com.finance.databaselibrary.controller;

import com.finance.databaselibrary.model.Cryptocurrency;
import com.finance.databaselibrary.repository.CryptocurrencyRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cryptos")
public class CryptocurrencyController {

    @Autowired
    private CryptocurrencyRepository repository;

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "{ \"status\": \"healthy\" }";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Cryptocurrency> getAllCryptos() {
        return this.repository.findAll();
    }

    @RequestMapping(value = "/{symbol}", method = RequestMethod.GET)
    public List<Cryptocurrency> getCryptos(@PathVariable("symbol") String symbol) {
        return this.repository.findBySymbol(symbol);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Cryptocurrency createCrypto(@Valid @RequestBody Cryptocurrency cryptocurrency) {
        cryptocurrency.set_id(ObjectId.get());
        this.repository.save(cryptocurrency);
        return cryptocurrency;
    }

    @RequestMapping(value = "/drop", method = RequestMethod.DELETE)
    public void dropCryptos() {
        this.repository.deleteAll();
    }
}
