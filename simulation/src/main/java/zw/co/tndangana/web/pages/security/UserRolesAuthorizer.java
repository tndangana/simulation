package zw.co.tndangana.web.pages.security;


import org.apache.wicket.Session;
import org.apache.wicket.authroles.authorization.strategies.role.IRoleCheckingStrategy;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import zw.co.tndangana.web.configuration.SimulationSession;


public class UserRolesAuthorizer implements IRoleCheckingStrategy {
    public boolean hasAnyRole(Roles roles) {
        SimulationSession authSession = (SimulationSession) Session.get();

        return authSession.hasAnyRole(roles);
    }
}
