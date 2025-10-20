package edu.psu.se411.ch05.algorithms;

import java.util.concurrent.RecursiveAction;


public class SortTask extends RecursiveAction {
    private final int THRESHOLD = 2;
    private int[] list;

    public SortTask(int[] list) {
      this.list = list;
    }

    @Override
    protected void compute() {
      if (list.length < THRESHOLD)
        java.util.Arrays.sort(list);
      else {
        // Obtain the first half
        int[] firstHalf = new int[list.length / 2];
        System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

        // Obtain the second half
        int secondHalfLength = list.length - list.length / 2;
        int[] secondHalf = new int[secondHalfLength];
        System.arraycopy(list, list.length / 2, 
          secondHalf, 0, secondHalfLength);

        // Recursively sort the two halves, 
        // The invoke() method forks the task and waits for the result, and doesn’t need any manual joining
        invokeAll(new SortTask(firstHalf), 
          new SortTask(secondHalf));

        
        // Merge firstHalf with secondHalf into list
        MergeSort.merge(firstHalf, secondHalf, list);
      }
    }
  }