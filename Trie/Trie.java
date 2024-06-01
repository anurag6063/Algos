
/*
# Algos
[Note]
[Reference]: https://takeuforward.org/data-structure/implement-trie-1/; https://www.youtube.com/watch?v=dBGUmUQhjaM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp
[Problem]: Basics
[Pattern]: Trie - basics
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

/*
    Node[] of alphabets - get set and contains`
    and a flag - set , and get - set = true abd get flag vlaue. 
*/
	    
class Node{
    
    Node links[] = new Node[26];
    boolean flag = false;
    
    public Node(){
        
    }
    
    boolean containsKey(char ch){
        if(links[ch - 'a'] != null){
            return true;
        }else{
            return false;
        }
    }
    
    Node get(char ch){
        return links[ch - 'a'];
    }
    
    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }
    
    void setEnd(){
        flag = true;
    }
    
    boolean isEnd(){
        return flag;
    }
};


public class Trie
{
    private static Node root;// the starting point
    
    // default initialization
    Trie(){
        root = new Node();
    }    
    
    // insert word in the Trie
    public static void insert(String word){
        // need to start with the root always
        Node node = root;
        for(int i =0; i< word.length(); i++){
            // if node does not has it create it
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            // if i create i will get a new reference else i would alreday have a referecne stored beforhand.
            node = node.get(word.charAt(i));
        }
        
        // when the word ends i need to mark the last letter with true value.
        node.setEnd();
    }
    
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		int n = 5;
		int[] type = {1,1,2,3,2};
		String[] value = {"hello", "help", "help", "hel", "hel"};
		
		Trie trie = new Trie();
		
		for(int i =0; i < n ; i++){
		    if(type[i] == 1){
		        trie.insert(value[i]);
		    }else if( type[i] == 2){
		        // search 
		        if(trie.search(value[i])){
		            System.out.println("found in search, the whole word");
		        }else{
		            System.out.println("NOT found in search, the whole word");
		        }
		    }else if(type[i] == 3){
		        // suggest
		        if(trie.startsWith(value[i])){
		                System.out.println("found in Suggest, the whole word");
		        }else{
		            System.out.println("NOT found in Suggest, the whole word");
		        }
		    }
		}
		
	}
	
     private static boolean search(String word){
	    Node node = root;
	    for(int i =0; i< word.length(); i++){
	        if(!node.containsKey(word.charAt(i))){
	            // if the key itself does not exist no sense, return false
	            return false;
	        }
	        // keep going ahead with the help of pointers
	        node = node.get(word.charAt(i));
	    }
	    
	    // once the word has been checked completely, here its' search so the whole word should exits
	    if(node.isEnd()){
	        return true;
	    }
	    return false;
	}
	
	private static boolean  startsWith( String word){
	    Node node = root;
	    
	    for(int i=0; i < word.length(); i++){
	        if(!node.containsKey(word.charAt(i))){
	            return false;
	        }
	        
	        // always remember t move forward too
	        node = node.get(word.charAt(i));
	    }
	    
	    return true;
	}
}
