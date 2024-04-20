package com.cb.dckpst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cb.dckpst.model.Menumkn;

@Repository
public interface MenuMknRepository extends JpaRepository<Menumkn, Long> {

}
