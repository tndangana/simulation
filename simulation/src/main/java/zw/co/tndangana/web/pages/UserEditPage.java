package zw.co.tndangana.web.pages;

import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.tndangana.business.domain.Role;
import zw.co.tndangana.business.domain.User;
import zw.co.tndangana.business.service.UserService;
import zw.co.tndangana.web.configuration.SimulationPageParametersUtil;
import zw.co.tndangana.web.model.UserModel;


import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tonderai ndangana 03/05/2016
 */
public class UserEditPage extends TemplatePage {

   

    private UserModel userModel;

    @SpringBean
    private UserService userService;

    public UserEditPage(PageParameters parameters) {
        super(parameters);
        createUserModel(parameters);
        add(new FeedbackPanel("feedback"));

        Form<User> form = new Form<User>("form", new CompoundPropertyModel<User>(userModel));;

        form.add(new RequiredTextField("firstname"));
        form.add(new RequiredTextField("lastname"));
        form.add(new RequiredTextField("username"));
        form.add(new RequiredTextField("password"));
        form.add(new RequiredTextField("email"));
        form.add(new RequiredTextField("address"));
        form.add(new RequiredTextField("phonenumber"));
        form.add(new TextField("national_id"));
        form.add(new TextField("dob"));
//        form.add(myRelDropDownChoice());
        form.add(roleCheckBox());
        form.add(new BookmarkablePageLink("back", UserListPage.class));
        form.add(new org.apache.wicket.markup.html.form.Button("submit") {
            @Override
            public void onSubmit() {
                User user = userModel.getObject();
                userService.save(user);
                setResponsePage(new UserListPage(parameters));
            }
        });
        add(form);

    }

    private CheckBoxMultipleChoice<Role> roleCheckBox() {
        List<Role> roleList = Arrays.asList(Role.values());
        ChoiceRenderer<Role> choiceRenderer = new ChoiceRenderer<Role>("roleName");
        CheckBoxMultipleChoice<Role> roleChoice = new CheckBoxMultipleChoice("roles",
                roleList, choiceRenderer);

        return roleChoice;
    }

    private void createUserModel(PageParameters parameters) {
        Long id = SimulationPageParametersUtil.extractId(parameters);
        userModel = new UserModel(id);
    }

}
