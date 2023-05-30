package java0324;

import java0324.vo.MyDrawable;

public class MyCarPicture implements MyDrawable {
//MyShape을 상속받지 않음
	
	@Override
	public String draw() {
		return "자동차그림";
	}

}
