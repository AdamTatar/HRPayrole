package pl.coderslab.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;

import pl.coderslab.model.Employee;
import pl.coderslab.repository.EmployeeRepository;

public class AddEmployeesFromFile {

	private static final String fileName = "employees.txt";
	
	@Autowired
	
	public List<Employee> addEmployeesFromFile(){
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(fileName));
			Random rand = new Random();
			List<Employee> result = new ArrayList<>();
			for (String s : lines) {
				StringTokenizer st = new StringTokenizer(s, ";");
				Employee e = new Employee();
				e.setFirstName(st.nextToken());
				e.setLastName(st.nextToken());
				e.setPesel(st.nextToken());
				e.setSalary(BigDecimal.valueOf(Double.parseDouble(st.nextToken())));
				e.setBonus(BigDecimal.valueOf(Double.parseDouble(st.nextToken())));
				e.setBankAccountNumber("10 4521" +" "+ (rand.nextInt(7999)+1000) + " 0000 "+ (rand.nextInt(7999)+1000)+" "+ (rand.nextInt(7999)+1000)+ " "+(rand.nextInt(7999)+1000));
				e.setAddress1("Jana Pawła II 35/2");
//				e.setBirthDate(new Date("19"+(40+rand.nextInt(50))+"-"+(1+rand.nextInt(11))+"-"+(1+rand.nextInt(27))));
				e.setSecondName("");
				result.add(e);
				
				return result;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		
//		AddEmployeesFromFile aE = new AddEmployeesFromFile();
//		List<Employee> list = aE.addEmployeesFromFile();
//		for (Employee employee : list) {
//			System.out.println(employee);
//		}
//	}
	
	Random rand = new Random();
	for (int i = 0; i < 10; i++) {
		System.out.println("10 4521" +" "+ (rand.nextInt(7999)+1000) + " 0000 "+ (rand.nextInt(7999)+1000)+" "+ (rand.nextInt(7999)+1000)+ " "+(rand.nextInt(7999)+1000));
	}
		
	}
}
