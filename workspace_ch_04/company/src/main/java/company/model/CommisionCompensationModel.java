package company.model;


public class CommisionCompensationModel implements ICompensationModel {
	
	private Double commissionRate;
	private Double grossSales;
	
	public CommisionCompensationModel(Double commissionRate_p, Double grossSales_p) {
		if (commissionRate_p < 0.0) {
			throw new IllegalArgumentException("Commission rate cannot be negative");
		}
		if (grossSales_p < 0.0) {
			throw new IllegalArgumentException("Gross sales cannot be negative");
		}
		
		this.commissionRate = commissionRate_p;
		this.grossSales = grossSales_p;
	}
	
	@Override
	public Double earnings() {
		return getCommissionRate() * getGrossSales();
	}

	@Override
	public String toString() {
		return String.format("Commission Compensation Model: %nCommission rate: %.2f%nGross sales: %.2f%n"
				, getCommissionRate(), getGrossSales());
	}
	
	public Double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(Double commissionRate_p) {
		if (commissionRate_p < 0.0) {
			throw new IllegalArgumentException("Commission rate cannot be negative");
		}
		if (commissionRate_p > 1.0) {
			throw new IllegalArgumentException("Commission rate cannot be more than 1");
		}
		this.commissionRate = commissionRate_p;
	}

	public Double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(Double grossSales_p) {
		if (grossSales_p < 0.0) {
			throw new IllegalArgumentException("Gross sales cannot be negative");
		}
		this.grossSales = grossSales_p;
	}
}
