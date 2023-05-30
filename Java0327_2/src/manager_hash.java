import java.util.Collection;
import java.util.HashMap;

import rentshop.vo.book;
import rentshop.vo.rent;
import rentshop.vo.video;

public class manager_hash {
	private HashMap<Integer, rent> map=new HashMap<>();

	public void add(video v) throws ManageExistException {
		rent r=map.get(v.getManagenum());
		if(r!=null)
			throw new ManageExistException(r.getManagenum());
		map.put(v.getManagenum(), v);
	}
	public void add(book b) throws ManageExistException {
		rent r=map.get(b.getManagenum());
		if(r!=null)
			throw new ManageExistException(r.getManagenum());
		map.put(b.getManagenum(), b);
	}
	
	public int getCount() {
		return map.size();
	}
	public int getBCount() {
		Collection<rent> values=map.values();
		int bcount=0;
		for (rent r : values) {
			if(r instanceof book) bcount++;
		}
		return bcount;
	}
	public int getVCount() {
		Collection<rent> values=map.values();
		int vcount=0;
		for (rent r : values) {
			if(r instanceof video) vcount++;
		}
		return vcount;
	}
	
	public video findvideo(int managenum) throws NotFoundException,InvalidTypeException
	{
		rent r=map.get(managenum);
		if(r==null) throw new NotFoundException(managenum);
		if(r instanceof book) throw new InvalidTypeException("도서 타입");

		
		
	}
	public void borrow_vid(int managenum)
		throws NotFoundException,InvalidTypeException
	{
			
	}
	public void printAll() {
		System.out.println("** 전체 출력 **");
		Collection<rent> values=map.values();
		for (rent r : values) {
			System.out.println(r);
		}
	}
}
