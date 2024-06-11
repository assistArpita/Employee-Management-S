package com.empolyee.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empolyee.entity.Emp;
import com.empolyee.repository.EmpRepo;



@Service
public class EmpService {

	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Emp e)
	{
		repo.save(e);
	}
	 
	public List<Emp> getAllEmp(){
		
		return repo.findAll();
		
	}
	
	public Emp getEmpbyId(int id)
	{
		Optional<Emp> e=repo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		return null;
	}
	
	
	public void deleteEmp(int id)
	{
		repo.deleteById(id);
	}
}
