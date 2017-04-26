
package zw.co.tndangana.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.tndangana.business.domain.User;
import zw.co.tndangana.business.service.UserService;


import java.util.List;

/**
 *
 * @author tonderai ndangana
 */
public class UserListModel extends LoadableDetachableModel<List<User>> {
    
    @SpringBean
    private UserService userService;

    public UserListModel(UserService userService) {
        this.userService = userService;
          Injector.get().inject(this);
    }

    public UserListModel() {
        this.userService = userService;
          Injector.get().inject(this);
        
    }

  @Override
    protected List<User> load() {
       return userService.findAll();
    }
    
}
