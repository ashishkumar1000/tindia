package com.tindia.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Film {
    private int id;
    private String title;
    private String description;
    private String director;


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }


}
