package java0324.가전제품.vo;

public class MyWashingMachine extends MyGajeon {

	private String fabric;

	public MyWashingMachine(String madeby, int date, String fabric) {
		super(madeby, date);
		this.fabric = fabric;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	@Override
	public String toString() {
		return super.toString() + ", fabric=" + fabric;
	}

}
