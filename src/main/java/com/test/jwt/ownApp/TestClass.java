package com.test.jwt.ownApp;

import java.util.HashMap;
import java.util.Map;

public class TestClass {
	private long crmID;
	private int nameSpace;

	public TestClass(long crmID, int nameSpace) {
		super();
		this.crmID = crmID;
		this.nameSpace = nameSpace;
	}

	public boolean equals(Object obj) {
		// null instanceof Object will always return false
		if (!(obj instanceof TestClass)) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		return this.crmID == ((TestClass) obj).crmID && this.nameSpace == ((TestClass) obj).nameSpace;
	}
	
	public int hashCode() {
	    int result = 0;
	    result = (int)(crmID/12) + nameSpace;
	    return result;
	  }


	public static void main(String[] args) {
		Map m = new HashMap();
		m.put(new TestClass(2345891234L, 0), "Jeff Smith");
		System.out.println(m.get(new TestClass(2345891234L, 0)));
	}

}
