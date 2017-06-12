package AlgorithmDSLeetCode;

public class RemoveKDigits {

	static public String removeKdigits(String num, int k) {
		
		if(k<=0) return num;
		else if(k== num.length()) return "0";
		else{
			StringBuilder stringBuilder = new StringBuilder();
			String temp = "";
			for(int i=0;i<=num.length()-k;i++){
				stringBuilder.append(num, 0, i);
				stringBuilder.append(num, i+k, num.length());
				while(true){
					if(stringBuilder.charAt(0)=='0' && stringBuilder.length()!=1) stringBuilder.deleteCharAt(0);
					else break;
				}
				
				if( (temp.compareTo(stringBuilder.toString()) > 0  && (temp.length() >= stringBuilder.length()))|| temp =="" ) temp = stringBuilder.toString();
				System.out.println("stringBuilder.toString():"+stringBuilder.toString()+" temp:"+temp);
				stringBuilder.setLength(0);
			}
			
			return temp == ""? "0": temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("FINAL ANSWER:"+removeKdigits("1432219", 3));
		//System.out.println(Integer.parseInt("0200"));
	}

}
