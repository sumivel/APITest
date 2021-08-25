package restassured;

import java.util.List;

public class Testclass {
	public String idn;
    int count=0;
    //String check="true";
    //String verify="music";

	public int  verify_Field_More_Than_Single_Value(List<String> jsonobject,String check) {
	     for(int i=0;i<jsonobject.size();i++) {
	 		String idn=  String.valueOf(jsonobject.get(i));  
	   	  if(idn.equals(check)) {
	   		  count++;
	   	  }}
	     return count;	      
	}

	public String verify_Null_Or_Empty(List<String> jsonobject) {
		 for(int i=0;i<jsonobject.size();i++) {
        	  idn=  String.valueOf(jsonobject.get(i));
        	  if(idn.equals("null")||idn.equals("")) {
        		  break;
        	  }	  
		 }
		 return idn;
	}
	
	public String verify_Field_Value(List<String> jsonobject,String verify) {
		 for(int i=0;i<jsonobject.size();i++) {
       	  idn=  String.valueOf(jsonobject.get(i));
       	  if(!idn.equals(verify)) {
       		  break;
       	  }	  
		 }
		 return idn;
	}


}


