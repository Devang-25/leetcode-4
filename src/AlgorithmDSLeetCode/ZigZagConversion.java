package AlgorithmDSLeetCode;

public class ZigZagConversion {

//	public String convert(String s, int numRows) {
//
////		int sumRows = 0, intZigZag = 0, lengthString = s.length(), columns = 0;
////		while (lengthString > 0) {
////			lengthString = lengthString - numRows;
////			columns++;
////			if (numRows > 2 && lengthString > 0) {
////				for (int i = 0; i < numRows - 2; i++) {
////					lengthString--;
////					intZigZag++;
////					if (lengthString < 0)
////						break;
////				}
////			}
////		}
////		columns = columns + intZigZag;
//		
//		//s.length()%(2(numRows-1))+s.length()/numRows+(s.length()-numRows)%numRows
//		int quotient=0;
//		if (s.length()/(2*numRows-2)>0){
//			quotient= s.length()/(2*numRows-2);
//		}
//		else{
//			quotient=0;
//		}
//		
//		int columns1 = (s.length()/(2*numRows-2))*(numRows-1);
//		
//		System.out.println("columns1 "+columns1);
//		int temp1 = s.length()/(2*numRows-2)	;
//		
//		int temp2= s.length()- temp1*(2*numRows-2)	;
//		
//		if(temp2>0){
//		columns1++;
//		if(temp2>numRows){
//			
//			columns1= columns1 +temp2%numRows;
//		}
//		}
//		System.out.println("columns1 "+columns1+" temp1 "+temp1+" temp2 "+temp2);
//		
//		int[][] stringMatrix = null ;
//		int i=0,j=0;
//		
//		while( i < columns1){
//			while(j < numRows){
//				stringMatrix[j][i] = s.charAt(i+j);
//				j++;
//			}
//			i++;
//			stringMatrix[j][i] = s.charAt(i+j);
//			if(j>0) j--;
//		}
//		return " Here it goes! ";
//	}
	
	public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder result = new StringBuilder();;
        //the size of a cycle(period)
        int cycle = 2 * numRows - 2;
        for(int i = 0; i < numRows; ++i)
        {
            for(int j = i; j < s.length(); j = j + cycle){
               result = result.append(s.charAt(j));
               int secondJ = (j - i) + cycle - i;
               if(i != 0 && i != numRows-1 && secondJ < s.length())
                   result = result.append(s.charAt(secondJ));
            }
        }
        return result.toString();
}

	public static void main(String[] args) {
		
		System.out.println(new ZigZagConversion().convert("infosyssucks", 6));

	}

}
