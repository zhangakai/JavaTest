package LeetcodeTest;

public class PreTree {

    private PreTree[] child;
    private boolean isEnd;
    private char common;
    private int num;

    public PreTree() {
        this.child = new PreTree[26];
        this.isEnd = false;
        this.common ='1';
        this.num = 0;
    }

    public void insert(String s) {
        PreTree node = this;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int i1 = c - 'a';
            if (node.child[i1] == null) {
                node.child[i1] = new PreTree();
                node.num++;
                if (node.num == 1) {
                    node.common=c;
                }
            }
            node = node.child[i1];
        }
        node.isEnd = true;
    }

    public boolean search(String s) {
        PreTree node = this;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (node.child[index] == null) {
                return false;
            }
        }
        if (node.isEnd) {
            return true;
        }
        return false;
    }

    public String maxPre() {
        PreTree node = this;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (node.isEnd) {
                break;
            }
            if (node.num != 1) {
                break;
            } else {
                sb.append(node.common);
            }
            node = node.child[node.common - 'a'];
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        PreTree head = new PreTree();
        String[] strings = new String[]{"abc", "abc", "abcd"};
        for (String string : strings) {
            head.insert(string);
        }
        System.out.println(head.maxPre());
    }


}
