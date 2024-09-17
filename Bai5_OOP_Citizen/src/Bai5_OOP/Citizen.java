package Bai5_OOP;

public class Citizen {
	//Field
	private String id;
	private String name;
	private short year;
	private String genner;
	private String nation;
	
	public Citizen(String id, String name, short year, String genner, String nation) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.genner = genner;
		this.nation = nation;
	}

	public Citizen() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public String getGenner() {
		return genner;
	}

	public void setGenner(String genner) {
		this.genner = genner;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Override
	public String toString() {
		String srt = "Citizen [id=" + id + ", name=" + name + "]";
		return srt;
	}
	
	
}
