package zw.co.tndangana.web.panel;

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.value.ValueMap;
import zw.co.tndangana.web.configuration.SimulationSession;


/**
 *
 * @author tonderai ndangana created on 04/05/2016
 */
public class LoginPanel extends Panel {

    public LoginPanel(String id) {
        super(id);
        add(new SignInForm("signInForm"));
        add(new FeedbackPanel("errorMessage"));

    }

    public final class SignInForm extends StatelessForm<Void> {

        private static final String USERNAME = "username";
        private static final String PASSWORD = "password";
        private final ValueMap properties = new ValueMap();

        public SignInForm(final String id) {
            super(id);

            add(new TextField<String>(USERNAME, new PropertyModel<String>(properties, USERNAME)).setRequired(true));
            add(new PasswordTextField(PASSWORD, new PropertyModel<String>(properties, PASSWORD)).setRequired(true));

        }

        @Override
        public final void onSubmit() {

            SimulationSession session = getMySession();
            if (session.signIn(getUsername(), getPassword())) {
                continueToOriginalDestination();
                setResponsePage(getApplication().getHomePage());
            } else {

                String errmsg = getString("loginError", null, "Unable to sign you in");
                error(errmsg);
            }
        }

        private String getPassword() {
            return properties.getString(PASSWORD);
        }

        private String getUsername() {
            return properties.getString(USERNAME);
        }

        private SimulationSession getMySession() {
            return (SimulationSession) getSession();
        }
    }

}
