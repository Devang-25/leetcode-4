package AlgorithmDSLeetCode;

public class ListNodeObject {
	  //*** fields ***
	    private Object data;
	    private ListNodeObject next;

	  //*** methods ***
	    // 2 constructors
	    public ListNodeObject(Object d) {
		this(d, null);
	    }

	    public ListNodeObject(Object d, ListNodeObject n) {
		data = d;
		next = n;
	    }
	    
	    // access to fields
	    public Object getData() {
	        return data;
	    }

	    public ListNodeObject getNext() {
	        return next;
	    }

	    // modify fields
	    public void setData(Object ob) {
	        data = ob;
	    }

	    public void setNext(ListNodeObject n) {
	        next = n;
	    }
	}
