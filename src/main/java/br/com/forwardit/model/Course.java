/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.model;

import java.util.List;

/**
 *
 * @author Maurilio
 */
public class Course {
    private Integer id;
    private String title;
    private String description;
    private Schedule schedule;
    private Person minister;
    private List<Person> supports;
    private AttendantGroup enrolled;
    private int numberOfEvaluations;
    private Grade successGrade;
    private Grade failGrade;
    private Grade midTermGrade;
    private List<Event> events;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Person getMinister() {
        return minister;
    }

    public void setMinister(Person minister) {
        this.minister = minister;
    }

    public List<Person> getSupports() {
        return supports;
    }

    public void setSupports(List<Person> supports) {
        this.supports = supports;
    }

    public AttendantGroup getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(AttendantGroup enrolled) {
        this.enrolled = enrolled;
    }

    public int getNumberOfEvaluations() {
        return numberOfEvaluations;
    }

    public void setNumberOfEvaluations(int numberOfEvaluations) {
        this.numberOfEvaluations = numberOfEvaluations;
    }

    public Grade getSuccessGrade() {
        return successGrade;
    }

    public void setSuccessGrade(Grade successGrade) {
        this.successGrade = successGrade;
    }

    public Grade getFailGrade() {
        return failGrade;
    }

    public void setFailGrade(Grade failGrade) {
        this.failGrade = failGrade;
    }

    public Grade getMidTermGrade() {
        return midTermGrade;
    }

    public void setMidTermGrade(Grade midTermGrade) {
        this.midTermGrade = midTermGrade;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
    
}
