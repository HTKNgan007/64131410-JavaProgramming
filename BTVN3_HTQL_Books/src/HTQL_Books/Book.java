package HTQL_Books;

public class Book implements IBook {
	private static int count = 0;
    private int id;
    private String name;
    private String publishDate;
    private String author;
    private String language;
    private float averagePrice;  
    private int[] priceList = new int[5];
    
	public Book(String name, String publishDate, String author, String language) {
		this.id = ++count;
		this.name = name;
		this.publishDate = publishDate;
		this.author = author;
		this.language = language;
	}
    
	@Override
	public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Language: " + language);
        System.out.println("Average Price: " + averagePrice);
        System.out.println();
    }
	
	public void calculate() {
        int sum = 0;
        for (int price : priceList) {
            sum += price;
        }
        this.averagePrice = sum / 5.0f;
    }

    public void setPriceList(int[] prices) {
        if (prices.length == 5) {
            this.priceList = prices;
        } else {
            System.out.println("Price list must have 5 elements");
        }
    }
}
