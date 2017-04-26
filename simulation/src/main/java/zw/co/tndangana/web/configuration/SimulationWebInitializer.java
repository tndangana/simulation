package zw.co.tndangana.web.configuration;

import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import zw.co.tndangana.business.configuration.PersistenceConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by tndangana on 4/23/17.
 */

@WebFilter(value = "/*", initParams = {
        @WebInitParam(name = "applicationClassName", value = "zw.co.tndangana.web.configuration.SimulationApplication"),
        @WebInitParam(name = "filterMappingUrlPattern", value = "/*")})
public class SimulationWebInitializer extends WicketFilter implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        servletContext.addListener(new ContextLoaderListener(ctx));
        ctx.register(PersistenceConfig.class);

    }

}
