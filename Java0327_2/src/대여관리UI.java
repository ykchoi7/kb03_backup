import java.util.Scanner;

import rentshop.vo.book;
import rentshop.vo.rent;
import rentshop.vo.video;

public class 대여관리UI {
	public static void main(String[] args) throws NotFoundException, ManageExistException {
		대여관리UI ui=new 대여관리UI();
		ui.mainMenu();
		
	}
	private Scanner sc=new Scanner(System.in);
	private RentShopManager rsm=new RentShopManager();
	public void mainMenu() throws NotFoundException, ManageExistException {
		while(true) {
			
			System.out.println("** 도서 대여 관리 프로그램 vo.1 **");
			System.out.println("[총등록수: "+rsm.getCount());
			System.out.println("1)도서등록 2)비디오등록 3)대여 4)반납 5)전체출력 6)대여료수정 7)삭제 99)이전메뉴");
			System.out.println("메뉴 변호> ");
			int menu=Integer.parseInt(sc.next());
			if(menu==1) {
				도서등록메뉴();
			}
			else if(menu==2) {
				비디오등록메뉴();
			}
			else if(menu==3) {
				대여();
			}
			else if(menu==4) {
				
				반납();
			}
			else if(menu==5) {
				전체출력();
			}
			else if(menu==6) {
				대여료수정();
			}
			else if(menu==7) {
				삭제();
			}
			else if(menu==99) break;
		}
	
	}
	



	private void 도서등록메뉴() throws ManageExistException {
		 System.out.println("** 도서등록 **\r\n"
		 		+ "1)도서정보입력 99)이전메뉴");
		 int cmd=sc.nextInt();
		 if(cmd==99) return;
		 book b=new book();
		 System.out.print("등록할 도서관리번호> ");
		 b.setManagenum(sc.nextInt());
		 System.out.print("등록할 도서제목> ");
		 b.setTitle(sc.next());
		 System.out.print("등록할 도서저자> ");
		 b.setWritter(sc.next());
		 System.out.print("등록할 페이지수> ");
		 b.setPage(sc.nextInt());
		 System.out.print("등록할 도서대여료> ");
		 b.setFee(sc.nextInt());
		 System.out.print("등록할 도서대여상태> ");
		 b.setIsborrow(sc.nextBoolean());
		 rsm.add(b);
		 System.out.println("--> 도서가 등록되었습니다.");
		 
	}
	
	private void 비디오등록메뉴() throws ManageExistException {
		System.out.println("** 비디오등록 **\r\n"
				+ "1)비디오정보입력 99)이전메뉴");
		int cmd=sc.nextInt();
		if(cmd==99) return;
		video v=new video();
		System.out.print("등록할 비디오 관리번호> ");
		v.setManagenum(sc.nextInt());
		System.out.print("등록할 비디오 제작사> ");
		v.setFirm(sc.next());
		System.out.print("등록할 비디오 제목> ");
		v.setTitle(sc.next());
		System.out.print("등록할 비디오 상영시간> ");
		v.setTime(sc.nextInt());
		System.out.print("등록할 비디오 대여료> ");
		v.setFee(sc.nextInt());
		System.out.print("등록할 비디오 대여상태> ");
		v.setIsborrow(sc.nextBoolean());
		rsm.add(v);
		System.out.println("--> 비디오가 등록되었습니다.");
		
	}
	private void 대여() throws NotFoundException {
		System.out.println("** 대여 **\r\n"
				+ "1)관리 번호 입력 99)이전메뉴");
		int cmd=sc.nextInt();
		if(cmd==99) return;
		int managenum=sc.nextInt();
		rsm.Borrow(managenum);
	}
	
	private void 반납() throws NotFoundException {
		System.out.print("관리 번호 입력> ");
		int managenum=sc.nextInt();
		rent r=rsm.findbyManagenum(managenum);;
		r.setIsborrow(false);//반납
	}
	
	private void 대여료수정() throws NotFoundException {
		System.out.print("관리 번호 입력> ");
		int managenum=sc.nextInt();
		System.out.print("대여료 입력> ");
		int newfee=sc.nextInt();
		
		rent r=rsm.findbyManagenum(managenum);;
		r.setFee(newfee);//반납
	}
	
	private void 삭제() throws NotFoundException {
		System.out.print("관리 번호 입력> ");
		int managenum=sc.nextInt();
		
		rsm.delete(managenum);
	
	}
	
	private void 전체출력() {
		rsm.printAll();
	}
	
}
