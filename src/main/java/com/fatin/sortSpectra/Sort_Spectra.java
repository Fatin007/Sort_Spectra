package com.fatin.sortSpectra;

import java.util.*;
public class Sort_Spectra {
        private static Thread sortingThread;
        public static Frame frame;
        public static Integer[] arr;
        public static boolean isSorting = false;
        public static int cnt = 15;
        public static int wait = 30;
        public static int barWidth;
    
        public static void main(String[] args) {
            frame = new Frame();
            createArr();
        }
    
        public static void createArr(){
            if (isSorting) return;
            arr = new Integer[cnt];
            barWidth = (int) Math.floor(500/cnt);
            for(int i = 0; i<arr.length; i++){
                arr[i] = i+1;
            }
            ArrayList<Integer> shuff = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                shuff.add(arr[i]);
            }
            Collections.shuffle(shuff);
            arr = shuff.toArray(arr);
            frame.Draw(arr);
        }
    
        public static void startSort(String type){
            if (sortingThread == null || isSorting==false){
                createArr();
                isSorting = true;
                switch(type){
                    case "Bubble Sort":
                        sortingThread = new Thread(new BubbleSort(arr, frame));
                        break;
    
                    case "Selection Sort":
                        sortingThread = new Thread(new SelectionSort(arr, frame));
                        break;
    
                    case "Insertion Sort":
                        sortingThread = new Thread(new InsertionSort(arr, frame));
                        break;
    
                    default:
                        isSorting = false;
                        return;
                }
                sortingThread.start();
            }
        }
    
    }