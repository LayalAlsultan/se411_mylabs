package employees.model;

public class Employee {
	private String id;
	private String fname;
	private String lname;
	
	private CompensationModel compensationModel;
	
	public Employee(String id_p, String fname_p, String lname_p, CompensationModel compensationModel) {
		this.id = id_p;
		this.fname = fname_p;
		this.lname = lname_p;
		this.compensationModel = compensationModel;
	}
	
	/** Abstract method should be implemented by sub-classes */
	public Double earnings() {
		return this.compensationModel.earnings();
	}
	
	public Double getPaymentAmount() {
		return earnings();
	}
	
	@Override
	public String toString() {
		return String.format("%s %s%nEmployee id: %s", getFname(), getLname(), getId());
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
