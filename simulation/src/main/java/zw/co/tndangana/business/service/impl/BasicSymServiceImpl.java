package zw.co.tndangana.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.tndangana.business.domain.BasicSym;
import zw.co.tndangana.business.repository.BasicSymRepo;
import zw.co.tndangana.business.service.BasicSymService;

import java.util.List;

/**
 * Created by tndangana on 4/26/17.
 */
@Service
public class BasicSymServiceImpl implements BasicSymService{
    @Autowired
    private BasicSymRepo basicSymRepo;

    @Override
    public BasicSym save(BasicSym basicSym) {
        return basicSymRepo.save(basicSym);
    }

    @Override
    public List<BasicSym> findAll() {
        return basicSymRepo.findAll();
    }

    @Override
    public BasicSym find(Long id) {
        return basicSymRepo.findOne(id);
    }

    @Override
    public void delete(BasicSym basicSym) {
       basicSymRepo.delete(basicSym);
    }
}
