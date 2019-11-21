package com.finance.databaselibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class DatabaseLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseLibraryApplication.class, args);
    }

}
