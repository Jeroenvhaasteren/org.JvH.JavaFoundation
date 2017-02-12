package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
	private Scanner scanner;
	
	CSVReader(String filePath) throws FileNotFoundException {
		try {
			scanner = new Scanner(new File(filePath));
		}
		catch (FileNotFoundException e){
		    System.out.println("File not found at:" + filePath);
		    return;
		}
	}
	
	public  List<Order> readFile() {
		//Skip the header row in csv
		scanner.nextLine();
        List<Order> orders = new ArrayList<Order>();
        
        while(scanner.hasNextLine()){
        	String line = scanner.nextLine();
            String[] fields = line.split(",");
        	int i = 0;
        	Order order=new Order();
        	//Build order object
        	order.setCustomerName(fields[i]);
        	i++;
        	order.setDishName(fields[i]);
        	i++;
        	order.setType(getDishType(fields[i]));
        	i++;
        	order.setGFD(Boolean.parseBoolean(fields[i]));
        	i++;
        	order.setVGD(Boolean.parseBoolean(fields[i]));
        	i++;
        	order.setHMD(Boolean.parseBoolean(fields[i]));
        	i++;
        	order.setSFD(Boolean.parseBoolean(fields[i]));
        	i++;
        	order.setExtras(fields[i]);
            orders.add(order);
        }
        scanner.close();
        
        return orders;
	}
	
	public void importFile(String filePath) throws FileNotFoundException {
		try {
			scanner = new Scanner(new File(filePath));
		}
		catch (FileNotFoundException e){
		    System.out.println("File not found at:" + filePath);
		    return;
		}
	}
	
	private int getDishType(String dishType) {
		int type;
		switch(dishType) {
			case "st":
				type = 1;
				break;
			case "mc":
				type = 2;
				break;
			case "ds":
				type = 3;
				break;
			default:
				type = 0;
				System.out.println("Dishtype Unkown");
				break;
		}
		return type;
	}

}

//C:\Users\Usuario\Desktop