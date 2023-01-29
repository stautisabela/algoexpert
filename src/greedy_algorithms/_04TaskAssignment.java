/*
You're given an integer k representing a number of workers and an array of positive integers representing durations of
tasks that must be completed by the workers. Specifically, each worker must complete two unique tasks and can only work
on one task at a time. The number of tasks will always be equal to 2k, such that each worker always has exactly two
tasks to complete. All tasks are independent of one another and can be completed in any order. Workers will complete
their assigned tasks in parallel, and the time taken to complete all tasks will be equal to the time taken to complete
the longest pair of tasks (see the sample output for an explanation).

Write a function that returns the optimal assignment of tasks to each worker such that the tasks are completed as fast
as possible. Your function should return a list of pairs, where each pair stores the indices of the tasks that should be
completed by one worker. The pairs should be in the following format: [task1, task2], where the order of task1 and task2
doesn't matter. Your function can return the pairs in any order. If multiple assignments exist, any correct answer will
be accepted.

Note: you'll always be given at least one worker (i.e. k will always be greater than 0).

SAMPLE INPUT
k=3
tasks=[1, 3, 5, 3, 1, 4]

SAMPLE OUTPUT
{
    [0,2], task[0] + task[2]
    [4,5],
    [1,3]
}
 */
package greedy_algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class _04TaskAssignment {
    public static void main(String[] args) {

        ArrayList<Integer> test = new ArrayList<>();
        Collections.addAll(test, 1, 3, 5, 1, 4);

        System.out.println(taskAssignment(3, test));
    }

    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        int indexOne, indexTwo;
        ArrayList<ArrayList<Integer>> assignedTasks = new ArrayList<>(k);
        ArrayList<Integer> sortedTasks = new ArrayList<>(tasks.size());
        sortedTasks.addAll(tasks);
        Collections.sort(sortedTasks);

        for(int i=0; i<k; i++) {
            indexOne = tasks.indexOf(sortedTasks.get(i));
            tasks.set(indexOne, null);
            indexTwo = tasks.indexOf(sortedTasks.get(2*k-1-i));
            tasks.set(indexTwo, null);

            ArrayList<Integer> currentTasks = new ArrayList<>();
            currentTasks.add(indexOne);
            currentTasks.add(indexTwo);
            assignedTasks.add(currentTasks);
        }
        return assignedTasks;
    }

}
