package intranet;

import java.util.ArrayList;
import java.util.TreeSet;

public class OR extends Employee implements ManageOrder, SearchInfo {

	private static final long serialVersionUID = 1L;
	public OR(String lastName, String firstName, String login) {
			super(lastName, firstName, login);
		}
	
	public static  TreeSet<Order> orders;
	
	public void  addCourse(Course course) {
	    
	}
	
	public void getStudentsByGpa() {
	}
	
	public void getStudentByName() {
	}
	
	public void getTeachersByName() {
	}
	
	public void  addNew(New n) {
		DataBase.newList.add(n);
	}
	
	public boolean sendMesage(String login,Message message) {
		for(Teacher teacher : DataBase.teacherList) {
			if(teacher.getLogin().equals(login)) {
				teacher.receiveMessage(message);
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public ArrayList<Order> viewOrders(OrderStatus status) {
		ArrayList<Order> list = new ArrayList<Order>();
		for(Order order : orders) {
			if(order.getStatus().equals(status)) {
				list.add(order);
			}
		}
		return list;
	}
	@Override
	public void changeOrderStatus(Order order, OrderStatus status) {
		// TODO Auto-generated method stub
		
	}
	public static TreeSet<Order> getOrders() {
		return orders;
	}
	public static void setOrders(TreeSet<Order> orders) {
		OR.orders = orders;
	}
	
	public void getOrdersFile() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void saveOrderFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof OR)) {
			return false;
		}
		return true;
	}
}

