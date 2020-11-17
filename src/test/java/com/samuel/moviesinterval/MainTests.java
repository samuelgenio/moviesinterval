package com.samuel.moviesinterval;

import com.samuel.moviesinterval.entity.Interval;
import com.samuel.moviesinterval.repo.MoviesRepository;
import com.samuel.moviesinterval.repo.ProducerRepository;
import com.samuel.moviesinterval.webservice.Server;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainTests {

    @Autowired
    MoviesRepository repoMovie;

    @Autowired
    ProducerRepository repoProducer;

    @Test
    void testLoadDatabase() {
        Assertions.assertEquals(206, (int) repoMovie.count(), "Data on CSV");
    }

    @Test
    void testConsumeWebService() {

        Server server = new Server(repoProducer);

        Interval interval  = server.producerinterval();
        
        Assertions.assertNotNull(interval.getMax(), "interval max not null");
        Assertions.assertNotNull(interval.getMin(), "interval min not null");

        Assertions.assertEquals(1, interval.getMax().size(), "Slower winner should have 35 years break");
        
        Assertions.assertEquals(2, interval.getMin().size() , "Fastest winner should have 1 year break");

    }

}
