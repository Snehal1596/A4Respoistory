package pratice.datadriventesting;

public class GenerateAlphaNumericRandomData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int n = 5;
       String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
       
       StringBuilder sb = new StringBuilder(n);
       
       for(int i = 0;i<n;i++) {
    	   
    	   int index = (int)(AlphaNumericString.length()*Math.random());//typecasting narrowing
    	  
    	   
    	   sb.append(AlphaNumericString.charAt(index));
       }
       System.out.println(sb);
    		   
	}

}
