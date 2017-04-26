package zw.co.tndangana.web.pages;

import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.tndangana.business.domain.BasicSym;
import zw.co.tndangana.business.domain.Symptom;
import zw.co.tndangana.business.domain.BasicSym;
import zw.co.tndangana.business.service.BasicSymService;
import zw.co.tndangana.web.configuration.SimulationPageParametersUtil;
import zw.co.tndangana.web.model.BasicSymModel;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 4/26/17.
 */
public class BasicSymEditPage extends TemplatePage {

    private BasicSymModel basicSymModel;

    @SpringBean
    private BasicSymService basicSymService;

    public BasicSymEditPage(PageParameters parameters) {
        super(parameters);
        createBasicSymModel(parameters);
        add(new FeedbackPanel("feedback"));

        Form<BasicSym> form = new Form<BasicSym>("form", new CompoundPropertyModel<BasicSym>(basicSymModel));;


        
        form.add(symptomCheckBox());
        form.add(new BookmarkablePageLink("back", BasicSymListPage.class));
        form.add(new Button("submit") {
            @Override
            public void onSubmit() {
                BasicSym basicSym = basicSymModel.getObject();
                basicSymService.save(basicSym);
                setResponsePage(new BasicSymListPage(parameters));
            }
        });
        add(form);

    }

    private CheckBoxMultipleChoice<Symptom> symptomCheckBox() {
        List<Symptom> symptomList = Arrays.asList(Symptom.values());
        ChoiceRenderer<Symptom> choiceRenderer = new ChoiceRenderer<Symptom>("symptomType");
        CheckBoxMultipleChoice<Symptom> symptomChoice = new CheckBoxMultipleChoice("symptoms",
                symptomList, choiceRenderer);

        return symptomChoice;
    }

    private void createBasicSymModel(PageParameters parameters) {
        Long id = SimulationPageParametersUtil.extractId(parameters);
        basicSymModel = new BasicSymModel(id);
    }
}
