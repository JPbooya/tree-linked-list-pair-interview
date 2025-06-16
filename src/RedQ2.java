public class RedQ2 {
    /**
     * Returns which has a higher average value: a given linked list or a given tree.
     * 
     * Example:
     *   List:
     *      7 -> 8 -> -2 -> 9 -> 21
     *   Tree:
     *            12
     *          /    \
     *         6      18
     *        / \    /  
     *       4   8  16  
     *   Expected Answer: "tree"
     * 
     *  Explanation:
     *   The average of the list is (7+8+-2+9+21)/5 = 8.6
     *   The average of the tree is (12+6+4+8+18+16)/6 ≈ 10.67
     *   The tree has the bigger average.
     * 
     * You can assume that both the list and the tree are non-null.
     * 
     * You can assume that the differences in averages will be large enough that
     * floating rounding error will not be an issue and that there will not be a tie.
     * 
     * @param head the head of the linked list
     * @param root the root of the tree
     * @return "list" if the list has a bigger average, "tree" if the tree has a bigger average
     */
    public static String biggerAverage(ListNode head, TreeNode root) {

        ListNode current = head;
        int sum = 0;
        int count = 0;

        while(current != null) {
            sum += current.data;
            count++;
            current = current.next;
        }

        double avgList =  (double) sum / count;

        int sumOfTree = treeSum(root);
        int conutOfTree = treeCount(root);

        double avgTree = (double) sumOfTree / conutOfTree;

        if(avgList > avgTree) {
            return "list";
        } else {
            return "tree";
        }
    }
    
    public static int treeSum (TreeNode root) {
        if(root == null) return 0;
        int treeSumLeft = treeSum(root.left);
        int treeSumRight = treeSum(root.right);
        return root.data + treeSumLeft + treeSumRight;
    }

    public static int treeCount (TreeNode root) {
        if(root == null) return 0;
        int treeCountLeft = treeCount(root.left);
        int treeCountRight = treeCount(root.right);
        return 1 + treeCountLeft + treeCountRight;
    }
}
