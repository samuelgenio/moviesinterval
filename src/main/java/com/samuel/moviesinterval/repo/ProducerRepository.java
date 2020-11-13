/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel.moviesinterval.repo;

import com.samuel.moviesinterval.entity.Producer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Samuka
 */
public interface ProducerRepository extends JpaRepository<Producer, Long> {

    @Query(value = "SELECT * FROM Producer U WHERE winner = ?1 AND (SELECT MAX(year) FROM Producer UU WHERE UU.winner = U.winner and U.year <> UU.year and UU.producer like CONCAT('%', U.producer, '%')) <> U.year ", nativeQuery = true)
    List<Producer> findByWinner(boolean isWinner);

}