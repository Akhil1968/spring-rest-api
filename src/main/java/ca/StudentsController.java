package ca;



import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentsController {


    private static final AtomicLong counter = new AtomicLong();
    private static List<Student> studentList = new ArrayList<Student>();
    
    static {
    	studentList.add( new Student(counter.incrementAndGet(), "AWS Beanstalk"));
    	studentList.add( new Student(counter.incrementAndGet(), "Google App Engine"));
    	studentList.add( new Student(counter.incrementAndGet(), "Heroku"));
    }
    
    
    @RequestMapping("/")
    List<Student>  getAll() {
        return studentList;
    }
    
    @RequestMapping("/all")
    public List<Student>  all() {
        return studentList;
    }
    
    @RequestMapping("/get")
    public Student getOne(@RequestParam(value="name") String name) {
    	Student aStudent = findStudent(name);
    	if (aStudent == null) {
    		return new Student(0L, "None");
    	}else {
    		return aStudent;
    	}
        
    }
    @RequestMapping("/add")
    public Student addOne(@RequestParam(value="name") String name) {
    	Student newStudent = new  Student(counter.incrementAndGet(), name);
    	studentList.add(newStudent);
    	return newStudent;
   
    }
    
    public Student findStudent(String name) {
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
