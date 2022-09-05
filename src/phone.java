
public class phone extends mobileDevice {
	private int storageSize;
	private String color;
	private String service;
	
	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}
	public int getStorageSize() {
		return storageSize;
	}

	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	
	public void setService(String service) {
		this.service = service;
	}
	public String getService() {
		return service;
	}
	
	@Override
	public void getDescription() {  // override get description to add info, also displays polymorphism at runtime
		System.out.println(brand + " : " + name + " : " + price + "\n" + storageSize + " : " + color + " : " + service);
		System.out.println();
	}
}
