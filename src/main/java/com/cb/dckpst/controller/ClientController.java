package com.cb.dckpst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.cb.dckpst.model.Menumkn;
import com.cb.dckpst.service.MenuMknService;

@RestController
public class ClientController {

    // service
    //**  implement Setter-based Injection
    private MenuMknService menuMknService;

    public MenuMknService getMenuMknService() {
        return menuMknService;
    }
    @Autowired(required = false)
    public void setMenuMknService(MenuMknService menuMknService) {
        this.menuMknService = menuMknService;
    }

    @RequestMapping("/")
    public String hello_test(){
        return "Hello, world!";
    }

    // add MenuMakanan
    @RequestMapping("/add")
    public String addMenu(@RequestBody Menumkn menumkn){
        menuMknService.addMenu(menumkn);
        return "Menu makanan berhasil ditambahkan";
    }

    // getMenuMkn by Id
    @RequestMapping("/menumkn/{id}")
    public Menumkn getMenumknById(@PathVariable("id") long id) {
        return menuMknService.getMenumknById(id);
    }

    // ambil menu makanan all
    @RequestMapping("/menumkns")
    public List<Menumkn> getMenumkn(){
        return menuMknService.getMenumkn();
    }

    // update MenuMakanan
    @RequestMapping("/menumkn")
    public Menumkn updateMenumkn(@RequestBody Menumkn menumkn){
        return menuMknService.updateMenumkn(menumkn);
    }

    // delete MenuMakanan
    @DeleteMapping("/menumkn/{id}")
    public String deleteMenumkn(@PathVariable ("id") long id){
        menuMknService.deleteMenumkn(id);
        return "Menu makanan berhasil di delete";
    }
}
