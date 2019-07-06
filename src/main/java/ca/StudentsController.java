package ca;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentsController {

	@Autowired
	private StudentsService studentsService;
    
    
    
    @GetMapping("/")
    List<Student>  getAll() {
        return studentsService.getAll();
    }
    
    @GetMapping("/all")
    public List<Student>  all() {
        return studentsService.getAll();
    }
    
    @GetMapping("/get")
    public Student getOne(@RequestParam(value="name") String name) {
    	return studentsService.getOne(name);
        
    }
    @GetMapping("/add")
    public Student addOne(@RequestParam(value="name") String name) {
    	return studentsService.addOne(name);
   
    }
    
    
}
