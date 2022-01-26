package system;

public class Cart extends AvailableProducts{
	int quantity[];
	
	Cart()
	{
		super();
		quantity = new int[6];
		for(int i = 1; i < 6; i++)
			quantity[i] = 0;
	}
	
	
	// assign the number of items on cart
	void addToCart(int ind, int quan)
	{
		quantity[ind] = quan;
	}
	
	
}
