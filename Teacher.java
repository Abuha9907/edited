package intranet;

import java.io.*;
import java.util.*;


public class Teacher extends Employee implements SendingOrder, ManageCourse,Serializable {
	private static final long serialVersionUID = 1L;
	private  Title title ;
	private  Faculty faculty;
	private  ArrayList<Message> messages;
	private  HashMap<Course, Vector<Student>>  students ;
	{
		messages = new ArrayList<Message>();
		students = new HashMap<Course, Vector<Student>>();
	}
	public Teacher(String lastName, String firstName, String login) {
			super(lastName, firstName, login);
			
		}
	
	
	public void putMark(Course course, Student student, int value , MarkType markType) {
		for(Course key : students.keySet()) {
			if(key.equals(course)) {
				for(Student s :students.get(course)) {
					if(s.equals(student)) {
						switch(markType) {
							case FIRST_ATT:
								s.grades.get(course).setFirst(value);
								break;
							case  SEC_ATT:
								s.grades.get(course).setSecond(value);
								break;
							case FINAL:
								s.grades.get(course).setThird(value);
								break;
						}
					}
				}
			}
		}
	}
	
	public void addCourse(Course course) {
		if(DataBase.courseList.contains(course)) {
			students.put(course, new Vector<Student>());
		}
	}
	
	public void addStudent(Student student,Course course) {
		if(students.containsKey(course)) {
			students.get(course).add(student);
		}
	}
	
	public ArrayList<Course> viewCourses() {
	    return DataBase.courseList;
	}
	
	public void addCourseFile(Course course, CourseFile file) {
		for(Course c : DataBase.courseList) {
			if(c.equals(course)) {
				c.addCourseFile(file);
			}
		}
	}
	
	public boolean deleteCourseFile(Course course, CourseFile file) {
		for(Course key : students.keySet()) {
			if(key.equals(course)) {
				key.deleteCourseFile(file);
				return true;
			}
		}
		return false;
		
	}
	
	
	@Override
	public void sendOrderOR(Order order) {
		OR.orders.add(order);
		
	}
	@Override
	public void sendOrderToEx(Order order) {
		Executor.orders.add(order);
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public ArrayList<Message> getMessages() {
		return messages;
	}
	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	public HashMap<Course, Vector<Student>> getStudents() {
		return students;
	}
	public void setStudents(HashMap<Course, Vector<Student>> students) {
		this.students = students;
	}
	public void receiveMessage(Message message) {
		this.messages.add(message);
	}
	@Override
    public String toString() {
        String facultyInfo;
        try {
            facultyInfo = "Faculty: " + faculty.toString() + '\n';
        }
        catch (Exception e) {
            facultyInfo = "";
        }
        
       
        return "Teacher\n" + super.toString() + facultyInfo;
    }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((messages == null) ? 0 : messages.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (!(obj instanceof Teacher)) {
			return false;
		}
		Teacher other = (Teacher) obj;
		if (faculty != other.faculty) {
			return false;
		}
		if (messages == null) {
			if (other.messages != null) {
				return false;
			}
		} else if (!messages.equals(other.messages)) {
			return false;
		}
		if (students == null) {
			if (other.students != null) {
				return false;
			}
		} else if (!students.equals(other.students)) {
			return false;
		}
		if (title != other.title) {
			return false;
		}
		return true;
	}
}

