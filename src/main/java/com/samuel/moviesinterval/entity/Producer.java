/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel.moviesinterval.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Samuka
 */
@Entity(name = "Producer")
public class Producer implements Serializable {

    @JsonIgnore
    @CsvBindByName(required = false)
    private @Id
    @GeneratedValue
    Long id;

    @CsvBindByName
    private String producer;

    @CsvBindByName
    @Column(name = "interval_year")
    private Integer interval;
    
    @JsonIgnore
    @CsvBindByName
    private boolean winner;

    private Integer previousWin;
    
    private Integer followingWin;
    
    Producer() {
    }

    Producer(Integer interval, String producer, boolean winner) {
        this.interval = interval;
        this.producer = producer;
        this.winner = winner;
    }

    public Long getId() {
        return this.id;
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

    /**
     * @return the interval
     */
    public Integer getInterval() {
        return interval;
    }

    /**
     * @param interval the interval to set
     */
    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    /**
     * @return the previousWin
     */
    public Integer getPreviousWin() {
        return previousWin;
    }

    /**
     * @param previousWin the previousWin to set
     */
    public void setPreviousWin(Integer previousWin) {
        this.previousWin = previousWin;
    }

    /**
     * @return the followingWin
     */
    public Integer getFollowingWin() {
        return followingWin;
    }

    /**
     * @param followingWin the followingWin to set
     */
    public void setFollowingWin(Integer followingWin) {
        this.followingWin = followingWin;
    }
    
    public void setPreviousFollowingWin(Producer producer) {
    
        if (producer.getInterval() > this.interval) {
            setPreviousWin(this.interval);
            setFollowingWin(producer.getInterval());
        } else {
            setPreviousWin(producer.getInterval());
            setFollowingWin(this.interval);
        }
        
        setInterval(Math.abs(producer.getInterval() - getInterval()));
        
    }
}
