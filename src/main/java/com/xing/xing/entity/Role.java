package com.xing.xing.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "alias")
    private String alias;

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }
}
