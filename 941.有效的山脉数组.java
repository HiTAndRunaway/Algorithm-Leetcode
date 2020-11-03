class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        for(int i=1;i < A.length - 1;i++){
            if(A[i] > A[i-1] && A[i] > A[i+1]){
                int left = i - 1;
                int right = i + 1;
                //boolean leftflag = false;
                //boolean rightflag = false;
                while(left > 0 && A[left] > A[left-1]){
                    left--;
                }
                if(left != 0){
                    continue;
                }
                while(right < A.length - 1 && A[right] > A[right+1]){
                    right++;
                }
                if(right != A.length - 1){
                    continue;
                }
                return true;
            }
        }
        return false;

    }
}