package pl.coderslab.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import pl.coderslab.model.Employee;

public class ExportPayrollToXml {
	
	private final static String fileName = "listaPlac.xml";//src/main/webapp/WEB-INF/
	
	public static String exportPayrollToXml(List<Employee> employees){
		
		StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		sb.append("\n<listaPlac>");
		for (Employee employee : employees) {
			sb.append("\n\t<pracownik pesel=\"");
			sb.append(employee.getPesel());
			sb.append("\" imie=\"");
			sb.append(employee.getFirstName());
			sb.append("\" nazwisko=\"");
			sb.append(employee.getLastName());
			sb.append("\">");
			sb.append(employee.getSalary());
			sb.append("</pracownik>");
		}
		sb.append("\n</listaPlac>");
		
		return sb.toString();
		
//		try {
////			Files.deleteIfExists(Paths.get(fileName));
//			System.out.println("jestem tutaj");
//			if(Files.exists(Paths.get(fileName))){
//				System.out.println("Plik istnieje");
//				
//			}
//			Files.write(Paths.get(fileName), sb.toString().getBytes(), StandardOpenOption.CREATE);
//			File file = new File(fileName);
//			System.out.println(file.getAbsolutePath());
//			System.out.println("po próbie zapisu");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
	}

}
