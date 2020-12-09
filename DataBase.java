package intranet;
import java.util.*;
import java.io.*;

public class DataBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public DataBase() {
		getData();
	}
	 
	private static final String EXCEPT_CLASS = "Class not found!";
    private static final String EXCEPT_FILE = "File not found!";
    private static final String EXCEPT_IO = "Input / Output exception!";
	
    private static final String TEACHERS = "teacherLIST.out";
    private static final String STUDENTS = "studentLIST.out";
    private static final String ORMANAGERS = "orLIST.out";
    private static final String EXECUTORS = "executorLIST.out";
    private static final String NEWS = "newLIST.out";
    //public static final String log = "logs.txt";
    
    public static ArrayList<Student> studentList  = new ArrayList<Student>() ;
    public static ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
    public static ArrayList<OR> managerList = new ArrayList<OR>();
    public static ArrayList<Executor> executorList = new ArrayList<Executor>();
    public static ArrayList<Course> courseList = new ArrayList<Course>();
    public static final String path = "\"C:/Users/Asus/eclipse-workspace/work/\";";
    public static ArrayList<New> newList = new ArrayList<New>();
    
    
    private static void getData() {
    	getStudents();
    	getTeachers();
    	getManagers();
    	getExecutors();
    	getNews();
    }
   
    //deserialization
    private static void getNews() {
    	
    	try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EXECUTORS));

            newList = (ArrayList<New>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(NEWS + ": " + EXCEPT_CLASS);
        }
        catch (FileNotFoundException e) {
            System.out.println(NEWS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(NEWS + ": " + EXCEPT_IO);
        }
	}
	
    private static void getExecutors() {
    	  try {
              ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EXECUTORS));

              executorList = (ArrayList<Executor>) ois.readObject();

              ois.close();

          }
          catch (ClassNotFoundException e) {
              System.out.println(EXECUTORS + ": " + EXCEPT_CLASS);
          }
          catch (FileNotFoundException e) {
              System.out.println(EXECUTORS + ": " + EXCEPT_FILE);
          }
          catch (IOException e) {
              System.out.println(EXECUTORS + ": " + EXCEPT_IO);
          }
		
	}
	
    private static void getManagers() {
		try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ORMANAGERS));

            managerList = (ArrayList<OR>) ois.readObject();

            ois.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + EXCEPT_CLASS);
        }
        catch (FileNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(ORMANAGERS + ": " + EXCEPT_IO);
        }
		
	}
	
    private static void getTeachers() {
		try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TEACHERS));

            teacherList = (ArrayList<Teacher>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(TEACHERS + ": " + EXCEPT_CLASS);
        }
        catch (FileNotFoundException e) {
            System.out.println(TEACHERS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(TEACHERS + ": " + EXCEPT_IO);
        }
		
	}
	
    
	
	//serialization - add new object to file
	
    private static void saveNews() {
    	try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(NEWS));

            oot.writeObject(newList);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(NEWS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(NEWS + ": " + EXCEPT_IO);
        }
		
	}
    
    
    private static void saveExecutors() {
		try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(EXECUTORS));

            oot.writeObject(executorList);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(EXECUTORS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(EXECUTORS + ": " + EXCEPT_IO);
        }
		
	}
	
    private static void saveManagers() {
		try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(ORMANAGERS));

            oot.writeObject(managerList);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(ORMANAGERS + ": " + EXCEPT_IO);
        }
		
	}
	
    private static void saveTeachers() {
		try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(TEACHERS));

            oot.writeObject(teacherList);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(TEACHERS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(TEACHERS + ": " + EXCEPT_IO);
        }
		
	}
	
    private static void saveStudents() { 
		try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(STUDENTS));

            oot.writeObject(studentList);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(STUDENTS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(STUDENTS + ": " + EXCEPT_IO);
        }
		
	}
    
    public static void getStudents() {
		try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STUDENTS));

            studentList = (ArrayList<Student>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(STUDENTS + ": " + EXCEPT_CLASS);
        }
        catch (FileNotFoundException e) {
            System.out.println(STUDENTS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(STUDENTS + ": " + EXCEPT_IO);
        }
		
	}
    
    public static void saveData() {
		saveStudents();
		saveTeachers();
		saveManagers();
		saveExecutors();
		saveNews();
		
    }

    public static void addLog(String text) {
    }
}

