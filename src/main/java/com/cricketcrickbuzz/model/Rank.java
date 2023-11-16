package com.cricketcrickbuzz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
* id:"6326"
* rank:"1"
* name:"Kane Williamson"
* country:"New Zealand"
* rating:"883"
* points:"883"
* lastUpdatedOn:"2023-11-13"
* trend:"Flat"
* faceImageId:"351812"
* countryId:"13"
* avg:"54.89"
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Rank {
    private Integer id;
    private Integer rank;
    private String name;
    private String country;
    private String rating;
    private String points;
    private Date lastUpdatedOn;
    private String trend;
    private String faceImageId;
    private String countryId;
    private Float avg;
}


