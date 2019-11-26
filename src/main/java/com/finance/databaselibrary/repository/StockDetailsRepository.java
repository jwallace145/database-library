package com.finance.databaselibrary.repository;

import com.finance.databaselibrary.model.StockDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockDetailsRepository extends MongoRepository<StockDetails, String> {

    List<StockDetails> findBySymbol(String symbol);
}