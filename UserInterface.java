package system;
import java.util.Scanner;

public class UserInterface extends Cart{
	UserInterface(){
		super();
	}
	
	void displayMenu() {
		System.out.println("\nInd.\tProducts\t\tRate");
		System.out.println("1.\tDairy Milk\t\tRs. 40");
		System.out.println("2.\tRice\t\t\tRs. 95");
		System.out.println("3.\tDove Soap\t\tRs. 45");
		System.out.println("4.\tDove Shampoo\t\tRs. 145");
		System.out.println("5.\tNutri Choice Biscuit\tRs. 65\n");
		addProducts();
	}
	
	void addProducts()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter Product index and Quantity: ");
		String ind, quan;
		ind = in.next();
		quan = in.next();
		if(Integer.parseInt(ind) > 5 || Integer.parseInt(ind) < 1)
		{
			System.out.print("Enter correct index!");
			displayMenu();
		}
		else {
			quantity[Integer.parseInt(ind)] = Integer.parseInt(quan);
		
			String ans;
			System.out.print("Do you want to add more product?(yes/no)\n");
			ans = in.next();
			if(ans.toLowerCase().startsWith("y"))
				displayMenu();
			else
				displayBill();
		}
		in.close();
	}
	
	
	void displayBill() {
		System.out.println("		BILL");
		int total = 0;
		for(int i = 0, j = 1; i < 6; i++)
		{
			if(quantity[i] > 0)
			{
				String productName = indToName(i);
				float rate = products.get(productName);
				total += quantity[i]*rate;
				System.out.println((j++) + ".\t" + productName + "\t\t" + rate + "\t" + quantity[i] + "\t" + quantity[i]*rate);
			}
		}
		System.out.println("Total: " + total);
		discount();
	}
	
	void discount()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Do you have a promocode?(y/n)");
		String ans = in.next();
		if(ans.equalsIgnoreCase("y"))
		{
			String coupon;
			System.out.print("Enter coupon code: ");
			coupon = in.next();
			if(coupon.equalsIgnoreCase("SHOP50"))
				billAfterDiscount();
			else {
				System.out.println("Invalid Code!");
				displayBill();
			}
		}else
			System.out.println("\nPay the bill.");
		
		in.close();	
	}
	
	void billAfterDiscount() {
		System.out.println("		BILL");
		float total = 0f;
		for(int i = 0, j = 1; i < 6; i++)
		{
			if(quantity[i] > 0)
			{
				String productName = indToName(i);
				float rate = products.get(productName)*9/10;
				total += quantity[i]*rate;
				System.out.println((j++) + ".\t" + productName + "\t\t" + rate + "\t" + quantity[i] + "\t" + quantity[i]*rate);
			}
		}
		System.out.println("Discounted Total Price: " + total);
	}
}
