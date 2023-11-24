package org.example;

import java.util.*;

/**
 * Pattern:
 * Remove one or more elements from a Collection or List while
 * traversing through its elements using an Iterator.
 * https://www.baeldung.com/java-iterator
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Using Iterator interface to remove item from list while traversing it.");

        List<String> list = new LinkedList<>();
        initialiseList(list);

        ListIterator<String> iter = list.listIterator();   // get iterator on this list

        // Use Iterator instead of ListIterator if we wish to handle any Collection type.


        while(iter.hasNext()) {
            String name = iter.next();
            System.out.println(name +",");
        }
        // TODO search for the word "orange"
        iter = list.listIterator();   // get iterator on this list
        boolean found = false;
        while( iter.hasNext() ) {
            String name = iter.next();
            if("orange".equals(name)){
                found = true;
                break;
            }
        }
        if(found==true)
            System.out.println("Orange was found");
        else
            System.out.println("No orange found");

        // write loop to find an "orange" in the list



        // iterate over the list and remove all "google"s
        iter = list.listIterator();   // get iterator on this list

        while(iter.hasNext()) {
            if( "google".equals(iter.next())) {
                iter.remove();
            }
        }

        System.out.println(list);

        // reset iterator to start of list and apply lambda to remaining elements
        iter = list.listIterator();
        iter.forEachRemaining(System.out::println); // supply lambda to be applied to each element

        // re-initialize list and reset iterator
        list.clear();
        initialiseList( list );

        // attempt to remove "google"s using for/while loops
        // this approach is a bit more cumbersome
        System.out.println("Remove \"google\"s using for loop");
        for(int i=0; i<list.size(); i++)
        {
            if("google".equals(list.get(i))) {
                list.remove(i);
                i--;    // need to decrement the index
            }
        }
        System.out.println(list);
    }

    public static void initialiseList(List<String> list) {
        list.add("google");
        list.add("apple");
        list.add("google");
        list.add("orange");
        list.add("google");
    }
}