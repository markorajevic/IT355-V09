/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.service;

import com.metropolitan.domain.Member;
import java.util.Collection;

/**
 *
 * @author Vlada
 */
public interface MemberService {

    Collection<Member> findAll();

    Member find(long id);
}
