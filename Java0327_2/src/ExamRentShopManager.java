import rentshop.vo.book;
import rentshop.vo.rent;
import rentshop.vo.video;

public class ExamRentShopManager {
	public static void main(String[] args) {
		RentShopManager rsm=new RentShopManager();
		try {
			rsm.add(new book(1,"김","책",200,2000,false));
			rsm.add(new book(2,"박","책2",300,3000,false));
			rsm.add(new video(3,"디즈니","용",120,4000,false));
			rsm.add(new video(4,"CJ","드래곤",140,5000,false));
			rsm.add(new video(4,"AMC","드래곤",140,5000,false));
			
			System.out.println("책 등록 갯수: "+rsm.getBookcount());
			System.out.println("비디오 등록 갯수: "+rsm.getVidcount());
			System.out.println("총 등록 갯수: "+rsm.getCount());
		} catch (ManageExistException e) {
			System.err.println("등록 오류: "+e.getMessage());
		}
		rent r=null;
		try {
			r=rsm.findbyManagenum(1);
			System.out.println("검색 성공 "+ r.toString());
		}catch (NotFoundException e2) {
			System.err.println("검색 실패 "+e2.getMessage());
		}
		try {
			r=rsm.findbyManagenum(7);
			System.out.println("검색 성공 "+ r.toString());
		}catch (NotFoundException e2) {
			System.err.println("검색 실패 "+e2.getMessage());
		}
		try {
			r=rsm.findbyManagenum(3);
			System.out.println("대여 성공 "+ r.toString());
		}catch (NotFoundException e2) {
			System.err.println("대여 실패 "+e2.getMessage());
		}
		try {
			r=rsm.findbyManagenum(7);
			System.out.println("대여 성공 "+ r.toString());
		}catch (NotFoundException e2) {
			System.err.println("대여 실패 "+e2.getMessage());
		}
		rsm.printAll();
	}
}
