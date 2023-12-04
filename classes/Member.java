package tw.frank.classes;
//擁有會員物件，彈性才會大~
public class Member {
	private int id;
	private String account, name;	
	//寫完後，後面都用產生器產生...
	
	//Source -> Generate Constructor using field
	public Member(int id, String account, String name) {
		super();
		this.id = id;
		this.account = account;
		this.name = name;
	}

	//Source -> Generate Getters & Setters
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
}
//後面新會員可用JOIN關聯產生