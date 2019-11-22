package com.finance.databaselibrary.controller;

import com.finance.databaselibrary.model.Stock;
import com.finance.databaselibrary.repository.StocksRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StocksController {

    @Autowired
    private MongoTemplate mongoTemplate;

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

    @RequestMapping(value = "/{symbol}/sort", method = RequestMethod.GET)
    public List<Stock> getSortedStocks(@PathVariable("symbol") String symbol) {
        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(symbol));
        query.with(new Sort(Sort.Direction.ASC, "timestamp"));
        return this.mongoTemplate.find(query, Stock.class);
    }

    @RequestMapping(value = "/sort/{startDateStr}/{endDateStr}/{symbol}", method = RequestMethod.GET)
    public List<Stock> getSortedStocksOverTime(
            @PathVariable("startDateStr") String startDateStr,
            @PathVariable("endDateStr") String endDateStr,
            @PathVariable("symbol") String symbol) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date startDate = format.parse(startDateStr);
        Date endDate = format.parse(endDateStr);

        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(symbol));
        query.addCriteria(new Criteria().andOperator(Criteria.where("timestamp").gte(startDate), Criteria.where("timestamp").lte(endDate)));
        query.with(new Sort(Sort.Direction.ASC, "timestamp"));
        return this.mongoTemplate.find(query, Stock.class);
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
