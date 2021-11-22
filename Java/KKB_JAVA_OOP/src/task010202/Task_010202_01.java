package task010202;

public class Task_010202_01 {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.setTitle("The little prince");
		book1.setPagenum(211);
		book1.show();

	}

}

class Book{
	private String title;
	private int pageNum;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPagenum() {
		return pageNum;
	}

	public void setPagenum(int pagenum) {
		if (pagenum < 200) {
			this.pageNum = 200;
			System.out.println("The number of page must be over 200. It's already 200.");
		}
		this.pageNum = pagenum;
		
	}
	
	public void show() {
		System.out.println("The name of book:"+title);
		System.out.println(title+" has "+pageNum+" pages.");
	}
}