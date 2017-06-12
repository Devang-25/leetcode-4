package AlgorithmDSLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMedianSortedArray {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		List<Integer> intList1 = new ArrayList<Integer>();
		
		if(nums1.length + nums2.length ==0){
			return (Double) null;
		}
		else if(nums1.length + nums2.length ==1){
			
			for (int index = 0; index < nums1.length; index++)
			{
				intList1.add(nums1[index]);
			}
			for (int index = 0; index < nums2.length; index++)
			{
				intList1.add(nums2[index]);
			}
			return (double)intList1.get(0);
		}
		else{
			
			
		for (int index = 0; index < nums1.length; index++)
		{
			intList1.add(nums1[index]);
		}
		for (int index = 0; index < nums2.length; index++)
		{
			intList1.add(nums2[index]);
		}
		Collections.sort(intList1);
		System.out.println("intList1.size() " +intList1.size()+" intList1.size()%2 "+intList1.size()%2);
		
		if(intList1.size()%2==0){
			return (double) (intList1.get(intList1.size()/2-1) + intList1.get(intList1.size()/2))/2 ;
		}
		else{
			return (double) intList1.get(intList1.size()/2);
		}
		}
	}
	
public static void main (String args[]){
		
		int[] arr1 = {};
		int[] arr2 = {1};
		FindMedianSortedArray findMedian = new FindMedianSortedArray();
		System.out.println("The median "+findMedian.findMedianSortedArrays(arr1, arr2));
		  
	}

}
