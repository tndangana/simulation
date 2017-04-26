package zw.co.tndangana.business.service;

import java.util.List;

/**
 * Created by tndangana on 4/23/17.
 */
public interface GenericService <T>{


    public T save(T t);

    public List<T> findAll();

    public T find(Long id);

    public void delete(T t);
}
