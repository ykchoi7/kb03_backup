package java0324.가전제품.vo;

import java.util.ArrayList;

public class GajeonManager {
	
	private ArrayList<MyGajeon> arr1 = new ArrayList<>();
	
	public void add(MyFridge mf1) {
		arr1.add(mf1);
	}
	
	public void add(MyWashingMachine mw1) {
		arr1.add(mw1);
	}
	
//	public void add(MyGajeon mg1) {
//		arr1.add(mg1);
//	}
	//이렇게 부모 타입으로 한번에 add할 수도 있지만 다른 사람이 볼 때 자식에 어떤 종류가 있는지 확인할 수 없다
	
	public int getCount() {
		return arr1.size();
	}
	
	public void printAll() {
		for (MyGajeon myGajeon : arr1) {
			System.out.println(myGajeon.toString());
		}
	}
	
	public MyGajeon FindByPosition(String madeby, int date) {
		for (MyGajeon myGajeon : arr1) {
			if (arr1.equals(madeby) && arr1.equals(date))
				return myGajeon;
		}
		return null;
	}
}
