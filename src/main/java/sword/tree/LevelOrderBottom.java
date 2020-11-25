package sword.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/4/6 08:24
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: leetcode
 *              107. 二叉树的层次遍历 II
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> arrays = new ArrayList<List<Integer>>();
        addLevel(arrays,0,root);
        Collections.reverse(arrays);
        return arrays;
    }

    public void addLevel(List<List<Integer>> list, int level, TreeNode root) {
        if (root == null) {
            return;
        }
        if (list.size() - 1 < level) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);

        addLevel(list,level + 1,root.left);
        addLevel(list,level + 1,root.right);
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;TreeNode(int x) { val = x; }
}
