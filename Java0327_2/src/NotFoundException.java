
public class NotFoundException extends Exception {
	public NotFoundException(int managenum) {
		super("관리 번호 Not Found "+managenum);
	}
}
