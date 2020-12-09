package intranet;

public class Mark {
	
	int first;  
    int second;  
    int third;  //final 
    
    public Mark() {
    	this.first = 0;
    	this.second = 0;
    	this.third = 0;
    }
    
	public int getFirst() {
		return first;
	}


		

	public void setFirst(int first) {
		this.first = first;
	}




	public int getSecond() {
		return second;
	}




	public void setSecond(int second) {
		this.second = second;
	}




	public int getThird() {
		return third;
	}




	public void setThird(int third) {
		this.third = third;
	}
	
	public String toString() {
		return "";
	}

	public int totalMark() {
		return first+ second + third;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + first;
		result = prime * result + second;
		result = prime * result + third;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Mark)) {
			return false;
		}
		Mark other = (Mark) obj;
		if (first != other.first) {
			return false;
		}
		if (second != other.second) {
			return false;
		}
		if (third != other.third) {
			return false;
		}
		return true;
	}
	
	public String toString(int value) { //(0-100)
		if(value > 96) return "A+";
		
		return "";
	}
	
	
	
}

