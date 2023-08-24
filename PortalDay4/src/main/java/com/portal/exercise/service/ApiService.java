package com.portal.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.portal.exercise.model.Student;
import com.portal.exercise.repository.StudentRepo;

@Service
public class ApiService {
	
	@Autowired
	public StudentRepo srepo;
	
	public String saveStudent(Student s)
	{
		srepo.save(s);
		return "Data is saved to the database";
	}
    
	public List<Student> getStudent()
	{
		return srepo.findAll();
	}
	
	//update the data
   public Student updateStudent(Student sm)
   {
	   return srepo.saveAndFlush(sm);
   }
   
   //update by id 
   public boolean updateStudentInfo(int studentId,Student sm)
   {
	   if(srepo.existsById(studentId))
			   {
		         srepo.save(sm);
		         return true;
			   }
	   return false;
			
   }
   
   //delete if id is present
   public boolean deleteEventIf(int studentId)
   {
	   if(srepo.existsById(studentId))
	   {
		 srepo.deleteById(studentId);
		 return true;
	   }
	   return false;
   }
   
   //delete the data
    public void deleteStudent(int student_Id)
    {
    	srepo.deleteById(student_Id);
    }
	
}
