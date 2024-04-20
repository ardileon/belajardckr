package com.cb.dckpst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.dckpst.model.Menumkn;
import com.cb.dckpst.repository.MenuMknRepository;

@Service
public class MenuMknServiceImpl implements MenuMknService {

    // repository
    //**  implement Setter-based Injection
    private MenuMknRepository mknRepository;

    public MenuMknRepository getMknRepository() {
        return mknRepository;
    }
    @Autowired(required = false)
    public void setMknRepository(MenuMknRepository mknRepository) {
        this.mknRepository = mknRepository;
    }

    // Implementation services
    @Override
    public Menumkn addMenu(Menumkn menumkn) {
        return mknRepository.save(menumkn);
    }

    @Override
    public Menumkn getMenumknById(long id) {
        return mknRepository.findById(id).get();   
    }

    @Override
    public List<Menumkn> getMenumkn() {
        return (List<Menumkn>) mknRepository.findAll();
    }

    @Override
    public Menumkn updateMenumkn(Menumkn menumkn) {
        return mknRepository.save(menumkn);
    }

    @Override
    public void deleteMenumkn(long id) {
        mknRepository.deleteById(id);
    }



}
