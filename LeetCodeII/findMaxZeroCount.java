

class findMaxZeroCount{
// A Kadane's algorithm based solution to find maximum 
    // number of 0s by flipping a subarray. 
    public static int findMaxZeroCount(int arr[], int n) 
    { 
        // Initialize count of zeros and maximum difference 
        // between count of 1s and 0s in a subarray 
        int orig_zero_count = 0; 
       
        // Initiale overall max diff for any subarray 
        int max_diff = 0; 
       
        // Initialize current diff 
        int curr_max = 0; 
       
        for (int i = 0; i < n; i ++) 
        { 
            // Count of zeros in original array (Not related 
            // to Kadane's algorithm) 
            if (arr[i] == 0) 
               orig_zero_count ++; 
       
            // Value to be considered for finding maximum sum 
            int val = (arr[i] == 1)? 1 : -1; 
       
            // Update current max and max_diff 
            curr_max = Math.max(val, curr_max + val); // find largest consecutive 1s
            max_diff = Math.max(max_diff, curr_max); 
        } 
        max_diff = Math.max(0, max_diff); 
       
        return orig_zero_count + max_diff; 
    } 
      
    /* Driver program to test above function */
    public static void main(String[] args)  
    { 
        int arr[] = {0, 1, 0, 0, 1, 1, 0}; 
          
        System.out.println(findMaxZeroCount(arr, arr.length)); 
    } 
  } 