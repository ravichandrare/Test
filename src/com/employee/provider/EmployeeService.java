package com.employee.provider;

import java.util.ArrayList;
import java.util.HashMap;

import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public class EmployeeService {
		public EmployeeService(){
		loadEmployeeMap();
		}
		private HashMap<Integer,Employee> employeeMap;
		private void loadEmployeeMap(){
		employeeMap=new HashMap<Integer,Employee>();
		employeeMap.put(1,new Employee(1,"praveen","plano"));
		employeeMap.put(2,new Employee(2,"richard","irving"));
		employeeMap.put(3,new Employee(3,"champak","richardson"));
		}
		@WebMethod
		public Boolean findEmployee(int id){
			Employee emp = employeeMap.get(id);
			if(emp==null) {
				return false;
			}			
			return true;
		}
		
		@WebMethod
		public ArrayList<Employee> findByName(String name){
			
			ArrayList<Employee> empl = new ArrayList<Employee>();
	
			for (int emp : employeeMap.keySet()) {
				if((employeeMap.get(emp).getName()).equalsIgnoreCase(name)) {
					empl.add(employeeMap.get(emp));
				}
			}
			if(empl.size()==0) {
				empl.add(new Employee(-9,"unknown","unknown"));
			}
			return empl;	
		}
		
		@WebMethod
		public Boolean addEmployee(Employee employee){
		//TODO - If employee does not exist in map, then add in map - return true
		//TODO - If employee exists in map or is null, return false.
			if(employee!=null) {
			if(!employeeMap.containsKey(employee.getId())) {
				employeeMap.put(employee.getId(),employee);
				return true;
				
			}else return false;
			}
			return false;
			
		}
		
		@WebMethod
		public Boolean updateEmployee(int id){
			if(id==0) return false;
			if(employeeMap.containsKey(id)) {
				employeeMap.put(id,new Employee(id,"ravi","irving" ));
				return true;
			}else return false;
		//TODO - If employee does not exist in map, or is null, return false.
		//TODO - If employee exists in map - update with new employee object - return true
		}
		@WebMethod
		public Boolean removeEmployee(Employee employee){
			int id = employee.getId();
			if(employeeMap.containsKey(id))
			{
				employeeMap.remove(id);
				return true;
			}else return false;
		}
		
}