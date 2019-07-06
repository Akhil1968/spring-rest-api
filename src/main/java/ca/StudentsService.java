package ca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;


@Component
public class StudentsService {
	 private static final AtomicLong counter = new AtomicLong();
	    private static List<Student> studentList = new ArrayList<Student>();
	    
	    static {
	    	studentList.add( new Student(counter.incrementAndGet(), "AWS Beanstalk"));
	    	studentList.add( new Student(counter.incrementAndGet(), "Google App Engine"));
	    	studentList.add( new Student(counter.incrementAndGet(), "Heroku"));
	    }
	    
	    
	   
	    List<Student>  getAll() {
	        return studentList;
	    }
	    
	    
	    public List<Student>  all() {
	        return studentList;
	    }
	    
	    
	    public Student getOne( String name) {
	    	Student aStudent = findStudent(name);
	    	if (aStudent == null) {
	    		return new Student(0L, "None");
	    	}else {
	    		return aStudent;
	    	}
	        
	    }
	   
	    public Student addOne(String name) {
	    	Student newStudent = new  Student(counter.incrementAndGet(), name);
	    	studentList.add(newStudent);
	    	return newStudent;
	   
	    }
	    
	    private Student findStudent(String name) {
		    Iterator<Student> iterator = studentList.iterator();
		    while (iterator.hasNext()) {
		    	Student student = iterator.next();
		        if (student.getName().equalsIgnoreCase(name)) {
		            return student;
		        }
		    }
		    return null;
		}

}
