package intranet;
import java.io.*;

import java.util.*;

public class Executor extends Employee implements  Serializable {
	
	public static TreeSet<Order> orders;
	private static final long serialVersionUID = 1L;
	private static String PATH = "";
	private static String ORDERS= "";
	private static final String EXCEPT_CLASS = "Class not found!";
    private static final String EXCEPT_FILE = "File not found!";
    private static final String EXCEPT_IO = "Input / Output exception!";
    
	static {
		getOrdersFile();
		orders = new TreeSet<Order>();
	}
 
	public Executor(String lastName, String firstName, String login) {
		super(lastName, firstName, login);
	}

	

    public ArrayList<Order> viewOrders(OrderStatus status) {
    	ArrayList<Order> list = new ArrayList<Order>();
		for(Order order : orders) {
			if(order.getStatus().equals(status)) {
				list.add(order);
			}
		}
		return list;
    }

   
    public void changeOrderStatus(Order order, OrderStatus status) {
    	for(Order o : orders) {
    		if(o.equals(order)) {
    			o.setStatus(status);
    		}
    	}
    }

	@SuppressWarnings("unchecked")
	public static void getOrdersFile() {
		
	        try {
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ORDERS));
	            
	            orders = (TreeSet<Order>) ois.readObject();

	            ois.close();

	        }
	        catch (ClassNotFoundException e) {
	            System.out.println(ORDERS + ": " + EXCEPT_CLASS);
	        }
	        catch (FileNotFoundException e) {
	            System.out.println(ORDERS + ": " + EXCEPT_FILE);
	        }
	        catch (IOException e) {
	            System.out.println(ORDERS + ": " + EXCEPT_IO);
	        }
	    
		
	}

	public void saveOrderFile() {
		
		
	}

	public static TreeSet<Order> getOrders() {
		return orders;
	}

	public static void setOrders(TreeSet<Order> orders) {
		Executor.orders = orders;
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
		if (!(obj instanceof Executor)) {
			return false;
		}
		return true;
	}
}

