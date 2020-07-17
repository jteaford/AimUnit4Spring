package org.aim.movie;

import java.util.Date;

@Entity
@Table(name = "actors")
public class Actor {
    
    @Column(name= "actor_id")
    private Integer id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    
}