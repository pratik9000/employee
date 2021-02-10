package com.infy.employee.employeeapplication.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employee.employeeapplication.employeerepository.*;
import java.util.List;
import java.util.Optional;
@RestController

public class myController {
	@Autowired
	empRepoimpl emp;
	
	@GetMapping("/getemployee")
	public List<employee> getemployee(){
		
		return emp.findAll();
		
		
	}
	@DeleteMapping("{id}")
	public String get(@PathVariable("id") String id){
		List<employee> empp=emp.findAll();
		employee e=null;
		for(employee i : empp) {
			if(i.getEmployeeid().equals(id)) {
				e=i;
				break;
			}
		}
		 emp.delete(e);
		 return "deleted employee Id:"+id+"sucessfully";
	}
	@PostMapping("/insert")
	public String insert(@RequestBody employee e){
		emp.save(e);
		
		return "sucessfullt inserted record with id:"+e.getEmployeeid()+" & name:"+e.getEmployeename();
	}
	
	@PutMapping("/update/{id}/{name}")
	public String update(@PathVariable String id,@PathVariable String name) {
		Optional<employee> e=emp.findById(id);
		e.get().setEmployeename(name);
		emp.save(e.get());
		
		return "updated sucessfully record with id:"+e.get().getEmployeeid();
	}
	
	

}
