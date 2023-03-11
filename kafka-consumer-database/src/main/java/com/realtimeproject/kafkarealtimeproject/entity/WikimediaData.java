package com.realtimeproject.kafkarealtimeproject.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    //wikimedia has large amount of data so to store that data we use lob annotation
    @Lob
    private String data;
}
