package com.empolyee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.empolyee.entity.Emp;

@Repository
public interface EmpRepo extends JpaRepository<Emp, Integer>{

}
