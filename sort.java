package sort;

import java.util.*;

public class sort {
	public static int[] BubbleSort(int[] dst) {
		for(int i = 0; i < dst.length; i++) {
			for(int j = 0; j < dst.length-1-i; j++) {
				if (dst[j] > dst[j+1]) {
					int tmp = dst[j];
					dst[j] = dst[j+1];
					dst[j+1] = tmp;
				}
			}
		}
		System.out.println();
		return dst;
	}
		   
	public static int[] selectionSort(int[] arr) {		
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;				
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, min, i);
		}
		return arr;
	}
	
	public static int[] insertionSort(int[] arr) {		
		for(int i = 1; i < arr.length; i++) {
			int target = arr[i];			
			int j = i - 1;
			while(j >= 0 && target < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = target;	
		}
		return arr;
	}
	
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int[] shellSort(int[] arr) { 
		int gap = arr.length/2; 
		while (gap >=1){ 
			for(int i=0;i<gap;i++) { 
				insertionSort(arr); 
			} 
			gap = gap/2; 
		} 
		return arr;
	}

	
	public static int[] quickSort(int[] arr,int start, int end) {
        int part=partition(arr,start,end);
        if(start<part-1) quickSort(arr,start,part-1);
        if(end>part) quickSort(arr,part,end);
        return arr;
    }

    private static int partition(int[] arr,int start,int end) {
        int pivot=arr[(start+end)/2];
        while(start<=end) {
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;
            if(start<=end) {
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }
		
    public static void MAX_HEAPIFY(int[] base, int i, int len){
        int j;
        int tmp = base[i-1];
        while(i<=len/2){ 
            j = i*2;
            if((j<len) && (base[j-1] <base[j])){
                j++;
            }
            if(tmp >= base[j-1]){
                break;
            }
            base[i-1] = base[j-1];
            i=j;
        }
        base[i-1] = tmp;
    }

    public static int[] heapSort(int[] base){
        int len = base.length;
        for(int i = len/2;i>0;i--){
            MAX_HEAPIFY(base,i,len);
        }
        do{
            int tmp = base[0];
            base[0] = base[len-1];
            base[len-1] = tmp;
            len = len-1;
            MAX_HEAPIFY(base,1,len);
        }while(len > 1);
        return base;
    }
	
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int size = (int) Math.pow(2, 8);
		int[] arr = new int[size];		
		Random num = new Random();		
		int a = arr.length;
		for(int i = 0; i < a; i++) {
			arr[i] = num.nextInt();
		}
		int[] dst = arr.clone();
		int[] res = BubbleSort(dst);
		for(int i = 0; i < res.length; i++) {
			System.out.printf("%d ", res[i]);
		}
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.printf("걸린시간 : " + (end - start));		
	}
}