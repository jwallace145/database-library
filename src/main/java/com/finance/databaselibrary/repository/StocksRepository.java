package com.finance.databaselibrary.repository;

import com.finance.databaselibrary.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StocksRepository extends MongoRepository<Stock, String> {

    List<Stock> findBySymbol(String symbol);

}
