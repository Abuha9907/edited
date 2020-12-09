package intranet;
import java.util.ArrayList;

public interface ManageCourse {

	public ArrayList<Course> viewCourses();
	
	public void addCourseFile(Course course, CourseFile file);
	
	public boolean deleteCourseFile(Course course, CourseFile file);
}

