package edu.psu.se411.ch05;
import java.util.concurrent.RecursiveAction;

import edu.psu.se411.ch05.algorithms.MergeSort;
import edu.psu.se411.ch05.algorithms.SortTask;

import java.util.concurrent.ForkJoinPool;

public class App {
  public static void main(String[] args) {
    final int SIZE = 7000000;
    int[] list1 = new int[SIZE];
    int[] list2 = new int[SIZE];

    for (int i = 0; i < list1.length; i++)
      list1[i] = list2[i] = (int)(Math.random() * 10000000);

    long startTime = System.currentTimeMillis();
    parallelMergeSort(list1); // Invoke parallel merge sort
    long endTime = System.currentTimeMillis();
    System.out.println("\nParallel time with "
      + Runtime.getRuntime().availableProcessors() + 
      " processors is " + (endTime - startTime) + " milliseconds");

    startTime = System.currentTimeMillis();
    MergeSort.mergeSort(list2); // MergeSort is in Listing 24.5
    endTime = System.currentTimeMillis();
    System.out.println("\nSequential time is " + 
      (endTime - startTime) + " milliseconds");
  }

  public static void parallelMergeSort(int[] list) {
    RecursiveAction mainTask = new SortTask(list);
    ForkJoinPool pool = new ForkJoinPool();
    pool.invoke(mainTask);
  }
}