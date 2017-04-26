package zw.co.tndangana.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.tndangana.business.domain.BasicSym;
import zw.co.tndangana.business.service.BasicSymService;

import java.util.List;

/**
 * Created by tndangana on 4/26/17.
 */
public class BasicSymListModel extends LoadableDetachableModel<List<BasicSym>> {

    @SpringBean
    private BasicSymService basicSymService;

    public BasicSymListModel(){
        Injector.get().inject(this);

    }

    @Override
    protected List<BasicSym> load() {
        return basicSymService.findAll();
    }
}
