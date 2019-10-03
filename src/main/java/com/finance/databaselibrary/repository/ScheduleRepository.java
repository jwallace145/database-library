package com.finance.databaselibrary.repository;

import com.finance.databaselibrary.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScheduleRepository extends MongoRepository<Schedule, String> {
    List<Schedule> findBySymbol(String symbol);
}
