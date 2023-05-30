
public class ManageExistException extends Exception {
	
	public ManageExistException(int managenum) {
		super("관리 번호 중복 "+ managenum);
	}
	
}
