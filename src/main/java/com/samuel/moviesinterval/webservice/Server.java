/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel.moviesinterval.webservice;

import com.samuel.moviesinterval.entity.Interval;
import com.samuel.moviesinterval.entity.Producer;
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
    public Interval producerinterval() {

        List<Producer> producers = repoProducer.findByWinner(true);

        Interval interval = new Interval();
        
        int mostYearDif = Integer.MIN_VALUE;
        int minYearDif = Integer.MAX_VALUE;

        int i = 0;
        for (Producer producer : producers) {

            for (int j = i + 1; j < producers.size() - i; j++) {

                if (producer.getProducer().equals(producers.get(j).getProducer())) {
                    int yearDif = Math.abs(producer.getInterval() - producers.get(j).getInterval());

                    if (yearDif < minYearDif) {
                        minYearDif = yearDif;
                        List mins = new ArrayList<Producer>();
                        mins.add(producer);
                        interval.setMin(mins);
                    } else if (yearDif == minYearDif) {
                        interval.getMin().add(producer);
                    }

                    if (yearDif > mostYearDif) {
                        mostYearDif = yearDif;
                        List maxs = new ArrayList<Producer>();
                        maxs.add(producer);
                        interval.setMax(maxs);
                    } else if (yearDif == mostYearDif) {
                        interval.getMax().add(producer);
                    }
                    
                    producer.setPreviousFollowingWin(producers.get(j));

                    break;
                }
            }
            i++;
        }

        return interval;
    }

}
