package com.corycosby.funzone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Indicates JPA Entity
@Table(name = "role") //sets table name to role
public class Role {
	
    // Id of the Role entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generates Id for user to be store in database
    private Long id;
	
    // Name of the Role entity
    private String name;
	
    // Default constructor
    public Role() {
		
    }
	
    // Constructor 
    public Role(String name) {
        super();
        this.name = name;
    }
	
    // Getter for id 
    public Long getId() {
        return id;
    }
	
    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }
	
    // Getter for name
    public String getName() {
        return name;
    }
	
    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
}

