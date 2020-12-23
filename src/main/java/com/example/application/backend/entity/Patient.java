package com.example.application.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private double bScore;

    private double bedNum;


    private double timeInPos;

    public Patient(){

    }

    public Patient(String name, double bScore, double bedNum){
        this.name = name;
        this.bScore = bScore;
        this.bedNum = bedNum;

        timeInPos = 0;
    }

    /*public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getbScore() {
        return bScore;
    }

    public void setbScore(double bScore) {
        this.bScore = bScore;
    }

    public double getBedNum() {
        return bedNum;
    }

    public void setBedNum(double bedNum) {
        this.bedNum = bedNum;
    }

    public double getTimeInPos() {
        return timeInPos;
    }

    public void setTimeInPos(double timeInPos) {
        this.timeInPos = timeInPos;
    }
}