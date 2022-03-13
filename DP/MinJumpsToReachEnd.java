public class MinJumpsToReachEnd {

	public static void main(String[] args) {
		
		int arr[] = new int[]{2, 3, 1, 1, 4};

		System.out.println(minJumps(arr, arr.length));

	}

	 public static int minJumps(int nums[], int length) {
	        
	    if (length == 1) {
	        return 0;
	    }
	    	
	    int res = Integer.MAX_VALUE;
	    
	    for (int i = 0; i <= length-2; i++) {
	        
	        if (i + nums[i] >= length-1) {
	            int subRes = minJumps(nums, i+1);
	            
	            if (subRes != Integer.MAX_VALUE) {
	                res = Math.min(res, subRes + 1);
	            }
	        }
	    }
	    
	    return res;
	    
	}
}