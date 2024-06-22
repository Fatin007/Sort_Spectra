package com.fatin.sortSpectra;

/**
 *
 * @author MOHAMMAD FATIN NUR
 */
public class InsertionSort implements Runnable{

    public Integer[] arr;
    public Frame frame;

    public InsertionSort(Integer[] arr, Frame frame) {
        this.arr = arr;
        this.frame = frame;
    }

    public void run() {
        int temp = 0;
        int insert = 0;
        for(int i = 1; i<arr.length; i++){
            insert = i;
            for(int j = i-1; j>=0; j--){
                if (arr[i] < arr[j]){
                    insert = j;
                    if (j == 0){
                        break;
                    }
                }else{
                    break;
                }
                frame.reDraw(arr, i, insert);
                try {
                    Thread.sleep(Sort_Spectra.wait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
            }
            temp = arr[i];
            for (int j = i; j>insert; j--){
                arr[j] = arr[j-1];
            }
            arr[insert] = temp;
        }
        frame.finalDraw(arr);
        Sort_Spectra.isSorting=false;
    }
}