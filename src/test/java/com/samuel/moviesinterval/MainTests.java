package com.samuel.moviesinterval;

import com.samuel.moviesinterval.entity.Producer;
import com.samuel.moviesinterval.repo.MoviesRepository;
import com.samuel.moviesinterval.repo.ProducerRepository;
import com.samuel.moviesinterval.webservice.Server;
import java.util.List;
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

        List<Producer> listProducers = server.producerinterval();

        Assertions.assertNotNull(listProducers, "data result not null");

        Assertions.assertEquals(1, listProducers.get(0).getYear(), "Fastest winner should have 1 year break");

        Assertions.assertEquals(45, listProducers.get(1).getYear(), "Slower winner should have 35 years break");

    }

}
