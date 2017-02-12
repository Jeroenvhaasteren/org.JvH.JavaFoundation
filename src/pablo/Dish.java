package pablo;

public abstract class Dish 
{
	public Dish() { }
	
	//properties of a dish
	protected String dishName;
	protected int m_type;
	protected boolean m_gfd;
	protected boolean m_vgd;
	protected boolean m_hmd;
	protected boolean m_sfd;

	public String getDishName() { 
		return dishName; 
	}
	public void setDishName(String dName) { 
		this.dishName = dName; 
	}
	public int getType() {
		return m_type;
	}
	public void setType(int type) {
		this.m_type = type;
	}
	public boolean isGFD() {
		return m_gfd;
	}
	public void setGFD(boolean gfd) {
		this.m_gfd = gfd;
	}
	public boolean isVGD() {
		return m_vgd;
	}
	public void setVGD(boolean vgd) {
		this.m_vgd = vgd;
	}
	public boolean isHMD() {
		return m_hmd;
	}
	public void setHMD(boolean hmd) {
		this.m_hmd = hmd;
	}
	public boolean isSFD() {
		return m_sfd;
	}
	public void setSFD(boolean sfd) {
		this.m_sfd = sfd;
	}
	
	//Get String type of a dish
	public String getStringDishType() {
		String dishType;
		switch (this.m_type) {
			case 1:
				dishType = "Starter";
				break;
			case 2:
				dishType = "Maincourse";
				break;
			case 3:
				dishType = "Dessert";
				break;
			default:
				dishType = "Unkown";
				break;
		}
		return dishType;
	}
	
	//Print only dish properties to String
	public String getDishToString() {
		String enter = "\n";
		String dishToString = "";

		dishToString += "Dish name:     " + this.dishName + enter;
		dishToString += "Dish type:     " + getStringDishType() + enter;
		dishToString += "Gluten-free:   " + this.m_gfd + enter;
		dishToString += "Vegetarian:    " + this.m_vgd + enter;
		dishToString += "Halal-meat:    " + this.m_hmd + enter;
		dishToString += "Seafood-free:  " + this.m_sfd + enter;
		return dishToString;
	}
	
	
}
