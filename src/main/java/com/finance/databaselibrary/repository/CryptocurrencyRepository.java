package com.finance.databaselibrary.repository;

import com.finance.databaselibrary.model.Cryptocurrency;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CryptocurrencyRepository extends MongoRepository<Cryptocurrency, String> {

    List<Cryptocurrency> findBySymbol(String symbol);

}
