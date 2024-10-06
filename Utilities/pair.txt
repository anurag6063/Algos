/*In Java, there is no built-in Pair class like in C++. However, you can create your own 
Pair class by defining a simple class with two fields to hold the pair of values. 
Here is an example of how you can create a Pair class in Java:

```java
*/

public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
/*
```

You can then use this Pair class to store pairs of values like this:

```java
Pair<String, Integer> pair = new Pair<>("Hello", 123);
System.out.println(pair.getFirst()); // Output: Hello
System.out.println(pair.getSecond()); // Output: 123
``` 

This Pair class allows you to store pairs of values of different types in Java, 
similar to the Pair object in C++.
*/