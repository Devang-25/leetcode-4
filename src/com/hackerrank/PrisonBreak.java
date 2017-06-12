package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PrisonBreak {

	static long prison(int n, int m, int[] h, int[] v) {
		if((h.length ==0 && v.length==0) || (h==null  || v==null ))return 1;
		else {
		long area=0;
		
		
		
		int[] horizonal = new int[n + 2];
		int[] vertical = new int[m + 2];
		
		Arrays.fill(horizonal, 0);
		Arrays.fill(vertical, 0);
		
		for (int i = 0; i < h.length; i++) {
			horizonal[h[i]+1]=1;
		}
		
		for (int i = 0; i < v.length; i++) {
			vertical[v[i]+1]=1;
		}
		
		int horizontal_blank_min=0,horizontal_blank_max = 0,horizontal_blank_final = 0;
		int vertical_blank_min=0,vertical_blank_max = 0,vertical_blank_final=0;
		
		for (int i = 1; i < horizonal.length; i++) {
			if(horizonal[i]==1 ){
				
				horizontal_blank_max++;
				if(horizontal_blank_max>horizontal_blank_final){
					horizontal_blank_min=horizontal_blank_max-(i+1);
					horizontal_blank_final = horizontal_blank_max;
				}
			}
			else {
				horizontal_blank_max=0;
			}
		}
		
		
		for (int i = 1; i < vertical.length; i++) {
			if(vertical[i]==1 ){
				
				vertical_blank_max++;
				if(vertical_blank_max>vertical_blank_final){
					vertical_blank_min=vertical_blank_max-(i+1);
					vertical_blank_final = vertical_blank_max;
				}
			}
			else {
				vertical_blank_max=0;
			}
		}
		
		area = (++vertical_blank_final)*(++horizontal_blank_final);
		
		return area;
		}
		
    }
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        long res;
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());
        
        int _m;
        _m = Integer.parseInt(in.nextLine().trim());
        
        
        int _h_size = 0;
        _h_size = Integer.parseInt(in.nextLine().trim());
        int[] _h = new int[_h_size];
        int _h_item;
        for(int _h_i = 0; _h_i < _h_size; _h_i++) {
            _h_item = Integer.parseInt(in.nextLine().trim());
            _h[_h_i] = _h_item;
        }
        
        
        int _v_size = 0;
        _v_size = Integer.parseInt(in.nextLine().trim());
        int[] _v = new int[_v_size];
        int _v_item;
        for(int _v_i = 0; _v_i < _v_size; _v_i++) {
            _v_item = Integer.parseInt(in.nextLine().trim());
            _v[_v_i] = _v_item;
        }
        
        res = prison(_n, _m, _h, _v);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
    }
}


