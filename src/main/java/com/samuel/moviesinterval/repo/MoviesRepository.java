/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel.moviesinterval.repo;

import com.samuel.moviesinterval.entity.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Samuka
 */
public interface MoviesRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByWinner(boolean isWinner);
    
}