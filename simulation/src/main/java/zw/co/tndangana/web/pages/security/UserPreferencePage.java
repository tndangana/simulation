package zw.co.tndangana.web.pages.security;

import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.tndangana.business.domain.User;
import zw.co.tndangana.business.service.UserService;
import zw.co.tndangana.web.configuration.SimulationPageParametersUtil;
import zw.co.tndangana.web.model.UserModel;
import zw.co.tndangana.web.pages.HomePage;
import zw.co.tndangana.web.pages.TemplatePage;


/**
 *
 * @author hitrac
 */
public class UserPreferencePage extends TemplatePage {

    private UserModel userModel;
    @SpringBean
    private UserService userService;

    public UserPreferencePage(PageParameters parameters) {
        super(parameters);
        createUserModel(parameters);
        setDefaultModel(compoundPropertyModel());
        add(userForm());
    }

    private CompoundPropertyModel<User> compoundPropertyModel() {
        CompoundPropertyModel<User> compoundPropertyModel = new CompoundPropertyModel<User>(userModel);
        return compoundPropertyModel;
    }

    private Form<User> userForm() {
        Form<User> form = new StatelessForm<User>("form", compoundPropertyModel());
        form.add(new RequiredTextField("firstname"));
        form.add(new RequiredTextField("lastname"));
        form.add(new RequiredTextField("username"));

        form.add(new RequiredTextField("email"));
        form.add(new RequiredTextField("address"));
        form.add(new RequiredTextField("phonenumber"));
        form.add(new TextField("national_id"));
        form.add(new TextField("dob"));
        form.add(createSubmitButton());

        return form;
    }

    private Button createSubmitButton() {
        Button submitButton = new Button("submit") {
            @Override
            public void onSubmit() {
                User user = userModel.getObject();
                userService.save(user);
                setResponsePage(HomePage.class);
            }
        };
        return submitButton;
    }

    private void createUserModel(PageParameters parameters) {
        Long id = SimulationPageParametersUtil.extractId(parameters);
        userModel = new UserModel(id);
    }

}
