package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity :  jpa가 관리하는 entity가 되는거다.
@Entity
public class Member {

    //pk를 맵핑해저야됨 ,  DB에 데이터를 넣을때 DB가 자동으로 값을 생성해주는것을 IDENTITY라고한다.
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
