/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel.moviesinterval.entity;

import java.util.List;

/**
 *
 * @author Samuka
 */
public class Interval {
    
    private List<Producer> min;
    
    private List<Producer> max;

    /**
     * @return the min
     */
    public List<Producer> getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(List<Producer> min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public List<Producer> getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(List<Producer> max) {
        this.max = max;
    }
    
}
