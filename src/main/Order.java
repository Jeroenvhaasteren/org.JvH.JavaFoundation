package main;

import pablo.Dish;

//Extend from a dish an order contains always a dish
public class Order extends Dish {
	private String m_customerName;
	private String m_extras;
		
	public String getCustomerName() {
		return m_customerName;
	}
	public void setCustomerName(String customerName) {
		this.m_customerName = customerName;
	}
	public String getExtras() {
		return m_extras;
	}
	public void setExtras(String extras) {
		m_extras = extras;
	}
	
	public String getOrderToString() {
		String enter = "\n";
		String orderToString = "";
		orderToString += "Customer name: " + this.m_customerName + enter;
		orderToString += "Dish name:     " + this.dishName + enter;
		orderToString += "Dish type:     " + getStringDishType() + enter;
		orderToString += "Gluten-free:   " + this.m_gfd + enter;
		orderToString += "Vegetarian:    " + this.m_vgd + enter;
		orderToString += "Halal-meat:    " + this.m_hmd + enter;
		orderToString += "Seafood-free:  " + this.m_sfd + enter;
		orderToString += "Extras:        " + this.m_extras + enter;
		return orderToString;
	}
	
}
