package dto;

public class productDto {
	private int pno;
	private String pname;
	private int price;
	
	public productDto() {;}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return pno + ". " + pname + " (가격: " +  price + ")";
	}
}
