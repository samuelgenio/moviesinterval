/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel.moviesinterval.utils;

import com.samuel.moviesinterval.repo.MoviesRepository;
import com.samuel.moviesinterval.repo.ProducerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Samuka
 */
@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MoviesRepository repoMovie, ProducerRepository repoProducer) {

        Storage.loadDatabase(repoMovie, repoProducer);

        return args -> log.info(repoMovie.count() + " movies from movielist");
    }
}
