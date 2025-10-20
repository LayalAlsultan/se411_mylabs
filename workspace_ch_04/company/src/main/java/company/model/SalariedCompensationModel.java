package company.model;

public class SalariedCompensationModel implements ICompensationModel {

	private Double monthlySalary;
	
	public SalariedCompensationModel(Double monthlySalary_p) {
		
		if (monthlySalary_p < 0.0) {
			throw new IllegalArgumentException("Salary cannot be negative");
		}
		
		this.monthlySalary = monthlySalary_p;
	}
	
	@Override
	public Double earnings() {
		return getMonthlySalary();
	}
	
	public Double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(Double monthlySalary_p) {
		if (monthlySalary_p < 0.0) {
			throw new IllegalArgumentException("Salary cannot be negative");
		}
		
		this.monthlySalary = monthlySalary_p;
	}

	@Override
	public String toString() {
		return String.format("Salaried Compensation Model: %nSalary: %.2fSAR%n", getMonthlySalary());
	}


	
}
