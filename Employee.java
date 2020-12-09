package intranet;

import java.io.Serializable;

public abstract class Employee extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int salary;
	
	public Employee(String lastName, String firstName, String login) {
		super(lastName, firstName, login);
		this.salary = 200000;
	}
	
	

    public int getSalary() {
        return salary;
    }
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int hashCode() {
		return super.hashCode() + salary;
	}
	
	public boolean equals(Object obj) {
		if(!super.equals(obj)) 
			return false;
		Employee p = (Employee)obj;
		return salary == p.salary; 
		}
}

