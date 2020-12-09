package intranet;
import java.io.Serializable;

public class New implements Serializable{
	private static final long serialVersionUID = 1L;

	public String Title;

    public String Text;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Text == null) ? 0 : Text.hashCode());
		result = prime * result + ((Title == null) ? 0 : Title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof New)) {
			return false;
		}
		New other = (New) obj;
		if (Text == null) {
			if (other.Text != null) {
				return false;
			}
		} else if (!Text.equals(other.Text)) {
			return false;
		}
		if (Title == null) {
			if (other.Title != null) {
				return false;
			}
		} else if (!Title.equals(other.Title)) {
			return false;
		}
		return true;
	}
}

