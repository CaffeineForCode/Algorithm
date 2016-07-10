/**
 * Created by IntelliJ IDEA.
 * User:mrigankmittal
 * Date:6/17/16
 * Time:1:31 PM
 * Project:Array hopping
 */


/*
Array hopping

Given an input array where each element is the maximum number of hops , program returns the indices of the elements
such that the number of hops taken to traverse the array is minumum.


 */
import java.util.*;
import java.lang.*;


public class ArrayHopping {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        try {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Integer> canyonArray =new ArrayList<>();
            while (scanner.hasNextInt()) {
                int input = scanner.nextInt ();
                canyonArray.add(input);
            }

            ArrayList<String> indeces = new ArrayList<String>();
            indeces = findHopsHelper(canyonArray);
            if(indeces == null){
                System.out.println("Failure");
            }
            else {

                Iterator<String> i = indeces.iterator();
                if (i.hasNext()) {
                    System.out.print(i.next());
                    while (i.hasNext())
                        System.out.print(", " + i.next());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public  static ArrayList<String> findHopsHelper(ArrayList<Integer> array) {
        ArrayList<String> hops = new ArrayList<String>();
        int lReach = 0, curReach = 0, selIndex = 0;
        int i;
        for (i = 0; i < array.size(); i++) {
            // if the index is beyond current reach then just break out
            if (i > curReach) break;
            if (i > lReach) {
                // update last reach
                lReach = curReach;
                hops.add(String.valueOf(selIndex));
            }
            // update current reach
            int sum = i + array.get(i);
            if (sum > curReach) selIndex = i;
            curReach = Math.max(curReach, sum);
        }
        if ((i > lReach) && (hops.size() > 0) && (Integer.parseInt(hops.get(hops.size() - 1)) != selIndex)) {
            // if i was beyond last reach and hops are present then add the last selected index
            hops.add(String.valueOf(selIndex));
        }
        // if last reachable index was greater than or equal to last index of array
        if (lReach >= array.size() - 1)
            // then return the hop indices as hopping is possible
        {
            hops.add("out");
            return hops;
        }
        else
            return null;
    }

}


