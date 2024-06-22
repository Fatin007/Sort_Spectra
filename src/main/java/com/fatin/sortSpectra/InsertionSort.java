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
        int pos = 0;
        for(int i = 1; i<arr.length; i++){
            pos = i;
            for(int j = i-1; j>=0; j--){
                if (arr[i] < arr[j]){
                    pos = j;
                    if (j == 0){
                        break;
                    }
                }else{
                    break;
                }
                frame.reDraw(arr, i, pos);
                try {
                    Thread.sleep(Sort_Spectra.wait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
            }
            temp = arr[i];
            for (int j = i; j>pos; j--){
                arr[j] = arr[j-1];
            }
            arr[pos] = temp;
        }
        for(int i = 0; i<arr.length; i++){
            frame.finalDraw(arr, i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Sort_Spectra.isSorting=false;
    }
}