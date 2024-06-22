package com.fatin.sortSpectra;

/**
 *
 * @author MOHAMMAD FATIN NUR
 */
public class BubbleSort implements Runnable{

    public Integer[] arr;
    public Frame frame;

    public BubbleSort(Integer[] arr, Frame frame){
        this.arr = arr;
        this.frame = frame;
    }

    public void run() {
        int temp = 0;
        boolean flg = false;
        for(int i = 0; i<arr.length-1; i++){
            flg = false;
            for(int j = 1; j<arr.length-i; j++){
                if (arr[j-1]> arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j]= temp;
                    flg = true;
                }
                frame.reDraw(arr, j, j+1);
                try {
                    Thread.sleep(Sort_Spectra.wait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!flg) break;
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