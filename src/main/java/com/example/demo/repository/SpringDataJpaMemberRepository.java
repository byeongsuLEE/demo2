package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long> ,MemberRepository{
    //인터페이스가 인터페이스를 받을때 extends 사용
    //인터페이스는 다중상속이되니 2개 상속가능능

    //jpql select m from member m where m.name=?

    @Override
    Optional<Member> findByName(String name);
}
