package company.model;

public class Employee {

	private String id;
	private String fname;
	private String lname;
	private ICompensationModel compensationModel;
	private IRetirementPlan retirementPlan;
	

	public Employee(String id_p, String fname_p, String lname_p, ICompensationModel compensationModel) {
		this.id = id_p;
		this.fname = fname_p;
		this.lname = lname_p;
		this.compensationModel = compensationModel;
	}
	
	public Double earnings() {
		return getCompensationModel().earnings();
	}
	
	public Double getPaymentAmount() {
		return earnings();
	}
	
	@Override
	public String toString() {
		return String.format("%s %s%nEmployee id: %s%n%s%n", getFname(), getLname(), getId(), getCompensationModel().toString());
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
	
	public ICompensationModel getCompensationModel() {
		return compensationModel;
	}
	
	public void setCompensationModel(ICompensationModel compensationModel) {
		this.compensationModel = compensationModel;
	}
}
