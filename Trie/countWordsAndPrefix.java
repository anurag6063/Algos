/*
# Algos
[Note]
[Reference]: https://takeuforward.org/data-structure/implement-trie-ii/ ; https://www.youtube.com/watch?v=K5pcpkEMCN0&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=2
[Problem]: Basic
[Pattern]: Trie + counters
[Tips]: 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

/**
 * Problem Statement:  Implement a data structure ”TRIE” from scratch. Complete some functions.

1) Trie(): Initialize the object of this “TRIE” data structure.

2) insert(“WORD”): Insert the string “WORD”  into this “TRIE” data structure.

3) countWordsEqualTo(“WORD”): Return how many times this “WORD” is present in this “TRIE”.

4) countWordsStartingWith(“PREFIX”): Return how many words are there in this “TRIE” that have the string “PREFIX” as a prefix.

5) erase(“WORD”): Delete this string “WORD” from the “TRIE”.


---

first i will insert all the words
next will again iterate all the words and find the longest one. 

 */
class Node{
    Node links[] = new Node[26];
    int cntEndWith = 0;
    int cntPrefix = 0;
    
    public Node(){}
    
    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
    
    Node get(char ch){
        return links[ch - 'a'];
    }
    
    void set(char ch, Node node){
        links[ch - 'a'] = node;
    }
    
    void increaseEnd(){
        cntEndWith++;
    }
    
    void decreaseEnd(){
        cntEndWith--;
    }
    
    void increasePrefix(){
        cntPrefix++;
    }
    
    void decreasePrefix(){
        cntPrefix--;
    }
    
    int getEndCount(){
        return cntEndWith;
    }
    
    int getPrefixCount(){
        return cntPrefix;
    }
}

public class Trie
{
    // i always need to start from here so it's kept at class level
    private Node root;
    
    Trie(){
        root = new Node();
    }
    
    public void insert(String word){
        Node node = root;
        for(int i =0; i< word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.set(word.charAt(i), new Node());
            }
            // move forward
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }
    
    public int countWordsEqualTo(String word){
        Node node = root;
        // go till key exists in the node, then return the end.
        for(int i=0; i< word.length(); i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getEndCount();
    }
    
    public int countWordsStartingWith(String word){
        Node node = root;
        for(int i =0; i < word.length(); i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            } else{
                return 0;
            }
        }
        return node.getPrefixCount();
    }
    
    public void erase(String word){
        Node node = root;
        for(int i =0; i< word.length(); i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.decreasePrefix();
            }else{
                return;
            }
        }
        node.decreaseEnd();
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		
  Trie T=new Trie();
  T.insert("apple");
  T.insert("apple");
  T.insert("apps");
  T.insert("apps");
  String word1 = "apps";
  System.out.println("Count Words Equal to "+word1+" "+T.countWordsEqualTo(word1));
  String word2 = "abc";
  System.out.println("Count Words Equal to "+word2+" "+T.countWordsEqualTo(word2));
  String word3 = "ap";
  System.out.println("Count Words Starting With "+word3+" "+T.countWordsStartingWith
  (word3));
  String word4 = "appl";
  System.out.println("Count Words Starting With "+word4+" "+T.countWordsStartingWith
  (word4));
  T.erase(word1);
  System.out.println("Count Words equal to "+word1+" "+T.countWordsEqualTo(word1));
	}
}
