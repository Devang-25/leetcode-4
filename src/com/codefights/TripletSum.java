package com.codefights;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class TripletSum {

	static boolean  tripletSumArray(int x, int[] a) {
		long startTime = System.nanoTime();
        Arrays.sort(a);

        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            int r = a.length - 1;

            while (j < r) {
                if (a[i] + a[j] + a[r] == x) {
                	long endTime = System.nanoTime();
            		System.out.println("Took tripletSumArray "+(endTime - startTime)/1000 + " micros"); 
                    return true;
                } else if (a[i] + a[j] + a[r] > x) {
                    r--;
                } else {
                    j++;
                }
            }
        }
        long endTime = System.nanoTime();
		System.out.println("Took tripletSumArray "+(endTime - startTime)/1000 + " micros"); 
        return false;
    }
	static boolean tripletSum(int x, int[] a) {
		long startTime = System.nanoTime();
		HashMap<Integer, String> sumMap = new HashMap<>();
		System.out.println("a.length:" + a.length);
		for (int outer = 0; outer < a.length; outer++) 
			for (int inner = outer + 1; inner < a.length && inner != outer; inner++) {
				//System.out.println("outer:" + outer + " inner :" + inner);
				 sumMap.put(x - ( a[inner] + a[outer] ), outer + " " + inner );
			}
		//sumMap.forEach((key, value) -> System.out.println(key + ":" + value));
		for (int i = 0; i < a.length; i++) {
			if (sumMap.containsKey(a[i]))
				if (Integer.parseInt(sumMap.get(a[i]).split(" ")[0]) != i
						&& Integer.parseInt(sumMap.get(a[i]).split(" ")[1]) != i)
				{
					long endTime = System.nanoTime();
					System.out.println("Took tripletSum "+(endTime - startTime)/1000 + " micros"); 
					System.out.println(Integer.parseInt(sumMap.get(a[i]).split(" ")[0])+" - "+ Integer.parseInt(sumMap.get(a[i]).split(" ")[1]));
					return true;
				}
		}
		long endTime = System.nanoTime();
		System.out.println("Took tripletSum "+(endTime - startTime)/1000 + " micros"); 
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {162, 637, 356, 768, 656, 575, 32, 53, 351, 151, 942, 725, 967, 431, 108, 192, 8, 338, 458, 288, 754, 384, 946, 910, 210, 759, 222, 589, 423, 947, 507, 31, 414, 169, 901, 592, 763, 656, 411, 360, 625, 538, 549, 484, 596, 42, 603, 351, 292, 837, 375, 21, 597, 22, 349, 200, 669, 485, 282, 735, 54, 1000, 419, 939, 901, 789, 128, 468, 729, 894, 649, 484, 808, 422, 311, 618, 814, 515, 310, 617, 936, 452, 601, 250, 520, 557, 799, 304, 225, 9, 845, 610, 990, 703, 196, 486, 94, 344, 524, 588, 315, 504, 449, 201, 459, 619, 581, 797, 799, 282, 590, 799, 10, 158, 473, 623, 539, 293, 39, 180, 191, 658, 959, 192, 816, 889, 157, 512, 203, 635, 273, 56, 329, 647, 363, 887, 876, 434, 870, 143, 845, 417, 882, 999, 323, 652, 22, 700, 558, 477, 893, 390, 76, 713, 601, 511, 4, 870, 862, 689, 402, 790, 256, 424, 3, 586, 183, 286, 89, 427, 618, 758, 833, 933, 170, 155, 722, 190, 977, 330, 369, 693, 426, 556, 435, 550, 442 };
		int sum = 1291;
		System.out.println(tripletSum(sum, a));
		System.out.println(tripletSumArray(sum, a));

	}

}
