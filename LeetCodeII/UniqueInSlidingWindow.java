import java.util.*;

/**
 * FB phone mianjing
 * 给个array of int 跟一个window w, 写个function返回所有sliding windows of size w里面的有几个distinct numbers

    example:
    arr = Array(0, 1, 1, 2, 1, 2, 3, 2)  
    w = 3
    counts = getWindowCounts(arr, w)
    print(counts)
    Output: [2, 2, 2, 2, 3, 2]

 */


 class UniqueInWindow {

    public static List<Integer> uniqueInWindow (List<Integer> input, int k) {
        if(input== null || input.size() < k || k < 1) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0, start=0; i<input.size(); i++) {
            map.put(input.get(i), map.getOrDefault(input.get(i), 0) + 1);   
            if(i-start==k) {
                map.put(input.get(start), map.get(input.get(start)) - 1);
                map.remove(input.get(start), 0);
                start++;
            }
            if(i-start==k-1) {
                res.add(map.size());
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(UniqueInWindow.uniqueInWindow(Arrays.asList(0), 1));
        System.out.println(UniqueInWindow.uniqueInWindow(Arrays.asList(0), 0));
        System.out.println(UniqueInWindow.uniqueInWindow(Arrays.asList(0, 1, 1, 2, 1, 2, 3, 2), 3));
        System.out.println(UniqueInWindow.uniqueInWindow(Arrays.asList(0, 1, 1, 2, 1, 2, 3, 2), 1));
    }
 } 

