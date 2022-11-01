package com.example.demo.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach    //test가 끝날때 했던 작업들 삭제
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //System.out.printf("result = " + (result==member));
        //Assertions.assertEquals(member, result);
        //Assertions.assertThat
        assertThat(member).isEqualTo(result);



    }

    @Test
    public void findByName(){
        Member member1 = new Member();  //shift + f6 rename
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();  //shift + f6 rename
        member2.setName("spring1");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }


    @Test
    public void findAll(){
        Member member1 = new Member();  //shift + f6 rename
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();  //shift + f6 rename
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

}
