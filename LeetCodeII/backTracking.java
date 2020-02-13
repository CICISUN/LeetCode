import java.util.*;

public class backTracking {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());
    
        for (int num : nums) {
          List<List<Integer>> newSubsets = new ArrayList<>();
          for (List<Integer> curr : output) {
            newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
          }
          for (List<Integer> curr : newSubsets) {
            output.add(curr);
          }
        }
        return output;
      }

    public static List<List<Integer>> subsetsbt(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsbtBacktrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void subsetsbtBacktrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                subsetsbtBacktrack(list, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); //skip duplicates
        subsetsWithDupBacktrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
         
    private static void subsetsWithDupBacktrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            subsetsWithDupBacktrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permuteBacktrack(list, new ArrayList<>(), nums);
        return list;
     }
      
     private static void permuteBacktrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
           list.add(new ArrayList<>(tempList));
        } else {
           for(int i = 0; i < nums.length; i++){ 
              if(tempList.contains(nums[i])) continue; // element already exists, skip
              tempList.add(nums[i]);
              permuteBacktrack(list, tempList, nums);
              tempList.remove(tempList.size() - 1);
           }
        }
     } 

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        permuteUniqueBacktrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    
    private static void permuteUniqueBacktrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true; 
                tempList.add(nums[i]);
                permuteUniqueBacktrack(list, tempList, nums, used);
                used[i] = false; 
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        combineBacktrack(list, new ArrayList<>(), n, k, 1);
        return list;
    }
     
    private static void combineBacktrack(List<List<Integer>> list, List<Integer> sublist, int n, int k, int start) {
        if(sublist.size() == k) {
            list.add(new ArrayList<>(sublist));
        } else {
            for(int i = start; i <= n; i++) {
                // if(sublist.contains(i)) {
                //     continue;
                // }
                sublist.add(i);
                combineBacktrack(list, sublist, n, k, i + 1);
                sublist.remove(sublist.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums);
        combinationSumbacktrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }
     
    private static void combinationSumbacktrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                combinationSumbacktrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        combinationSum2backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
        
    }
    
    private static void combinationSum2backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                combinationSum2backtrack(list, tempList, nums, remain - nums[i], i + 1); // cannot use self
                tempList.remove(tempList.size() - 1); 
            }
        }
    } 

    /**
     * unique set of numbers && combination of k numbers add to n, and the range is 1 to 9
     **/
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        combinationSum3backtrack(k, n, list, new ArrayList<>(), 1);
        return list;
    }
     
    private static void combinationSum3backtrack(int k, int n, List<List<Integer>> list, List<Integer> sublist, int start) {
        if(n < 0 || sublist.size() > k) {
            return;
        } else if(sublist.size() == k && n == 0) {
            list.add(new ArrayList<>(sublist));
        } else {
            for(int i = start; i <= 9; i++) {
                sublist.add(i);
                combinationSum3backtrack(k, n - i, list, sublist, i + 1);
                sublist.remove(sublist.size() - 1);
            }
        }
    }

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return all possible palindrome partitioning of s.
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
     }
      
     public static void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length())
           list.add(new ArrayList<>(tempList));
        else{
           for(int i = start; i < s.length(); i++){
              if(isPalindrome(s, start, i)){
                 tempList.add(s.substring(start, i + 1));
                 backtrack(list, tempList, s, i + 1);
                 tempList.remove(tempList.size() - 1);
              }
           }
        }
     }
      
     public static boolean isPalindrome(String s, int low, int high){
        while(low < high)
           if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
     }
    public static void main(String[] args) {
        int[] nums = {2,2,4};
        // System.out.println(backTracking.subsetsbt(nums));
        // System.out.println(backTracking.subsetsWithDup(nums));
        // System.out.println(backTracking.permuteUnique(nums));
        // System.out.println(backTracking.combine(3, 2));
        // System.out.println(backTracking.combinationSum(nums, 3));
        // System.out.println(backTracking.combinationSum2(nums, 4));
        // System.out.println(backTracking.combinationSum3(3, 9));
        System.out.println(backTracking.partition("aab"));

    }
}