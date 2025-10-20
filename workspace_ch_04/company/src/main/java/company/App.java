package company;

import company.model.CommisionCompensationModel;
import company.model.Employee;
import company.model.SalariedCompensationModel;

public class App {

	public static void main(String[] args) {
		try {
			Employee[] employees = new Employee[] {
					new Employee("EMP_001", "Salah", "Obeid", new SalariedCompensationModel(15200.0), new RetirementPlanA()),
					new Employee("EMP_002", "Ali", "Otaibi", new CommisionCompensationModel(0.15, 56200.0), new RetirementPlanA()),
					new Employee("EMP_003", "Ramzi", "Obeikan", new SalariedCompensationModel(21500.0), new RetirementPlanB()),
					new Employee("EMP_004", "Ahmed", "Slimani", new CommisionCompensationModel(30.0, 160.0), new RetirementPlanB())
			};
		
			
			for(Employee e: employees ) {
				System.out.printf("%s%n",e.toString());
			}
		} catch (IllegalArgumentException ex) {
			System.out.printf(ex.getMessage());
		}

	}

}
