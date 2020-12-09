package intranet;

import java.util.HashMap;

public class test {

	public static void main(String[] args) {
		Student s = new Student("Zhan","Kadyrov","ooo");
		Teacher t = new Teacher("Peri","Okaeva","kkk");
		Course c = new Course("4567","Math",3);
		DataBase db = new DataBase();
		DataBase.studentList.add(s);
		DataBase.teacherList.add(t);
		DataBase.courseList.add(c);
		t.addCourse(c);
		s.register(c);
		//grades course mark
		t.putMark(c, s, 20, MarkType.FIRST_ATT);
		t.putMark(c, s, 30, MarkType.SEC_ATT);
		t.putMark(c, s, 40, MarkType.FINAL);
		System.out.print(s.getGrades().get(c).totalMark());
		
	}
	

}
