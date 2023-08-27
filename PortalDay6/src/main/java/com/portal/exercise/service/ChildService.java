package com.portal.exercise.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.*;
import com.portal.exercise.model.Child;
import com.portal.exercise.repository.ChildRepo;

@Service
public class ChildService {
	
	@Autowired
	public ChildRepo crepo;
	
	public String saveDetails(Child c)
	{
		crepo.save(c);
		return "Data is saved ";
	}
	
	public List<Child> getDetails()
	{
		return crepo.findAll();
		
	}
	
	public List<Child> sortByAsc(String childName)
	{
		return crepo.findAll(Sort.by(childName).ascending());
	}
	
	public List<Child> sortByDes(String childName)
	{
		return crepo.findAll(Sort.by(childName).descending());
	}
    
	public List<Child> pagination(int pageNum , int pageSize)
	{
		Page <Child> cont = crepo.findAll(PageRequest.of(pageNum,pageSize));
		return cont.getContent();
	}
	
	public List<Child> paginationAndSorting(int pageNum,int pageSize,String name)
	{
		Page<Child> cont1 = crepo.findAll(PageRequest.of(pageNum, pageSize,Sort.by(name)));
		return cont1.getContent();
	}
}
