package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Example example
 *
 * @author Pablo Carnero Liñán
 */
@javax.persistence.Entity
@Table(name = "EXAMPLE")
public class Example {

    @Getter
    @Setter
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

}
