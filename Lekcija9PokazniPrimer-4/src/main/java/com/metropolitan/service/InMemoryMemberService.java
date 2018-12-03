/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.service;

import com.metropolitan.domain.Member;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vlada
 */
@Service
class InMemoryMemberService implements MemberService {

    private final Map<Long, Member> members = new HashMap<>();

    @PostConstruct
    public void init() {
        Member m1 = new Member();
        m1.setName("Vladimir Milicevic");
        m1.setEmail("vlada@email.com");
        m1.setPhone("00-11-1234567890");

        Member m2 = new Member();
        m2.setName("Nikola Dimitrijevic");
        m2.setPhone("00-22-1234567890");
        m2.setEmail("nikola@email.com");

        Member m3 = new Member();
        m3.setName("Marko Rajevic");
        m3.setPhone("00-33-1234567890");
        m3.setEmail("marko@email.com");

        members.put(1L, m1);
        members.put(2L, m2);
        members.put(3L, m3);
    }

    @Override
    public java.util.Collection<Member> findAll() {
        return members.values();
    }

    @Override
    public Member find(long id) {
        return members.get(id);
    }
}
