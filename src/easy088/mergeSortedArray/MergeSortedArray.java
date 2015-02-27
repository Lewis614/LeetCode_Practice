package easy088.mergeSortedArray;

public class MergeSortedArray {
	public static void merge(int[] A, int m, int[] B, int n) {
		//pointer in A
		int i = 0;
		//pointer in B
		int j = 0;
		
		//if B[j]<A[i],move all A[i] back and insert B[j]
		while(i < m+j && j<n) {
			if(A[i] >= B[j] ) {
				for(int p = m+j-1 ; p>=i; p--){
					A[p+1] = A[p];
				}
				A[i] = B[j];
				j++;
			}
			i++;
		}
		// after sorting, if i ==m+j, means B has some tail, add it to A.
		if(i == m+j) {
			for(int q = j ; q < n; q++) {
//				A[i] = B[q];
//				i++;
				A[m+q] = B[q];
				
			}
		}
		
		// if j == n, mean the tail is on A, we already have it added as a tail, do nothing.
		if (j == n) return;
			
	}
	
	public static void main(String[] args) {
		int[] A = new int[15];
		int[] B = new int[5];
		
		for(int i =0; i<10; i++){
			A[i] = 3*i+1;
		}
		for(int i =0; i<5; i++){
			B[i] = 8*i+3;
		}
		
		merge(A, 10, B, 5);
		
		System.out.println(A);
			
			
				
			}
		
}
