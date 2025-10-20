package clonable.model;

import java.util.Date;

public class House implements Cloneable, Comparable<House> {
	private int id;
	private double area;
	private Date whenBuilt;


	public House(int id, double area) {
		this.id = id;
		this.area = area;
		whenBuilt = new java.util.Date();
	}
	
	@Override
	public Object clone() {
//		try {
			House copy = new House(this.id, this.area);
			copy.setWhenBuilt((Date)this.whenBuilt.clone());
			return copy;
			//return super.clone();
//		}
//		catch (CloneNotSupportedException ex) {
//		  return null;
//		}
	}
	
	@Override 
	public int compareTo(House o) {
		if (area > o.area) return 1;
		else if (area < o.area)  return -1;
		else return 0;
	} 

	public java.util.Date getWhenBuilt() {
		return whenBuilt;
	}
	
	public void setWhenBuilt(java.util.Date whenBuilt) {
		this.whenBuilt = whenBuilt;
	}
}
