package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	private static Scanner inputReader = new Scanner(System.in);
	private static Orders orderList;

	public static void main(String[] args) {
		importFile();
	}
	
	private static void importFile() {
		System.out.println("Welcome by the restaurant order program");
		System.out.println("Enter path to csv file with orders or keep blank to go to default location");
		String path = inputReader.nextLine();
		try {
			if(path.length()>0){
				orderList = new Orders(path);
			} else {
				orderList = new Orders();
			}

			mainMenu();
		}
		catch (FileNotFoundException e){
		    System.out.println("File not found at:" + path);
		    return;
		}

	}
	
	private static void backToMainMenu() {
		System.out.println("");
		System.out.println("enter some text to go back to main menu");
		inputReader.next();
		mainMenu();
	}
	
	private static void mainMenu() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("*** MENU ***");
		System.out.println("0: Show the number of orders");
		System.out.println("1: Show all the orders");
		System.out.println("2: Show one specific order");
		System.out.println("-----------------------------");
		System.out.println("10: Show all the dishes");
		System.out.println("11: Show specific dish");
		System.out.println("12: Show all dishes by type");
		System.out.println("13: Show all dishes by feature");
		System.out.println("14: Show Statisics of the orders");
		System.out.println("-----------------------------");
		System.out.println("99: Close programm");
		System.out.println("Enter number menu item");
		int menuItem = inputReader.nextInt();
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		switch(menuItem) {
		case 0:
			System.out.println("Number of orders: " + orderList.getNumberOrders());
			backToMainMenu();
			break;
		case 1:
			System.out.println(orderList.getAllOrdersToString());
			backToMainMenu();
			break;
		case 2:
			System.out.println("Enter index number for order details");
			int orderindex = inputReader.nextInt();
			System.out.println(orderList.getOrder(orderindex));
			backToMainMenu();
			break;
		case 10:
			System.out.println(orderList.getAllDishToString());
			backToMainMenu();
			break;
		case 11:
			System.out.println("Enter index number for dish details");
			int dishindex = inputReader.nextInt();
			System.out.println(orderList.getDish(dishindex));
			backToMainMenu();
			break;
		case 12:
			System.out.println("Enter type for list of dishes [st, mc, ds]");
			String dishtype = inputReader.next();
			System.out.println(orderList.getDishesByType(dishtype));
			backToMainMenu();
			break;
		case 13:
			System.out.println("Enter feature for list of dishes [gfd, vgd, hmd, sfd]");
			String dishfeature = inputReader.next();
			System.out.println(orderList.getDishesByFeature(dishfeature));
			backToMainMenu();
			break;
		case 14:
			System.out.println("Enter feature for list of dishes [st, mc, ds, All]");
			String dishstats = inputReader.next();
			System.out.println(orderList.getStatsByDishType(dishstats));
			backToMainMenu();
			break;
		case 99:
			System.exit(0);
			break;
		default:
			System.out.println("Menu item does not exits");
			mainMenu();
			break;
		}
		
	}
	
}
