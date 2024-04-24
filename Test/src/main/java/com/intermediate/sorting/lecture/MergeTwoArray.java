package com.intermediate.sorting.lecture;

public class MergeTwoArray {
    public void merge(int[] A, int[] B) {
      int lenA= A.length;
      int lenB = B.length;
      int[] C = new int[lenA + lenB];
      int i = 0,j=0,k=0;
      while(i<lenA && j < lenB) {
          if(A[i]<= A[j]) {
              C[k] = A[i];
              i++;k++;
          } else {
              C[k] = A[j];
              j++;k++;
          }
      }
      while (i<lenA) {
          C[k] = A[i];
          i++;k++;
      }
      while (j<lenB) {
          C[k] = A[j];
          j++;k++;
      }
    }
}
