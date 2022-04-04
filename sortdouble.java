
public class sortdouble {
	
	public double name;
	public sortdouble previous = null;
	public sortdouble next = null;
	int size = 1;
	
	public sortdouble(double n) {
		name = n;
	}
	
	public void add(sortdouble s) throws Exception {
		if(this.name > s.name) {
			if(this.previous == null) {
				this.previous = s; s.next = this;
			}
			else {
				sortdouble temp = this;
				while(temp.name > s.name && temp.previous != null) {
					temp = temp.previous;
				}
				if(temp.previous == null) {
					temp.previous = s; s.next = temp;
				}
				else {
					s.previous = temp; s.next = temp.next; temp.next.previous = s; temp.next = s;
				}
			}
			this.size++;
		}
		else if(this.name < s.name) {
			if(this.next == null) {
				this.next = s; s.previous = this;
			}
			else {
				sortdouble temp = this;
				while(temp.name < s.name && temp.next != null) {
					temp = temp.next;
				}
				if(temp.next == null) {
					temp.next = s; s.previous = temp;
				}
				else {
					s.next = temp; s.previous = temp.previous; temp.previous.next = s; temp.previous = s;
				}
			}
			this.size++;
		}
	}
	
	public String toString() {
		return String.valueOf(name);
	}
	
	public int size() {
		return size;	
	}
}
