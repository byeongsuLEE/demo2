package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.*;


public class MemoryMemberRepository implements  MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence =0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;


    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }


    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()  // 자바 8의 람다 사용 = 루프를 돌린다,  store.values().stream()
                .filter(member -> member.getName().equals(name))  //루프를 돌려서 필터하는데 받은 name과 member.name과 똑같은거 필터
                .findAny();  // 조건에 부합하는 값 하나찾아지면 반환 , 없을경우 optional

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());  //stroe    .values = member
    }

    public void clearStore(){
        store.clear();
    }
}
