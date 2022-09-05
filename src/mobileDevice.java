import java.util.Scanner;

public class mobileDevice {
	protected double price;
	protected String brand;
	protected String name;
	
	public void device() {
		price = 0.00;
		brand = "blank";
		name = "blank";
	}
	
	public void setPrice(double price) {
		this.price = price;	
	}
	public double getPrice() {
		return price;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return brand;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void getDescription() {
		System.out.println(brand + " : " + name + " : " + price);
		System.out.println();
	}
}
