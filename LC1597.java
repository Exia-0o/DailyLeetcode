/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        public Node expTree(String s) {
        s = '(' + s + ')';
        Stack<Node> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) && c != '(') {
                Node right = stack.pop();
                if (c == '*' || c == '/') {
                    if (stack.peek().val == '*' || stack.peek().val == '/') {
                        Node ops = stack.pop();
                        Node left = stack.pop();
                        ops.left = left;
                        ops.right = right;
                        right = ops;
                    }
                } else {
                    while (stack.peek().val != '(') {
                        Node ops = stack.pop();
                        Node left = stack.pop();
                        ops.left = left;
                        ops.right = right;
                        right = ops;
                    }
                    if (c == ')') {
                        stack.pop();
                    }
                }
                stack.push(right);
            }
            
            if (c != ')') {
                stack.push(new Node(c));
            }
        }
        return stack.pop();
    }
}
