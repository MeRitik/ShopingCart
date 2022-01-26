package system;
import java.util.*;

public class AvailableProducts {
	TreeMap<String, Float> products = new TreeMap<String, Float>();
	
	AvailableProducts()
	{
		products.put("Dairy Milk", 40f);
		products.put("Rice", 95f);
		products.put("Dove Soap", 45f);
		products.put("Dove Shampoo", 145f);
		products.put("Nutri Choice Biscuit", 65f);
	}
	
	public String indToName(int index)
	{
		switch(index) {
		case 1:return "Dairy Milk";
		case 2:return "Rice";
		case 3:return "Dove Soap";
		case 4:return "Dove Shampoo";
		case 5:return "Nutri Choice Biscuit";
		}
		
		// No such case will occur
		return "";
	}
}
