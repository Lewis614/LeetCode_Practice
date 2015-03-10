package medium081.searchinRotatedSortedArrayII;

public class Solution {
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0) return false;
        
        int l = 0;
        int r = A.length -1;
        
        while (l <= r) {
            int m = (l+r)/2;
            if(A[m] == target) return true;
            
            if (A[m] < A[r]) {
                if(A[m] < target && target <= A[r]) l = m+1;
                else r = m-1;
            }
            else if (A[m] > A[r]) {
                if(A[l] <= target && target < A[m]) r = m-1;
                else l = m+1;
            }
            else {
                r--;
            }
        }
        return false;
    }
}
