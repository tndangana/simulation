package zw.co.tndangana.web.configuration;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authorization.strategies.role.RoleAuthorizationStrategy;
import org.apache.wicket.authroles.authorization.strategies.role.metadata.MetaDataRoleAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import zw.co.tndangana.business.domain.Role;
import zw.co.tndangana.web.pages.HomePage;
import zw.co.tndangana.web.pages.security.LoginPage;
import zw.co.tndangana.web.pages.security.UserRolesAuthorizer;

 import static zw.co.tndangana.web.pages.security.GeneralUtils.getRoles;

/**
 * Created by tndangana on 4/23/17.
 */

public class SimulationApplication extends AuthenticatedWebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        super.init();
        this.getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        mountPage("home", HomePage.class);

        getSecuritySettings().setAuthorizationStrategy(new RoleAuthorizationStrategy(new UserRolesAuthorizer()));
        try {
            MetaDataRoleAuthorizationStrategy.authorize(HomePage.class, getRoles(Role.values()));
        } catch (Exception ex) {

            System.out.println("Error occured while attempting to authorize the Home page");

        }
//        MetaDataRoleAuthorizationStrategy.authorize(AdministerDatabasePage.class, getRoles(SYSTEM_ADMINISTRATOR));
//        MetaDataRoleAuthorizationStrategy.authorize(AccountingPage.class, getRoles(SYSTEM_ADMINISTRATOR, ACCOUNTS_OFFICER, REGISTRAR));
        this.getMarkupSettings().setStripWicketTags(true); //IMPORTANT!
    }

    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        System.out.println("Getting the session");
        return SimulationSession.class;
    }

    protected Class<? extends WebPage> getSignInPageClass() {
        System.out.println("Getting the sign in page class");
        return LoginPage.class;
    }

}
