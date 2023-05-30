package 비디오도서대여점관리;

import java.util.Scanner;

public class 대여관리UI {
	public static void main(String[] args) {
		대여관리UI ui = new 대여관리UI();
		ui.mainMenu();
	}
	
	private VideoManager vm = new VideoManager();
	private BookManager_해시맵사용 bm = new BookManager_해시맵사용();
	private Scanner sc = new Scanner(System.in);
	/* 값 입력 받을 때
	 * String str1 = sc.next();
	 * int num1 = sc.nextInt();
	 * double num2 = sc.nextDouble();
	 */

	private void mainMenu() {
		while (true) {
			System.out.println("**도서 대여 프로그램 vo.1**");
			System.out.println("총 등록수: " + (vm.getCount()+bm.getCount()));
			System.out.println("1)도서등록 2)비디오등록 3)대여) 4)반납 5)전체출력 99)종료");
			System.out.println("메뉴번호> ");
			int menu = Integer.parseInt(sc.next());
			if (menu == 1)
				도서등록();
			else if (menu == 2)
				비디오등록();
			else if (menu == 3)
				대여();
			else if (menu == 4)
				반납();
			else if (menu == 5)
				전체출력();
			else if (menu == 99) {
				break;
			}
		}
	}

	private void 전체출력() {
		vm.printAll();
		bm.printAll();
	}

	private void 반납() {
		System.out.println("**반납등록**");
		System.out.println("반납제품관리번호> ");
		int number = sc.nextInt();
		try {
			MyVideo v = vm.findByNumber(2222);
            System.out.println("검색성공:"+v.toString());
            v.setStatus("대여가능");
            vm.update(v);
            System.out.println("대여상태 업데이트:"+v.toString());
		} catch (NumberNotFoundException nf) {
			nf.printStackTrace();
			System.err.println("관리번호 찾을 수 없음: " + nf.getMessage());
		}
		System.out.println("반납이 완료되었습니다");
	}

	private void 대여() {
		System.out.println("**대여등록**");
		System.out.println("대여제품관리번호> ");
		int number = sc.nextInt();
		try {
			MyVideo v = vm.findByNumber(2222);
            v.setStatus("대여중");
            vm.update(v);
            System.out.println("대여상태 업데이트:"+v.toString());
		} catch (NumberNotFoundException nf) {
			nf.printStackTrace();
			System.err.println("관리번호 찾을 수 없음: " + nf.getMessage());
		}
		System.out.println("대여가 완료되었습니다");
	}

	private void 비디오등록() {
		System.out.println("** 비디오등록 **");
		System.out.println("1)비디오정보입력 99)이전메뉴");
		System.out.println("메뉴번호> ");
		int register = Integer.parseInt(sc.next());
		if (register == 1)
			비디오정보입력();
		if (register == 99);
			이전메뉴();
	}
	
	//비디오
	private void 비디오정보입력() {
		System.out.println("등록할 비디오관리번호> ");
		int number = Integer.parseInt(sc.next());
		System.out.println("등록할 비디오제목> ");
		String title = sc.next();
		System.out.println("등록할 비디오제작사> ");
		String company = sc.next();
		System.out.println("등록할 비디오대여상태> ");
		String status = sc.next();
		System.out.println("등록할 비디오상영시간> ");
		String time = sc.next();
		System.out.println("등록할 비디오대여료> ");
		int cost = Integer.parseInt(sc.next());
		System.out.println("==> 도서가 등록되었습니다.");
		MyVideo mv1 = new MyVideo(number, title, cost, status, time, company);
		//목록에 저장
		try {
			vm.add(mv1);
		} catch (NumberExistException ne) {
			System.out.println("정보등록오류: " + ne.getMessage());
		}
		
	}

	private void 도서등록() {
		System.out.println("** 도서등록 **");
		System.out.println("1)도서정보입력 99)이전메뉴");
		System.out.println("메뉴번호> ");
		int register = Integer.parseInt(sc.next());
		if (register == 1)
			정보입력();
		if (register == 99);
			이전메뉴();
	}

	private void 이전메뉴() {
		System.out.println();
		mainMenu();
	}

	//도서
	private void 정보입력() {
		System.out.println("등록할 도서관리번호> ");
		int number = Integer.parseInt(sc.next());
		System.out.println("등록할 도서제목> ");
		String title = sc.next();
		System.out.println("등록할 도서저자> ");
		String writer = sc.next();
		System.out.println("등록할 도서대여상태> ");
		String status = sc.next();
		System.out.println("등록할 도서페이지수> ");
		String page = sc.next();
		System.out.println("등록할 도서대여료> ");
		int cost = Integer.parseInt(sc.next());
		System.out.println("==> 도서가 등록되었습니다.");
		MyBook mb1 = new MyBook(number, title, cost, status, writer, page);
		//목록에 저장
		try {
			bm.add(mb1);
		} catch (NumberExistException ne) {
			System.out.println("정보등록오류: " + ne.getMessage());
		}
	}
}
