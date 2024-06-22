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
        int selected = 0;
        for(int i = 0; i<arr.length; i++){
            selected = i;
            for(int j = arr.length-1; j>i; j--){

                if (arr[j] <= arr[selected]){
                    selected = j;
                }
                frame.reDraw(arr, selected, j-1);
                try {
                    Thread.sleep(Sort_Spectra.wait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            temp = arr[i];
            arr[i] = arr[selected];
            arr[selected]= temp;
        }
        frame.finalDraw(arr);
        Sort_Spectra.isSorting=false;
    }
}