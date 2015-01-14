
public class Student {
	private int ID;
	private String name;
	private Address adress;
	
	public Student(int ID, String name, Address adress){
		this.ID = ID;
		this.name = name;
		this.adress = adress;
	}
	public String toCsv(){
		CSVBuilder csv = new CSVBuilder();
		csv.append(id).append(name).append(adress);		
		return csv.toString();
	}
	
}
