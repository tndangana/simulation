package zw.co.tndangana.web.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import zw.co.tndangana.web.panel.HeaderPanel;


/**
 *
 *ba
 * @author tndangana
 */
public abstract class TemplatePage extends WebPage {

    public TemplatePage(PageParameters parameters) {
        super(parameters);
        add(createHeaderPanel());

    }
    TemplatePage(){
        add(createHeaderPanel());
 }

    private HeaderPanel createHeaderPanel() {
        HeaderPanel headerPanel = new HeaderPanel("header");
        return headerPanel;
    }

}
