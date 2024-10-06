/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) return traversal;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            List<Integer> currLevel = new ArrayList<>();
            while (size != 0) {
                TreeNode tmp = queue.poll();
                currLevel.add(tmp.val);
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
                size--;
            }
            traversal.add(currLevel);
        }
        return traversal;
    }
} // TC: O(n), SC: O(n)


public class Codec {
    public String serialize(TreeNode root) { // TC: O(n), SC: O(n)
        if (root == null) {
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }
    
    public TreeNode deserialize(String data) {  // TC: O(n), SC: O(n)
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    public TreeNode dfs(Queue<String> queue) { 
        String str = queue.poll();
        if (str.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = dfs(queue);
        node.right = dfs(queue);
        return node;
    }
}

class Solution {
    int preorderIndex;
    HashMap<Integer,Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length - 1);
    }
    public TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1); // left: left -> c-1
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right); // right: c+1 -> right
        return root;
    }
} // TC: O(n), SC: O(n)

class Trie {
    
    class Node {
        HashMap<Character, Node> child = new HashMap<>();
        boolean isEnd = false;
    }
    
    Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.child.containsKey(ch)) {
                curr.child.put(ch, new Node());
            }
            curr = curr.child.get(ch);
        }
        curr.isEnd = true;
    } // TC: O(n), SC: O(n)
    
    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.child.containsKey(ch))
                return false;
            curr = curr.child.get(ch);
        }
        return curr.isEnd;
    } // TC: O(n), SC: O(1)
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!curr.child.containsKey(ch))
                return false;
            curr = curr.child.get(ch);
        }
        return true;
    } // TC: O(n), SC: O(1)
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


class WordDictionary {
    class Node {
        HashMap<Character, Node> child;
        boolean isEnd;
        public Node () {
            child = new HashMap<>();
            isEnd = false;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.child.containsKey(ch)) {
                curr.child.put(ch, new Node());
            }
            curr = curr.child.get(ch);
        }
        curr.isEnd = true;
    } // TC: O(n), SC: O(n)
    
    public boolean search(String word) {
        return searchWord(word, 0, root);
    }

    public boolean searchWord(String word, int index, Node curr) {
        if (index == word.length()) return curr.isEnd;
        if (word.charAt(index) == '.') {
            for (Character ch : curr.child.keySet()) {
                if (searchWord(word, index + 1, curr.child.get(ch))) return true;
            }
            return false;
        } else {
            if (curr.child.get(word.charAt(index)) == null) return false;
            return searchWord(word, index + 1, curr.child.get(word.charAt(index)));
        }
    } // TC: O(n^2), SC: O(n)
}


class Solution {

    class Node {
        HashMap<Character, Node> child;
        String word;
        public Node() {
            child = new HashMap<>();
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        Node root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0;  j < board[0].length; j++) {
                dfs(board, list, root, i, j);
            }
        }
        return list;
    }

    public void dfs(char[][] board, List<String> list, Node curr, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;

        char ch = board[i][j];

        if (ch == '#' || curr.child.get(ch) == null) return;
        curr = curr.child.get(ch);
        if (curr.word != null) {
            list.add(curr.word);
            curr.word = null;
        }

        board[F][j] = '#';
        // top, left, down, right
        dfs(board, list, curr, i - 1, j);
        dfs(board, list, curr, i, j - 1);
        dfs(board, list, curr, i + 1, j);
        dfs(board, list, curr, i, j + 1);
        board[i][j] = ch;
    }

    public Node buildTrie(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!curr.child.containsKey(ch)) {
                    curr.child.put(ch, new Node());
                }
                curr = curr.child.get(ch);
            }
            curr.word = word;
        }
        return root;
    }
}