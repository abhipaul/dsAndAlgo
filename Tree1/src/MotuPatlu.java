import java.util.Collections;
import java.util.Scanner;

public class MotuPatlu {
	
	public static void main(String args[]) {
		int sample = 0, count = 0;
		Scanner s = new Scanner(System.in);
		sample = s.nextInt();
		do {
			int n = 0;
			n = s.nextInt();
			int[] height = new int[n];
			for(int i=0;i<n;i++) {
				height[i] = s.nextInt();
			}
			doTheCalcu(height, reverse(height), n);
			count++;
        }while(count<sample);
	}
	
	private static void doTheCalcu(int[] motu, int[] patlu, int n) {
		int i = 0,j =0;
		// since motu is twice as fast as patlu
		for(int k = 0; k< patlu.length; k++) {
			patlu[k] = patlu[k] * 2;
		}
		while((i+j) < n) {
			if(motu[i]<patlu[j]) {
				patlu[j] = patlu[j]- motu[i];
				motu[i] = 0;
				i++;
			}
			else if(motu[i]>patlu[j]) {
				motu[i] = motu[i]- patlu[j];
				patlu[j] = 0;
				j++;
				
			} else if(motu[i]==patlu[j]) {
				motu[i]= 0;
				patlu[j] = 0;
				if((i+j+1)==n && i>j) {
					j++;
				}else if((i+j+1)==n && j>i) {
					i++;
				}else {
					i++;
					j++;
				}			
			}
		}
		System.out.println(i+ " "+ j);
		if(i>j) {
			System.out.println("Motu");
		}else {
			System.out.println("Patlu");
		}
	}
	public static int[] reverse(int[] nums) {
	    int[] reversed = new int[nums.length];
	    for (int i=0; i<nums.length; i++) {
	        reversed[i] = nums[nums.length - 1 - i];
	    }
	    return reversed;
	}
}
