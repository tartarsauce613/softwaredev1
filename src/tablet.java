
public class tablet extends mobileDevice{
	private int screenSize;
	private String wirelessTech;
	
	
	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}
	public int getScreenSize() {
		return screenSize;
	}

	public void setwirelessTech(String wirelessTech) {
		this.wirelessTech = wirelessTech;
	}
	public String getWirelessTech() {
		return wirelessTech;
	}
	
	@Override
	public void getDescription() {  // override get description to add info
		System.out.println(brand + " : " + name + " : " + price + "\n" + screenSize + " : " + wirelessTech);
		System.out.println();
	}
}
