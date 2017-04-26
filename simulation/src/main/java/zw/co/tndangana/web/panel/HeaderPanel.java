package zw.co.tndangana.web.panel;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import zw.co.tndangana.business.domain.Role;
import zw.co.tndangana.web.configuration.SimulationPageParametersUtil;
import zw.co.tndangana.web.configuration.SimulationSession;
import zw.co.tndangana.web.pages.HomePage;
import zw.co.tndangana.web.pages.security.GeneralUtils;
import zw.co.tndangana.web.pages.security.SignOutPage;
import zw.co.tndangana.web.pages.UserListPage;
import zw.co.tndangana.web.pages.security.UserPreferencePage;


/**
 *
 *@author tndangana
 *
 */
public class HeaderPanel extends Panel {

    public HeaderPanel(String id) {
        super(id);
        SimulationSession session = getMySession();

        String userName = session.getUser().getUsername().toUpperCase() + " (" + session.getUser().getRoles() + " )";
        add(new Label("loggedInUserNameLabel", userName));
        add(createUserPagePreferenceLink());


        add(new BookmarkablePageLink("users", UserListPage.class) {

            @Override
            protected void onConfigure() {
                Boolean enabled = Boolean.FALSE;
                try {
                    enabled = SimulationSession.get().hasAnyRole(new Roles(GeneralUtils.getRoles(Role.ADMINISTRATOR)));
                } catch (Exception e) {
                    e.getMessage();
                }
                setVisible(enabled); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isEnabled() {
                try {
                    Boolean enabled = SimulationSession.get().hasAnyRole(new Roles(GeneralUtils.getRoles(Role.ADMINISTRATOR)));
                    return enabled;
                } catch (Exception e) {
                    e.getMessage();
                }
                return Boolean.FALSE;
            }
        }
        );

        add(new BookmarkablePageLink("homepage", HomePage.class) {
            @Override
            public boolean isEnabled() {
                try {
                    Boolean enabled = SimulationSession.get().hasAnyRole(new Roles(GeneralUtils.getRoles(Role.ADMINISTRATOR, Role.GENEREL_USER)));
                    return enabled;
                } catch (Exception e) {
                    e.getMessage();
                }
                return Boolean.FALSE;
            }
        }
        );

        add(new BookmarkablePageLink("logout", SignOutPage.class) {
            @Override
            public boolean isEnabled() {
                try {
                    Boolean enabled = SimulationSession.get().hasAnyRole(new Roles(GeneralUtils.getRoles(Role.ADMINISTRATOR, Role.GENEREL_USER)));
                    return enabled;
                } catch (Exception e) {
                    e.getMessage();
                }
                return Boolean.FALSE;
            }
        });
     }

    private SimulationSession getMySession() {
        return (SimulationSession) getSession();
    }

    private Link<Void> createUserPagePreferenceLink() {
        PageParameters pageParameters = new PageParameters();
        Link<Void> editLink = null;
        if (SimulationSession.getLoggedUser() != null) {
            pageParameters.add(SimulationPageParametersUtil.ID, SimulationSession.getLoggedUser().getId());
            editLink = new BookmarkablePageLink<Void>("userPreferencePage", UserPreferencePage.class, pageParameters);
        } else {
            editLink = new BookmarkablePageLink<Void>("userPreferencePage", HomePage.class);
        }

        return editLink;
    }

}
