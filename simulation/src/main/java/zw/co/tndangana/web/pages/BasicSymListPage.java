package zw.co.tndangana.web.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import zw.co.tndangana.business.domain.BasicSym;
import zw.co.tndangana.web.configuration.SimulationPageParametersUtil;
import zw.co.tndangana.web.model.BasicSymListModel;


/**
 * Created by tndangana on 4/26/17.
 */
public class BasicSymListPage extends TemplatePage {

    public BasicSymListPage(PageParameters parameters) {
        super(parameters);

        add(new BookmarkablePageLink("new", BasicSymEditPage.class));
        add(new PropertyListView<BasicSym>("basicSym", new BasicSymListModel()) {

            @Override
            protected void populateItem(ListItem<BasicSym> item) {


                item.add(createRolesLabel());

                PageParameters pageParameters = new PageParameters();
                pageParameters.add(SimulationPageParametersUtil.ID, item.getModelObject().getId());
                item.add(new BookmarkablePageLink("edit", BasicSymEditPage.class, pageParameters));
            }

        });
    }

    private Label createRolesLabel() {
        Label nameLabel = new Label("symptoms");
        return nameLabel;
    }
}
