
public class Store {
	public static final int MAX_ITEMS_IN_STORE = 1000;
	DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
	//private String authenticate;
	private int nbStoreManager;
	private int idStoreManager;
	private int nbItems;
	
	public void setAuth()
	{
		//this.authenticate="Store Manager";
		this.nbStoreManager++;
		this.idStoreManager=this.nbStoreManager;
	}
	
	public int getNbItems() {
		return nbItems;
	}

	public DigitalVideoDisc[] getItemsInStore() {
		return itemsInStore;
	}

	public int getNbStoreManager() {
		return nbStoreManager;
	}

	public int getIdStoreManager() {
		return idStoreManager;
	}
	
	public int addDVD(DigitalVideoDisc... discs) {
	    int totalAdded = 0; // Biến để đếm số lượng DVD đã thêm thành công
	    for (DigitalVideoDisc disc : discs) {
	        if (this.nbItems == MAX_ITEMS_IN_STORE) {
	            System.out.println("The store is full");
	            break;
	        }
	        
	        // Kiểm tra trùng lặp DVD
	        boolean isDuplicate = false;
	        for (int index = 0; index < this.nbItems; index++) {
	            if (itemsInStore[index].getTitle().equals(disc.getTitle())) {
	                System.out.println("The disc " + disc.getTitle() + " has been added already");
	                isDuplicate = true;
	                break;
	            }
	        }
	        
	        if (!isDuplicate) {
	            itemsInStore[this.nbItems] = disc;
	            this.nbItems += 1;
	            totalAdded += 1;
	        }
	    }
	    
	    return totalAdded > 0 ? totalAdded : -1; // Trả về số lượng DVD đã thêm hoặc -1 nếu không có DVD nào được thêm
	}
	
	public int removeDVD(DigitalVideoDisc disc)
	{
		if(this.nbItems==0)
		{
			System.out.println("The store is empty");
			return(0);
		}
		int index;
		for(index=0;index < this.nbItems; index++)
		{
			if(itemsInStore[index].getTitle().equals(disc.getTitle())) break;
		}
		if (index==nbItems-1) 
		{
			System.out.println("The disc is not in the store");
			return(0);
		}
		for(int j=index; j<this.nbItems-1; j++)
		{
			itemsInStore[j]=itemsInStore[j+1];
		}
		this.nbItems-=1;
		return(1);
	}
}
