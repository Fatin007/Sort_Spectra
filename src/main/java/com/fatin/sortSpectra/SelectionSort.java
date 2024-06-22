package com.fatin.sortSpectra;

/**
 *
 * @author MOHAMMAD FATIN NUR
 */
public class SelectionSort implements Runnable{

    private Integer[] arr;
    private Frame frame;

    public SelectionSort(Integer[] arr, Frame frame) {
        this.arr = arr;
        this.frame = frame;
    }

    public void run() {
        int temp = 0;
        int pos = 0;
        for(int i = 0; i<arr.length; i++){
            pos = i;
            for(int j = arr.length-1; j>i; j--){

                if (arr[j] <= arr[pos]){
                    pos = j;
                }
                frame.reDraw(arr, pos, j-1);
                try {
                    Thread.sleep(Sort_Spectra.wait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            temp = arr[i];
            arr[i] = arr[pos];
            arr[pos]= temp;
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