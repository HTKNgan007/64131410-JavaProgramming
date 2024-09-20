package QLTinTuc;

public class News implements INews {
	private int ID;
    private String Title;
    private String PublishDate;
    private String Author;
    private String Content;
    private float AverageRate;
    private int[] RateList = new int[3];
    		
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public float getAverageRate() {
		return AverageRate;
	}
	
	@Override
	public void Display() {
		// TODO Auto-generated method stub
		System.out.println("Title: " + Title);
        System.out.println("Publish Date: " + PublishDate);
        System.out.println("Author: " + Author);
        System.out.println("Content: " + Content);
        System.out.println("Average Rate: " + AverageRate);
		
	}
	//Tính trung bình cộng
	public void Calculate() {
		int sum = 0;
		for(int rate : RateList) {
			sum += rate;
		}
		this.AverageRate = (float)sum / RateList.length;
	}
	
	public void setRateList(int[] rateList) {
        this.RateList = rateList;
    }
	
}









