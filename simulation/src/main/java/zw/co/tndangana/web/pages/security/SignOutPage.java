package zw.co.tndangana.web.pages.security;

import org.apache.wicket.markup.html.WebPage;

/**
 *
 * @author Morris baradza
 */
public class SignOutPage extends WebPage {

    public SignOutPage() {
        //TODO : End the current request cycle to prevent access of previous pages    
        getSession().invalidate();
        setResponsePage(LoginPage.class);
    }
}
