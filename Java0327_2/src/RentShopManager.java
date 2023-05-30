import java.util.ArrayList;

import rentshop.vo.book;
import rentshop.vo.rent;
import rentshop.vo.video;

public class RentShopManager {
	private int bookcnt=0;
	private int vidcnt=0;
	
	private ArrayList<rent> al= new ArrayList<>();
	
	public void add(book b) throws ManageExistException {
		for (rent r : al) {
			if(r.getManagenum()==b.getManagenum())
				throw new ManageExistException(b.getManagenum());
		}
		al.add(b);
		bookcnt++;
	}
	public void add(video v) throws ManageExistException {
		for (rent r : al) {
			if(r.getManagenum()==v.getManagenum())
				throw new ManageExistException(v.getManagenum());
		}
		al.add(v);
		vidcnt++;
	}
	
	public int getCount() { //총
		return al.size();
	}
	
	public int getVidcount() {
		return vidcnt;
	}
	public int getBookcount() {
		return bookcnt;
	}
	public void Borrow(int managenum) throws NotFoundException {
		boolean isfound=false;
		for (rent r : al) {
			if(r.getManagenum()==managenum)
				{
				isfound=true;
				r.setIsborrow(true);
				}
		}
		if(isfound==false) throw new NotFoundException(managenum);
		
	}

	public rent findbyManagenum(int managenum) throws NotFoundException {
	
		for (rent r : al) {
			if(r.getManagenum()==managenum)
			{
				return r;

			}
		}
		throw new NotFoundException(managenum);
		
	}
	
	public void delete(int managenum) throws NotFoundException {
		rent r=findbyManagenum(managenum);
		al.remove(al.indexOf(r)); 
		
	}
	
	public void printAll() {
		for (rent r : al) {
			System.out.println(r.toString());
			
		}
	}
	
}
