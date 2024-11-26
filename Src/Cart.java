
public class Cart {
	public static final int MAX_NUMBERS_ORDERED =20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	 public int addDigitalVideoDisc(DigitalVideoDisc disc) {
	    if (this.qtyOrdered == 20) {
	        System.out.println("The cart is full");
	        return -1;
	    }
	    
	    for (int index = 0; index < this.qtyOrdered; index++) {
	        if (itemsOrdered[index].getTitle().equals(disc.getTitle())) {
	        	System.out.println("The disc " + disc.getTitle() + " has been added already");
	            return -1;
	        }
	    }
	    
	    itemsOrdered[this.qtyOrdered] = disc;
	    this.qtyOrdered += 1;
	    return 1;
	}

	/*public int addDigitalVideoDisc(DigitalVideoDisc [] dvdList)
	{	
		for(int i=0; i<dvdList.length; i++)
		{
			if(this.qtyOrdered==20){
				System.out.println("The cart is now full");
				return(-1);
			}
			DigitalVideoDisc disc=dvdList[i];
			for(int index=0;index < this.qtyOrdered; index++)
			{
				if(itemsOrdered[index].getTitle().equals(disc.getTitle())) {
					System.out.println("The disc " + disc.getTitle() + " has been added");
				}
				else {
					itemsOrdered[this.qtyOrdered]=disc;
					this.qtyOrdered+=1;
				}
			}
		}
		return(1);
	}*/
	
	public int addDigitalVideoDisc(DigitalVideoDisc... discs) {
	    int totalAdded = 0; // Biến để đếm số lượng DVD đã thêm thành công
	    for (DigitalVideoDisc disc : discs) {
	        if (this.qtyOrdered == 20) {
	            System.out.println("The cart is full");
	            break;
	        }
	        
	        // Kiểm tra trùng lặp DVD
	        boolean isDuplicate = false;
	        for (int index = 0; index < this.qtyOrdered; index++) {
	            if (itemsOrdered[index].getTitle().equals(disc.getTitle())) {
	                System.out.println("The disc " + disc.getTitle() + " has been added already");
	                isDuplicate = true;
	                break;
	            }
	        }
	        
	        if (!isDuplicate) {
	            itemsOrdered[this.qtyOrdered] = disc;
	            this.qtyOrdered += 1;
	            totalAdded += 1;
	        }
	    }
	    
	    return totalAdded > 0 ? totalAdded : -1; // Trả về số lượng DVD đã thêm hoặc -1 nếu không có DVD nào được thêm
	}
	
	public int removeDigitalVideoDisc(DigitalVideoDisc disc)
	{
		if(this.qtyOrdered==0)
		{
			System.out.println("The cart is empty");
			return(0);
		}
		int index;
		for(index=0;index < this.qtyOrdered; index++)
		{
			if(itemsOrdered[index].getTitle().equals(disc.getTitle())) break;
		}
		if (index==qtyOrdered-1) 
		{
			System.out.println("The disc is not in the cart");
			return(0);
		}
		for(int j=index; j<this.qtyOrdered-1; j++)
		{
			itemsOrdered[j]=itemsOrdered[j+1];
		}
		this.qtyOrdered-=1;
		return(1);
	}
	
	public float totalCost()
	{
		float cost=0;
		for(int i=0; i<this.qtyOrdered; i++)
		{
			cost+=itemsOrdered[i].getCost();
		}
		return(cost);
	}
}
