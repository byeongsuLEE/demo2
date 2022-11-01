package com.example.demo.service;

import com.example.demo.aop.TimeTraceAop;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    //스프링 데이터 jpa
    private final MemberRepository memberRepository;
    //springDataJpaMemberRepository에서 만든 구현체를 여기에 등록
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
/*    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();


    }*/
/*
    //jpa
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    /*   private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);

    }
}
/*
    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository(); 기존 메모리에 저장
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);

    }
}
*/
