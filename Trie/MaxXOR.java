/*
# Algos
[Note]
[Reference]: https://takeuforward.org/data-structure/maximum-xor-of-two-numbers-in-an-array/ ; https://www.youtube.com/watch?v=EIhAwfHubE8&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=6
[Problem]: NA
[Pattern]: Trie ; bit ; node with 2 options only
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


import java.util.*;
class Node {

    // node 
    // structure - 2; get ; set ; containsSet()
    Node[] links = new Node[2];
    public Node(){}
    
    boolean containsKey(int index){
        return links[index] != null;
    }
    
    Node get(int index){
        return links[index];
    }
    
    Node set(int index, Node node){
       return links[index] = node;
    }
};

class Trie{
    
    // uses Node class
    // constructor , insert , max find max
    private static Node root;
    Trie(){
        root = new Node();
    }
    
    public static void insert(int num){
        Node node = root;
        for(int i =31; i >=0; i--){
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)){
                node.set(bit, new Node());
            }
            
            node = node.get(bit);
        }
        
    }
    
    public static int max(int num){
        Node node = root;
        int maxCurr = 0;
        
        for(int i = 31 ; i >= 0; i-- ){
            int bit = (num >>  i ) & 1 ;
            if(node.containsKey( 1 - bit)){
                maxCurr = maxCurr | ( 1 << i );
                node = node.get(1-bit);
            }else{
                node = node.get(bit);
            }
        }
        
        return maxCurr;
        
    }
}
    
public class Main
{
    // find max ; main method as starter
    public int max(int n , int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        Trie trie = new Trie();
        for(int i = 0; i < n ; i++){
            trie.insert(arr1.get(i));
        }
        
        int max = 0;
        for(int i =0; i < m ; i++){
            int x = trie.max(arr2.get(i));
            max = Math.max(x, max);
        }
        
        return max;
    }

    // 
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		int n = 2, m = 3;
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(new Integer[]{6,8}));
		ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{7,8,2}));
		
		Main main = new Main();
		System.out.println(main.max(n, m , arr1, arr2));
	}
}
