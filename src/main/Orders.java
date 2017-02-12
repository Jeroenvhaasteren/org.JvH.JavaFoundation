package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import pablo.OnlineOrderOps;


public class Orders implements OnlineOrderOps {
	private List<Order> m_orders;
	
	//Constructor
	Orders() throws FileNotFoundException {
		CSVReader test = new CSVReader("/Users/Usuario/JAVAworkspace/org.JvH.JavaFoundation/src/res/online_order_sample.csv");
		m_orders = test.readFile();
	}
	//Overload contructor for different csv location
	Orders(String url) throws FileNotFoundException {
		CSVReader test = new CSVReader(url);
		m_orders = test.readFile();
	}

	@Override
	public int getNumberOrders() {
		return this.m_orders.size();
	}

	@Override
	public String getOrder(int orderIndex) {
		return this.m_orders.get(orderIndex).getOrderToString();
	}

	@Override
	public String getAllOrdersToString() {
		List<Order> orders = this.m_orders;
		String orderList  = "************************************\n";
		orderList += "************ORDERS******************\n";
		orderList += "************************************\n";
		for (int i = 0; i < orders.size(); i++) {
			orderList += "Order number: " + i + "\n";
			orderList += orders.get(i).getOrderToString();
			orderList += "-\n";
		}
		return orderList;
	}

	@Override
	public String getDish(int dishIndex) {
		List<Order> orders = this.m_orders;
		return orders.get(dishIndex).getDishToString();
	}

	@Override
	public String getAllDishToString() {
		List<Order> orders = this.m_orders;
		String dishList = "************************************\n";
		dishList += "************DISHES*****************\n";
		dishList += "************************************\n";
		for (int i = 0; i < orders.size(); i++) {
			dishList += "Dish number: " + i + "\n";
			dishList += orders.get(i).getDishToString();
			dishList += "-\n";
		}
		return dishList;
	}

	@Override
	public String getDishesByType(String dishType) {
		int type = convertDishTypeToInt(dishType);
		List<Order> orders = this.m_orders;
		String dishList = "************************************\n";
		dishList += "************DISHES of type " + dishType + "********\n";
		dishList += "************************************\n";
		for (int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getType() == type){
				dishList += orders.get(i).getDishToString();
				dishList += "-\n";
			}
		}
		return dishList;
	}

	@Override
	public String getDishesByFeature(String feature) {
		List<Order> orders = new ArrayList<Order>();
		List<Order> temporders = this.m_orders;
		switch(feature) {
			case "gfd":
				for (int i = 0; i < temporders.size(); i++) {
					if(temporders.get(i).isGFD()){
						orders.add(temporders.get(i));
					}
				}
				break;
			case "vgd":
				for (int i = 0; i < temporders.size(); i++) {
					if(temporders.get(i).isVGD()){
						orders.add(temporders.get(i));
					}
				}
				break;
			case "hmd":
				for (int i = 0; i < temporders.size(); i++) {
					if(temporders.get(i).isHMD()){
						orders.add(temporders.get(i));
					}
				}
				break;
			case "sfd":
				for (int i = 0; i < temporders.size(); i++) {
					if(temporders.get(i).isSFD()){
						orders.add(temporders.get(i));
					}
				}
				break;
			default:
				orders = temporders;
				break;
		}
		String dishList = "************************************\n";
		dishList += "*********DISHES of feature " + feature + "********\n";
		dishList += "************************************\n";
		for (int i = 0; i < orders.size(); i++) {
			dishList += orders.get(i).getDishToString();
			dishList += "-\n";
		}
		return dishList;
	}

	@Override
	public String getStatsByDishType(String dishType) {
		int type = convertDishTypeToInt(dishType);
		
		double total = getNumberOrders();
		double gfd = 0;
		double vgd = 0;
		double hmd = 0;
		double sfd = 0;
		List<Order> orders = this.m_orders;
		for (int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getType() == type || dishType.equals("All")){
				if(orders.get(i).isGFD()) {
					gfd ++;
				}
				if(orders.get(i).isVGD()) {
					vgd ++;
				}
				if(orders.get(i).isHMD()) {
					hmd ++;
				}
				if(orders.get(i).isSFD()) {
					sfd ++;
				}
			}
		}
		double percentagegfd = 0.0,
				percentagevgd = 0.0,
				percentagehmd = 0.0,
				percentagesfd = 0.0;
		percentagegfd=Math.round((gfd/total)*100);
		percentagevgd=Math.round((vgd/total)*100);
		percentagehmd=Math.round((hmd/total)*100);
		percentagesfd=Math.round((sfd/total)*100);

		
		String Stats = "************************************\n";
		Stats += "************STATISTICS**************\n";
		Stats += "************************************\n";
		Stats += "Totaal number of dishes: " + total +"\n";
		Stats += "Percentage GFD: " + percentagegfd +"%\n";
		Stats += "Percentage VGD: " + percentagevgd +"%\n";
		Stats += "Percentage HMD: " + percentagehmd +"%\n";
		Stats += "Percentage SFD: " + percentagesfd +"%\n";
		return Stats;
			
		}
	
	// Convert int type of Dish to String for compaire input
	//@param dishtype String st: Starter, mc: Maincourse, ds: Dessert
	private int convertDishTypeToInt(String dishtype) {
		int type;
		switch(dishtype) {
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
				break;
		}
		return type;
	}

}
