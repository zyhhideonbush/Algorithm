package level7_right.pritice.pritice0807;


public class Code01_TrieTree {
    public static class TrieNode {
        private int path;
        private int end;
        private TrieNode[] nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
               return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if(node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
        }

        public void delete(String word) {
            if (search(word) == 0) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (--node.nexts[index].path == 0) {
                   node.nexts[index] = null;
                   return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }

        public int search(String word) {
            if (word == null) {
               return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefixNum(String word) {
            if (word == null) {
               return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index].path == 0) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }

}
