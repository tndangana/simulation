/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.tndangana.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.tndangana.business.domain.User;
import zw.co.tndangana.business.service.UserService;


/**
 *
 * @author tonderai ndangana
 * created 03/05/2016
 */
public class UserModel extends LoadableDetachableModel<User>{
    
    @SpringBean
    private UserService userService;
    private Long id;

    public UserModel(Long id) {
        this.id = id;
        Injector.get().inject(this);
    }
    
    

    @Override
    protected User load() {
           if (id==null){
         return new User();
      } else{
          return userService.find(id);
      } 
    }

    }
    

