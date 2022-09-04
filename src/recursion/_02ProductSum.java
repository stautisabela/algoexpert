/*
Write a function that takes in a "special" array and returns its product sum.

A "special" array is a non-empty array that contains either integers or other "special" arrays. The product sum of a
"special" array is the sum of its elements, where "special" arrays inside it are summed themselves and then multiplied
by their level of depth.

The depth of a "special" array is kow far nested it is. For instance, the depth of [] is 1; the depth of the inner
array in [[]] is 2; the depth of the innermost array in [[[]]] is 3.

Therefore, the product sum of [x,y] is x+y; the product sum of [x,[y,z] is x+2*(y+z); the product of [x,[y,[z]]] is
x+2*(y+3z).
*/
package recursion;


import java.util.ArrayList;
import java.util.List;

public class _02ProductSum {
    public static void main(String[] args) {
    }

//  - Time complexity is O(N) where N is the total number of elements of the array and all subarrays.
//  - Space complexity is O(N) where N is the maximum depth of the array, because of the call stack of the recursive
//  calls.
    private static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }

    private static int productSumHelper (List<Object> array, int depth) {
        int sum = 0;
        for (Object obj : array) {
            if (obj instanceof ArrayList) {
                sum += productSumHelper((List<Object>) obj, depth+1);
                continue;
            }
            sum += (int)obj;
        }
        return sum * depth;
    }
}