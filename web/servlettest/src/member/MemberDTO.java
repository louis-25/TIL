package member;

public class MemberDTO {
	//member테이블의 id만 board
	String id;
	int password;
	String name;
	
	public MemberDTO() {}
	public MemberDTO(String id, int password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", password=" + password + ", name=" + name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
