package intranet;
//fields - отдельно приват и т.д
// конструктор  -  где ее нету ? 
// init
// методы которые мы придумали
// геттеры сеттеры
// hash, equals  -- где ее нету?
// toString  -- где ее нету ?
public class Admin {

	private  String login ;
	private String password;
	{
		login = "bestPerson";
		password = "iLoveMadina";
	}
	
	public Admin() {
		
	}
	
	public void addUser(String firstName, String lastName, String login, userType userType) {
		switch(userType){
			case STUDENT:
				addStudent(firstName,lastName,login);
				break;
			case TEACHER:
				addTeacher(firstName,lastName,login);
				break;
			case OR:
				addManager(firstName,lastName,login);
				break;
			case EXECUTOR:
				addExecutor(firstName,lastName,login);
				break;
		}
				
	}
	
	private boolean addStudent(String firstName, String lastName, String login) {
		Student student = new Student(firstName,lastName, login);
		if(DataBase.studentList.contains(student)) 
			return false;
		else {
			DataBase.studentList.add(student);
				return true;
		}
	}
	
	private boolean addManager(String firstName, String lastName, String login) {
		OR or = new OR(firstName,lastName, login);
		if(DataBase.managerList.contains(or)) 
			return false;
		else {
			DataBase.managerList.add(or);
			return true;
		}
		
	}
	
	private boolean addExecutor(String firstName, String lastName, String login) {
		Executor executor = new Executor(firstName,lastName, login);
		if(DataBase.executorList.contains(executor)) 
			return false;
		else {
			DataBase.executorList.add(executor);
			return true;
		}
		
	}
	
	private boolean addTeacher(String firstName, String lastName, String login) {
		Teacher teacher = new Teacher(firstName,lastName, login);
		if(DataBase.teacherList.contains(teacher)) 
			return false;
		else {
			DataBase.teacherList.add(teacher);
			return true;
		}
		
	}
	
	public boolean deleteUser(String login) {
		for(Student student : DataBase.studentList) {
			if(student.getLogin().equals(login)) {
				DataBase.studentList.remove(student);
					return true;
			}
		}
		for(Executor executor : DataBase.executorList) {
			if(executor.getLogin().equals(login)) {
				DataBase.executorList.remove(executor);
					return true;
			}
		}
		for(Teacher teacher : DataBase.teacherList) {
			if(teacher.getLogin().equals(login)) {
				DataBase.teacherList.remove(teacher);
					return true;
			}
		}
		for(OR or : DataBase.managerList) {
			if(or.getLogin().equals(login)) {
				DataBase.managerList.remove(or);
					return true;
			}
		}
		
	    return false;
	}
	
	public void updateInfo(String login) {

	}
	

	public void setLogin(String login) {
		this.login = login;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Admin)) {
			return false;
		}
		Admin other = (Admin) obj;
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
				return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
				return false;
		}
				return true;
	}
}

