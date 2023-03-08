package mvc.twitter.cart;

import java.util.ArrayList;

public class CartBean {

	private final String ID = "longlee";
	private final String PASSWD = "6789";
	ArrayList<String> productList;
	
	public CartBean() {
		productList = new ArrayList<String>(); //cartbean객체 만들어질때 productlist도 만들어집니다.
		
	}
	
	public boolean checkLogin(String id, String passwd) {
		boolean result = false;
		//로그인 성공 여부 검사
		
		if(id != null && id.equals(this.ID) && passwd != null && passwd.equals(this.PASSWD) ) {
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
