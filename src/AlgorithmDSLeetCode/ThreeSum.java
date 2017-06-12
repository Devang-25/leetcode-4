package AlgorithmDSLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {

		if (nums.length < 3 || nums == null){
			System.out.println("Condition not met");
			return null;
		}
		else if (nums.length == 3) {
			List<List<Integer>> intList = new ArrayList<>();
			List<Integer> tempList = new ArrayList<Integer>();
			for (int index = 0; index < nums.length; index++) {
				tempList.add(nums[index]);
			}
			intList.add(tempList);
			System.out.println("\n");
							tempList.clear();
			return intList;
		} else {
			List<Integer> intList = new ArrayList<Integer>();
			for (int index = 0; index < nums.length; index++) {
				intList.add(nums[index]);
			}
			Collections.sort(intList);
			
			for(int i=0;i<intList.size();i++){
			    System.out.println(intList.get(i));
			} 
			
			Set<List<Integer>> finalThreeSumList = new HashSet<>();
			//List<List<Integer>> finalThreeSumList = new ArrayList<>();
			List<Integer> tempList = new ArrayList<Integer>();

			int zeroFirstIndex = intList.indexOf(0);
			int zeroLastIndex = -1;
			if (zeroFirstIndex != -1)
				zeroLastIndex = intList.lastIndexOf(0);
			
			System.out.println("zeroLastIndex : "+zeroLastIndex +" zeroFirstIndex :"+ zeroFirstIndex);
			if (Collections.frequency(intList, 0) == 3) {
				
				tempList.clear();
				tempList.add(0);
				tempList.add(0);
				tempList.add(0);
				finalThreeSumList.add(tempList); System.out.println(finalThreeSumList);
				System.out.println("\n ");
							tempList.clear();

				// Logic for Negative and Positive Data Collection
				// One Zero in the List Logic
				for (int i = 0; i < zeroFirstIndex; i++) {

					if (intList.contains(Math.abs(intList.get(i)))) {
						
						tempList.clear();
						tempList.add(intList.get(i));
						tempList.add(0);
						tempList.add(Math.abs(intList.get(i)));
						finalThreeSumList.add(tempList); System.out.println(finalThreeSumList);
						
						for(int x=0;x<tempList.size();x++){
						    System.out.println(tempList.get(x));
						} 
						System.out.println("\n ");
							tempList.clear();
					}
				} 
				
				// Logic for Negative and Positive Data Collection
				// No Zeros in the inner List
				// Two negatives one Positive
				for (int i = 0; i < zeroFirstIndex; i++) {
					for (int j = i+1; j < zeroFirstIndex && j !=i; j ++) {
						for (int p = zeroLastIndex+1; p < intList.size(); p ++) {
						tempList.clear();
						tempList.add(intList.get(i));
						tempList.add(intList.get(j));
						tempList.add(intList.get(p));
						if(sum(tempList)==0)
						{
							finalThreeSumList.add(tempList); System.out.println(finalThreeSumList);
							for(int x=0;x<tempList.size();x++){
							    System.out.println(tempList.get(x));
							} 
							System.out.println("\n ");
							tempList.clear();
						}
					}
				}
				}
				
				// Logic for Negative and Positive Data Collection
				// No Zeros in the inner List
				// One negative two Positives
				for (int i = 0; i < zeroFirstIndex; i++) {
					for (int j = zeroLastIndex+1; j < intList.size(); j ++) {
						for (int p = j+1; p < intList.size() && p !=j; p ++) {
						tempList.clear();
						tempList.add(intList.get(i));
						tempList.add(intList.get(j));
						tempList.add(intList.get(p));
						if(sum(tempList)==0)
						{
							finalThreeSumList.add(tempList); System.out.println(finalThreeSumList);
							for(int x=0;x<tempList.size();x++){
							    System.out.println(tempList.get(x));
							} 
							System.out.println("\n ");
							tempList.clear();
						}
					}
				}
				}
				
				return new ArrayList<List<Integer>>(finalThreeSumList);
				//return finalThreeSumList;
			}

			else if (Collections.frequency(intList, 0) >= 1 && Collections.frequency(intList, 0) != 3) {

				System.out.println("conditions met .. At least one zero in the list");
				tempList.clear();
				// Logic for Negative and Positive Data Collection
				// One Zero in the List Logic
				for (int i = 0; i < zeroFirstIndex; i++) {

					if (intList.contains(Math.abs(intList.get(i)))) {
						tempList.clear();
						tempList.add(intList.get(i));
						tempList.add(0);
						tempList.add(Math.abs(intList.get(i)));
						finalThreeSumList.add(tempList); System.out.println(finalThreeSumList);
						
						
						for(int x=0;x<tempList.size();x++){
						    System.out.println(tempList.get(x));
						} 
						System.out.println("\n ");
							tempList.clear();
					}
				}
				
				// Logic for Negative and Positive Data Collection
				// No Zeros in the inner List
				// Two negatives one Positive
				for (int i = 0; i < zeroFirstIndex; i++) {
				for (int j = i+1; j < zeroFirstIndex && j !=i; j ++) {
					for (int p = zeroLastIndex+1; p < intList.size(); p ++) {
						tempList.clear();
						tempList.add(intList.get(i));
						tempList.add(intList.get(j));
						tempList.add(intList.get(p));
//						if(i==1 && j==2 && p==5){
//							System.out.println("intList.get(i) : "+ intList.get(i) +" intList.get(j) : "+
//						intList.get(j) +"intList.get(p) : "+ intList.get(p)+" sum(tempList) "+sum(tempList));
//						}
						if(sum(tempList)==0)
						{
//							System.out.println("intList.get(i) : "+ intList.get(i) +" intList.get(j) : "+
//									intList.get(j) +"intList.get(p) : "+ intList.get(p));
//							finalThreeSumList.add(tempList); System.out.println(finalThreeSumList);
							for(int x=0;x<tempList.size();x++){
							    System.out.println(tempList.get(x));
							} 
							System.out.println("\n ");
							finalThreeSumList.add(tempList); System.out.println(finalThreeSumList);
							tempList.clear();
						}
					}
				}
				}
				
				// Logic for Negative and Positive Data Collection
				// No Zeros in the inner List
				// One negative two Positives
				for (int i = 0; i < zeroFirstIndex; i++) {
					for (int j = zeroLastIndex+1; j < intList.size(); j ++) {
						for (int p = j+1; p < intList.size() && p !=j; p ++) {
							tempList.clear();
						tempList.add(intList.get(i));
						tempList.add(intList.get(j));
						tempList.add(intList.get(p));
						if(sum(tempList)==0)
						{
							finalThreeSumList.add(tempList); System.out.println(finalThreeSumList);
							for(int x=0;x<tempList.size();x++){
							    System.out.println(tempList.get(x));
							} 
							System.out.println("\n");
							tempList.clear();
						}
					}
				}
				}
				
				
				return new ArrayList<List<Integer>>(finalThreeSumList);
				//return finalThreeSumList;
			
			}

			else {
				System.out.println("conditions met .. No Zero in the list");
				
				int minIndex = intList.indexOf(Collections.min(intList));
				
				return new ArrayList<List<Integer>>(finalThreeSumList);
				//return finalThreeSumList;
			}

		}

	}

	public int sum(List<Integer> tempList) {

		return (tempList.get(0) + tempList.get(1) + tempList.get(2));

	}

}
