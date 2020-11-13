/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel.moviesinterval.entity;

import com.opencsv.bean.CsvBindByName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Samuka
 */
@Entity(name = "Movie")
public class Movie implements Serializable {

    @CsvBindByName(required = false)
    private @Id
    @GeneratedValue
    Long id;

    @CsvBindByName
    private Integer year;
    @CsvBindByName
    private String title;
    @CsvBindByName
    private String studios;
    @CsvBindByName
    private String producers;
    @CsvBindByName
    private boolean winner;

    Movie() {
    }

    public Movie(Integer year, String title, String studios, String producers, boolean winner) {
        this.year = year;
        this.title = title;
        this.studios = studios;
        this.producers = producers;
        this.winner = winner;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + this.id + ", title='" + this.getTitle() + '\'' + '}';
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the studios
     */
    public String getStudios() {
        return studios;
    }

    /**
     * @param studios the studios to set
     */
    public void setStudios(String studios) {
        this.studios = studios;
    }

    /**
     * @return the producers
     */
    public String getProducers() {
        return producers;
    }

    /**
     * @return the producers
     */
    public List<Producer> getListProducers() {

        List<Producer> listProducers = new ArrayList<>();

        String toExplode = this.getProducers().replace(" and ", ",");

        String[] exploded = toExplode.split(",");

        for (String producer : exploded) {
            listProducers.add(new Producer(this.year, producer, this.winner));
        }

        return listProducers;
    }

    /**
     * @param producers the producers to set
     */
    public void setProducers(String producers) {
        this.producers = producers;
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
