package zw.co.tndangana.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.tndangana.business.domain.BasicSym;
import zw.co.tndangana.business.domain.BasicSym;
import zw.co.tndangana.business.service.BasicSymService;

/**
 * Created by tndangana on 4/26/17.
 */
public class BasicSymModel extends LoadableDetachableModel<BasicSym> {

    @SpringBean
    private BasicSymService basicSymService;
    private Long id;

    public BasicSymModel(Long id) {
        this.id = id;
        Injector.get().inject(this);
    }



    @Override
    protected BasicSym load() {
        if (id==null){
            return new BasicSym();
        } else{
            return basicSymService.find(id);
        }
    }
}
