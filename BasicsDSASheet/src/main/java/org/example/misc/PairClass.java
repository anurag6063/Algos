package BasicsDSASheet.src.main.java.org.example.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class PairClass {

  public static void main(String[] args) {
    System.out.println("Hello World!");
    practice();
    List<Pair> arr = new ArrayList<>();
    arr.add(new Pair(1,1));
    arr.add(new Pair(2,2));
    arr.add(new Pair(3,3));
    System.out.println(arr);

     PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(
         Comparator.comparingInt(Entry::getKey));
     pq.add(new java.util.AbstractMap.SimpleEntry<>(1,1));
     pq.stream().forEach(System.out::println);

//    PriorityQueue<Pair> pq = new PriorityQueue<>();
//    pq.add(new Pair(1,1));
//    pq.stream().forEach(System.out::println);
  }

  static class Pair{
    int key;
    int val;

    Pair(int key, int val){
      this.key = key;
      this.val = val;
    }

    @Override
    public String toString(){
        return "key = " + key + ", val = " + val;
    }
  }

  private static void practice(){
    PriorityQueue<Data> priorityQueue = new PriorityQueue<>((x,y)-> (Integer.compare(x.getK(), y.getK())));
    priorityQueue.add(new Data(11,1));
    priorityQueue.add(new Data(2,2));
    priorityQueue.add(new Data(9,3));

    for(int i =0; i < priorityQueue.size(); i++){
      Data data = priorityQueue.poll();
      System.out.println(data.toString());
    }

    priorityQueue.stream().forEach(System.out::println);
  }

  static class Data{
    int k;
    int v;
    int getK(){
      return this.k;
    }
    int getV(){
      return this.v;
    }
    Data(int k, int v){
      this.k = k;
      this.v = v;
    }
    @Override
    public String toString(){
      return "k = " + k + " v = "+ v;
    }
  }
}