/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.facult.models;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author mauri
 */
public class Person {
    private Integer id;
    private String name;
    private Calendar registerDate;
    private Calendar birthday;
    private Address address;
    private List<Person> guardians;
    private String cpf;
    private List<Contact> contacts;
    private String notes;
    private List<Messages> messages;
    private PersonType type;
    private List<Evaluation> evaluations;
    
}
