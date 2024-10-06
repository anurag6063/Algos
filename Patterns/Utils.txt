package patterns;

import java.util.*;
import java.util.stream.IntStream;

public class Utils
{
    int[] array;
    int[][] array2D;
    ArrayList < Integer > arrayListInt;
    ArrayList < Character > arrayListChar;
    Stack < Character > stackChar;
    ArrayDeque < Integer > stackDQInt;

    public static void main (String[]args)
    {

        Utils Utils = new Utils ();

        Utils.mathFunctions ();
        Utils.IntegerFunc();
        Utils.createStack ();
        Utils.stackFunctions ();

        Utils.createArrayListInt ();
        Utils.createPrimitiveArray1D ();
        Utils.createPrimitiveArray2D ();


        Utils.sorting ();
        Utils.convertType ();



    }

    private void IntegerFunc() {

        // when i want to have to use Math.max on a initial value use Integer.MIN_VALUE.
        int min = Integer.MIN_VALUE;
        int maxNo = Math.max(min, 0);
        System.out.println(maxNo);

        // reverse
        int max = Integer.MAX_VALUE;
        int minNo = Math.min(max, 20); // min and max side by side
        System.out.println("min "+minNo);

    }

    private void convertType ()
    {

        arrayListInt.add (-10);
        // here i cannot convert directly to int[] will throw error. It needs Class only. Integer/Character
        Integer[]fromColl = arrayListInt.toArray (new Integer[0]);	// if i put a larger than actual no of elements, it will leave them as null and
        // that is causing NullPointerException in soring
        System.out.println ("fromColl = " + Arrays.toString (fromColl));
        Arrays.sort (fromColl);
        System.out.println ("post sorting :" + Arrays.toString (fromColl));

        // -- array to collection - with constructor and just give it a list
        Collection < Integer > fromArr =
                new ArrayList <> (Arrays.asList (fromColl));
        fromArr.add (-40);
        System.out.println (" coll from array " + fromArr);


        // from string to array a charArray
        String a = "anurag";
        char[] chars = a.toCharArray ();
        System.out.println ("char array = " + Arrays.toString (chars));
        // now this char array can be used to do indexed operations.

        // char array to String
        System.out.println ("string from char array: " + String.valueOf (chars));

        // ASCII value of a Character
        System.out.println ('a' - 0);
        System.out.println ('z' - 'a');	// to get index of z wrt to a; a ->0 to z -> 25, total 26 chars
        System.out.println ('a' - 'a');



    }

    private void createPrimitiveArray2D ()
    {
        array2D = new int[4][2];
        Random random = new Random ();
        // Arrays.setAll(array2D, row -> IntStream.range(0, cols).map(col -> random.nextInt(100)).toArray());
        Arrays.setAll (array2D,
                row->IntStream.range (0,2).map (col->random.nextInt (100)).
                        toArray ());
// #Understand
        Arrays.setAll(array2D, row -> IntStream.range(0,5).map(col -> random.nextInt(100)).toArray());

        System.out.println ("2 D Array - " + Arrays.deepToString (array2D));
    }
    private void createPrimitiveArray1D ()
    {
        // we need to define the size too intially
        array = new int[10];
        array[0] = 91;
        array[1] = 92;
        array[1] = 2;

        // another direct way of creating primitive 1D array
        int[] array2 = new int[]{1,3,1,64,3,4};
        System.out.println ("array 2 : "+Arrays.toString (array2));

        // with array syso does not works
        System.out.println (array);

        // rather i need to use arrays.toString
        System.out.println (Arrays.toString (array));

    }

    private void sorting ()
    {

        // simplest way
        Collections.sort (arrayListInt);
        System.out.println ("array list after sorting: " + arrayListInt);
        //
        Collections.sort(arrayListInt, Comparator.reverseOrder());
        // or
        arrayListInt.sort(Comparator.reverseOrder());
        System.out.println ("array list after sorting in reverse: " + arrayListInt);

        System.out.println ("again - " + Arrays.toString (array));
        Arrays.sort (array);
        // since i had not filled other values it had 0 and by natural sorting 0 came first.
        System.out.println ("array list after sorting: " +
                Arrays.toString (array));

        // 2 D array sorting
        Arrays.sort (array2D, (a, b)->Integer.compare (a[1], b[1]));
        Arrays.sort (array2D, Comparator.comparingInt(a -> a[0]));
        Arrays.sort (array2D, (a, b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        System.out.println ("Sorted 2 D Array - " +
                Arrays.deepToString (array2D));

    }


    private void createArrayListInt ()
    {

        arrayListInt = new ArrayList <> ();
        arrayListInt.add (1);
        arrayListInt.add (2);
        arrayListInt.add (3);
        arrayListInt.add (4);
        arrayListInt.add (0);
        System.out.println ("----------");
        // with Collections syso words directly
        System.out.println ("create array list is" + arrayListInt);



    }
    private void stackFunctions ()
    {

        // to add elements
        // push
        stackChar.push ('7');
        stackChar.add ('8');		// not the best
        // best way to add elements, does not throws Exception
        Character resBool = stackChar.push ('9');

        // push is a better option.
        // since it's declared in stack class and makes it specific to stack class
        // also with add the return type is the element pushed
        // with push it's true/false
        boolean resAdd = stackChar.add ('8');	// add returns T/F
        Character resAdd2 = stackChar.push ('1');	// push returns back the element pushed

        // since it's character it can accept only one character and here since i am using numbers it can
        // take only till 9. i am doing a wired thing though here. but good to know.
        System.out.
                printf
                        ("Size of stack is %d, pushed into stack - return boolean %c and for add %b \n ",
                                stackChar.size (), resBool, resAdd);

        System.out.printf ("Top element is %c and. now it's removed too \n ",
                stackChar.pop ());
        System.out.printf ("Top element is %c and. but it's not removed  \n",
                stackChar.peek ());

        System.out.
                printf
                        ("Searching element is stack %d \n The search will return the index at which the element is found from the top \n",
                                stackChar.search ('8'));

        System.out.printf ("Now using array Deque \n");
        System.out.printf ("Top element is %d and. now it's removed too \n ",
                stackDQInt.pop ());
        System.out.printf ("Top element is %d and. but it's not removed  \n",
                stackDQInt.peek ());

        // so in stack, either by using stack or arraydqueue, use push, pop and peek

    }
    private void createStack ()
    {
        stackChar = new Stack < Character > ();
        stackChar.push ('1');
        stackChar.push ('2');
        stackChar.push ('3');
        stackChar.push ('4');
        stackChar.push ('5');
        stackChar.push ('6');


        stackDQInt = new ArrayDeque <> ();
        stackDQInt.offer (1);
        stackDQInt.push (2);		// this adds to the back
        stackDQInt.add (3);
        stackDQInt.add (4);
        stackDQInt.add (5);
        stackDQInt.add (6);

        System.out.println (stackDQInt);

    }
    private void mathFunctions ()
    {
        // remember it's Math and not Maths.

        // when need to find power of something
        System.out.println (Math.pow (2, 3));	// 2^3 ; 2 raised to the power of 3
        System.out.println (Math.pow (2, 5));	// 32

        // to find the square root.
        // it's the no if which multiplied twice results in the given number.
        // hove not seen much usage of this though.
        System.out.println (Math.sqrt (25));
        System.out.println (Math.sqrt (69));

        // to find the number irrespective of the sigh of it.
        System.out.println (Math.abs (-3));	// 3
        System.out.println (Math.abs (3));	// 3



    }
}
