import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		phone iphone = new phone();
		
		String name;
		String brand;
	    double price;
	    int storageSize;
	    String color;
	    String service;
	    
	    System.out.print("Enter device name: ");
	    name = scnr.nextLine();
		iphone.setName(name);
	   
		System.out.print("Enter device brand: ");
	    brand = scnr.nextLine();
	    iphone.setBrand(brand);
	    
	    System.out.print("Enter device price: ");
	    price = scnr.nextDouble();
	    iphone.setPrice(price);
	    
	    System.out.print("Enter device storage in GB: ");
	    storageSize = scnr.nextInt();
	    iphone.setStorageSize(storageSize);
	    scnr.nextLine();
	    
	    System.out.print("Enter device color: ");
	    color = scnr.nextLine();
	    iphone.setColor(color);
	    
	    System.out.print("Enter device Service: ");
	    service = scnr.nextLine();
	    iphone.setService(service);
	    
	    iphone.getDescription();
	    
	    tablet ipad = new tablet();
	    int screenSize;
		String wirelessTech;
		
		System.out.print("Enter device name: ");
	    name = scnr.nextLine();
		ipad.setName(name);
	   
		System.out.print("Enter device brand: ");
	    brand = scnr.nextLine();
	    ipad.setBrand(brand);
	    
	    System.out.print("Enter device price: ");
	    price = scnr.nextDouble();
	    ipad.setPrice(price);
	    
	    System.out.print("Enter device screen size in inches: ");
	    screenSize = scnr.nextInt();
	    ipad.setScreenSize(screenSize);
	    scnr.nextLine();
	    
	    System.out.print("Enter device wireless technology (wifi or cellular): ");
	    wirelessTech = scnr.nextLine();
	    ipad.setwirelessTech(wirelessTech);
	    
	    
	    ipad.getDescription();
	    
		}

}
