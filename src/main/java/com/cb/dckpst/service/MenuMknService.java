package com.cb.dckpst.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cb.dckpst.model.Menumkn;

@Service
public interface MenuMknService  {
    public Menumkn addMenu(Menumkn menumkn);
    public Menumkn getMenumknById(long id);
    public List<Menumkn> getMenumkn();
    public Menumkn updateMenumkn(Menumkn menumkn);
    public void deleteMenumkn(long id);
}
