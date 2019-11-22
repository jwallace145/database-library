package com.finance.databaselibrary.repository;

import com.finance.databaselibrary.model.Forex;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ForexRepository extends MongoRepository<Forex, String> {

    List<Forex> findByFromCurrencySymbolAndToCurrencySymbol(String fromCurrencySymbol, String toCurrencySymbol);
    
}
