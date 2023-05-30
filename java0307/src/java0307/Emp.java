package java0307;

public class Emp extends Person {
	
	private String booseo;

	public Emp(String name, int age, String booseo) {
		super(name, age);
		this.booseo = booseo;
	}
	
	public String getBooseo() {
		return booseo;
	}
	
	public void setBooseo(String booseo) {
		this.booseo = booseo;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", 부서=" +booseo;
	}
}
