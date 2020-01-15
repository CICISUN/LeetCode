import java.util.*;

/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 *
 * https://leetcode.com/problems/fruit-into-baskets/description/
 *
 * algorithms
 * Medium (42.02%)
 * Likes:    609
 * Dislikes: 947
 * Total Accepted:    75.3K
 * Total Submissions: 179.2K
 * Testcase Example:  '[1,2,1]'
 *
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * 
 * You start at any tree of your choice, then repeatedly perform the following
 * steps:
 * 
 * 
 * Add one piece of fruit from this tree to your baskets.  If you cannot,
 * stop.
 * Move to the next tree to the right of the current tree.  If there is no tree
 * to the right, stop.
 * 
 * 
 * Note that you do not have any choice after the initial choice of starting
 * tree: you must perform step 1, then step 2, then back to step 1, then step
 * 2, and so on until you stop.
 * 
 * You have two baskets, and each basket can carry any quantity of fruit, but
 * you want each basket to only carry one type of fruit each.
 * 
 * What is the total amount of fruit you can collect with this procedure?
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4
 * fruits.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 * 
 * 
 */

// @lc code=start
class totalFruitt {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, j;
        for (j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            if (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                count.remove(tree[i++], 0);
            }
        }
        return j - i;
    }

    public int totalFruit2(int[] tree) {
        int res = 0, cur = 0, consecutive_second_element = 0, first_element = 0, second_element = 0;
        for (int c : tree) {
            cur = c == first_element || c == second_element ? cur + 1 : consecutive_second_element + 1;
            consecutive_second_element = c == second_element ? consecutive_second_element + 1 : 1;
            if (second_element != c) {
                first_element = second_element;
                second_element = c;
            }
            res = Math.max(res, cur);
        }
        return res;
    }

    public static void main(String[] args) {
        totalFruitt s = new totalFruitt();
        int[] arr = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        System.out.println(s.totalFruit2(arr));
    }
}
// @lc code=end
