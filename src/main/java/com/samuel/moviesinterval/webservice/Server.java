/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel.moviesinterval.webservice;

import com.samuel.moviesinterval.entity.Producer;
import com.samuel.moviesinterval.repo.MoviesRepository;
import com.samuel.moviesinterval.repo.ProducerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Samuka
 */
@RestController
public class Server {

    private final ProducerRepository repoProducer;

    public Server(ProducerRepository repoProducer) {
        this.repoProducer = repoProducer;
    }

    /**
     * Get a list with up to two results, where the first is the producer who
     * won two awards more faster
     *
     * @return List<Producer>
     */
    @GetMapping("/producers")
    public List<Producer> producerinterval() {

        List<Producer> producers = repoProducer.findByWinner(true);

        Producer mostIntervalProducer = null;
        Producer minIntervalProducer = null;

        int mostYearDif = Integer.MIN_VALUE;
        int minYearDif = Integer.MAX_VALUE;

        int i = 0;
        for (Producer producer : producers) {

            for (int j = i + 1; j < producers.size() - i; j++) {

                if (producer.getProducer().equals(producers.get(j).getProducer())) {
                    int yearDif = Math.abs(producer.getYear() - producers.get(j).getYear());

                    if (yearDif < mostYearDif) {
                        minYearDif = yearDif;
                        minIntervalProducer = producer;
                    }

                    if (yearDif > mostYearDif) {
                        mostYearDif = yearDif;
                        mostIntervalProducer = producer;
                    }

                    break;
                }
            }
            i++;
        }

        producers = new ArrayList<>();

        if (minIntervalProducer != null) {
            minIntervalProducer.setYear(minYearDif);
            producers.add(minIntervalProducer);
        }

        if (mostIntervalProducer != null) {
            mostIntervalProducer.setYear(mostYearDif);
            producers.add(mostIntervalProducer);
        }
        
        return producers;
    }

}
