package com.tindia.demo.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "destination")
public class Destination {
    @Id
    @GeneratedValue
    private int id;

    private String dest_name;
    private String image_url;
}
