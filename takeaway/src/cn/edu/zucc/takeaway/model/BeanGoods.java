package cn.edu.zucc.takeaway.model;

public class BeanGoods {
	
	public static final  String[] tableTitles= {"商品","价格","折扣价格"};
	private int good_no;
	private int kind_no;
	private String good_name;
	private double good_price;
	private double good_sale;
	public int getGood_no() {
		return good_no;
	}
	public void setGood_no(int good_no) {
		this.good_no = good_no;
	}
	public int getKind_no() {
		return kind_no;
	}
	public void setKind_no(int kind_no) {
		this.kind_no = kind_no;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public double getGood_price() {
		return good_price;
	}
	public void setGood_price(double good_price) {
		this.good_price = good_price;
	}
	public double getGood_sale() {
		return good_sale;
	}
	public void setGood_sale(double good_sale) {
		this.good_sale = good_sale;
	}
	
	public String getCell(int col){
		
		if(col==0) return this.getGood_name();
		else if(col==1) return Double.toString(this.getGood_price());
		else if(col==2) return Double.toString(this.getGood_sale());
		else return "";
	}
	
	
	
	
	
	
}
