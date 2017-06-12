package AlgorithmDSLeetCode;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

public class PascalTrinagleGetRow {
	
	static public List<Integer> getRowArrayList(int rowIndex) {
    List<Integer> res = new ArrayList<Integer>();
    for(int i = 0;i<rowIndex+1;i++) {
    		res.add(1);
    		for(int j=i-1;j>0;j--) {
    			res.set(j, res.get(j-1)+res.get(j));
    		}
    		System.out.println("For Loop:"+i+" set value: "+res);
    }
    return res;
	}
	static public List<Integer> getRow(int rowIndex) {
		
		List<Integer> pascalRowList =  new ArrayList<>();
		
		for(int i=0;i<=rowIndex;i++){
			pascalRowList.add(pascalHelper(rowIndex,i));
		}
		return pascalRowList;
        
    }
	
	
	static int pascalHelper(int num,int index){
		
		if(!( index==0 || index == num)){
			if(index> num/2) index=num-index;
			long numerator =num;
		for (int i=1;i<index;i++)
			numerator*= --num;
		long denominator =factorial(index);
		//System.out.println("numerator:"+numerator+" index:"+index+" numerator:"+numerator+" denominator:"+denominator);
		return (int)((long) numerator/(long)denominator);
		}else return 1;
	}
	
	static int factorial(int index){
		if(index ==0) return 1;
		else return (index *factorial(index-1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRowArrayList(18));
	}

}
