package intranet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User implements SendingOrder,Serializable {
	
	private Faculty faculty;
	HashMap<Course,Mark> grades;
	
	private static final long serialVersionUID = 1457045536443677740L;
	{
		grades = new HashMap<Course,Mark>();
		faculty = null;
		
	}
	
	public Student(String lastName, String firstName, String login) {
			super(lastName, firstName, login);
	}
	

	public boolean register(Course course) {
		if(DataBase.courseList.contains(course)) {	
			for(Teacher teacher : DataBase.teacherList) { 
				if(teacher.getStudents().containsKey(course)) {
					teacher.addStudent(this, course);
					grades.put(course,new Mark());
					return true;
				}
				
			}
			
		}
		
		return false;
	}
	
	public ArrayList<Course> viewCourse() {
	    return DataBase.courseList;
	}
	
	public Teacher viewTeacher(String login) {
	    for(Teacher teacher : DataBase.teacherList) {
	    	if(teacher.getLogin().equals(login)) {
	    		return teacher;
	    	}
	    }
	    return null;
	}
	
	public void  viewTranscript() {
	    //return null;
	}
	
	public void sendOrderOR(Order order) {
		OR.orders.add(order);
	}
	
	
	public void sendOrderToEx(Order order) {
	    Executor.orders.add(order);
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public HashMap<Course,Mark> getGrades() {
		return grades;
	}
	public void setGrades(HashMap<Course,Mark> grades) {
		this.grades = grades;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
	
		result = prime * result + ((grades == null) ? 0 : grades.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		if (faculty != other.faculty) {
			return false;
		}
	
		if (grades == null) {
			if (other.grades != null) {
				return false;
			}
		} else if (!grades.equals(other.grades)) {
			return false;
		}
		return true;
	}


	
}

