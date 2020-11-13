/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel.moviesinterval.utils;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.samuel.moviesinterval.entity.Movie;
import com.samuel.moviesinterval.repo.MoviesRepository;
import com.samuel.moviesinterval.repo.ProducerRepository;
import java.io.FileReader;
import java.util.Iterator;

/**
 *
 * @author Samuka
 */
public class Storage {

    public static void loadDatabase(MoviesRepository repoMovie, ProducerRepository repoProducer) {

        try {

            CSVReader csvReader = new CSVReaderBuilder(new FileReader(System.getProperty("user.dir") + "\\movielist.csv"))
                    .withSkipLines(1)
                    .withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();

            for (Iterator<String[]> iterator = csvReader.iterator(); iterator.hasNext();) {

                String[] value = iterator.next();
                Movie mov = new Movie(
                        Integer.parseInt(value[0]),
                        value[1],
                        value[2],
                        value[3],
                        value.length > 4 && !value[4].isEmpty()
                );

                repoMovie.save(mov);
                repoProducer.saveAll(mov.getListProducers());

            }

        } catch (Exception e) {
            System.err.println("Falha ao carregar arquivo csv " + e.getMessage());
            System.exit(0);
        }

    }

}
