package com.finance.databaselibrary.controller;

import com.finance.databaselibrary.model.Forex;
import com.finance.databaselibrary.repository.ForexRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/forex")
public class ForexController {

    @Autowired
    private ForexRepository forexRepository;

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "{ \"status\" : \"healthy\" }";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Forex> getAllForex() {
        return this.forexRepository.findAll();
    }

    @RequestMapping(value = "/{fromCurrencySymbol}/{toCurrencySymbol}", method = RequestMethod.GET)
    public List<Forex> getForex(@PathVariable("fromCurrencySymbol") String fromCurrencySymbol,
                                @PathVariable("toCurrencySymbol") String toCurrencySymbol) {
        return this.forexRepository.findByFromCurrencySymbolAndToCurrencySymbol(fromCurrencySymbol, toCurrencySymbol);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Forex createForex(@Valid @RequestBody Forex forex) {
        forex.set_id(ObjectId.get());
        this.forexRepository.save(forex);
        return forex;
    }
}
