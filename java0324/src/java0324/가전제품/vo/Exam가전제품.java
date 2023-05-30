package java0324.가전제품.vo;

public class Exam가전제품 {

	public static void main(String[] args) {
		
		GajeonManager gm = new GajeonManager();

		MyGajeon mg1 = new MyGajeon("samsung", 230101);
		System.out.println(mg1);
		
		MyFridge mf1 = new MyFridge("samsung", 230101, 4, 2);
		gm.add(mf1);
		System.out.println(mf1);
		
		MyWashingMachine mw1 = new MyWashingMachine("samsung", 230101, "wool");
		gm.add(mw1);
		System.out.println(mw1);
		
		int count = gm.getCount();
		System.out.println("저장갯수=" + count);
		
		MyGajeon g = gm.FindByPosition("samsung", 230101);
		if (g == null)
			System.out.println("없음");
		else
			System.out.println("있음");
	}

}
