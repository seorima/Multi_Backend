package mvc.twitter.cart;

import java.util.ArrayList;

public class CartBean {

	private final String ID = "longlee";
	private final String PASSWD = "6789";
	ArrayList<String> productList;
	
	public CartBean() {
		productList = new ArrayList<String>();
	}
	
	public boolean checkLogin(String id, String passwd) {
		boolean result = false;
		
		if(id != null && id.equals(this.ID) && passwd != null && passwd.equals(this.PASSWD)) {
			result = true;
		}
		
		return result;
	}
	
	public ArrayList<String> getProductList() {
		return this.productList;
	}
	
	public void addProduct(String product) {
		this.productList.add(product);
	}
	
	public void clearProductList() {
		this.productList.clear();
	}
}









