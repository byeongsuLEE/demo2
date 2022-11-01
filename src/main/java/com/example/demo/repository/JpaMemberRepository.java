package com.example.demo.repository;

import com.example.demo.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements  MemberRepository{

    //jpa는 EntityManager로 모든 동작을 한다.
    //spring boot가 data-jpa를 라이브러리를 받을 때  자동적으로 EntityManger을 만들어줘서 injection만 해주면됩니다.

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {

        //이렇게하면 jpa가 insertquery만들고 id값도 자동적으로 만들어준다.

        em.persist(member);
        return member;

    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);   //em.find(검색할타입,식별자pk값) 하면 조회해준다.
        return Optional.ofNullable(member);

    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m  where m.name= :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();

    }

    @Override
    public List<Member> findAll() {
        //jpql 쿼리 사용하여 전체검색  pk값이 없으니 이런 쿼리 사용한다.
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }


}
