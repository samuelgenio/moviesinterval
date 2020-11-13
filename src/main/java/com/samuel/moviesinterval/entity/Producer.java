/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel.moviesinterval.entity;

import com.opencsv.bean.CsvBindByName;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Samuka
 */
@Entity(name = "Producer")
public class Producer implements Serializable {

    @CsvBindByName(required = false)
    private @Id
    @GeneratedValue
    Long id;

    @CsvBindByName
    private Integer year;

    @CsvBindByName
    private String producer;
    @CsvBindByName
    private boolean winner;

    Producer() {
    }

    Producer(Integer year, String producer, boolean winner) {
        this.year = year;
        this.producer = producer;
        this.winner = winner;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + this.id + ", producer='" + this.getProducer() + '\'' + '}';
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return the producers
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producers the producers to set
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * @return the winner
     */
    public boolean isWinner() {
        return winner;
    }

    /**
     * @param winner the winner to set
     */
    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
