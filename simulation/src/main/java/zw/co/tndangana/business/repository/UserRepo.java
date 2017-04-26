/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.tndangana.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.tndangana.business.domain.User;

/**
 *
 * @author tonderai ndangana created on 3/5/2016
 */
public interface UserRepo extends JpaRepository<User, Long> {

//    public User edit(User user);
//    public void logout();
}
