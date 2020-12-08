import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Main
    {
        // Driver program -- Throws IOException when file not there
        public static void main(String args[]) throws IOException
            {
                Scanner fileRead;
                // Name of the directory
                String dirName = "Lab 4 Input Files/";
                File directory = new File(dirName);
                File[] fileArr = directory.listFiles();
                String[] fileNames;

                fileNames = new String[fileArr.length];
                // Get file names, store in array
                for (int p = 0; p < fileArr.length; p++)
                    {
                        fileNames[p] = fileArr[p].getName();
                    }
                int[] nums;
                // Read in file contents and sort per file
                for (int i = 0; i < fileArr.length; i++)
                    {
                        ArrayList<String> line = new ArrayList<String>();
                        fileRead = new Scanner(new BufferedReader(
                                new FileReader(fileArr[i])));

                        while (fileRead.hasNext())
                            {
                                line.add(fileRead.next());
                            }
                        nums = new int[line.size()];
                        for (int q = 0; q < line.size(); q++)
                            {
                                nums[q] = Integer.parseInt(line.get(q));
                            }
                        int arr[] = nums;
                        int n = arr.length;
                        
                        NatMergeSort natMerSort = new NatMergeSort();
                        QuickSort quickSort = new QuickSort();
                        
                        // 0 for Select the first item of the partition as the
                        // pivot.
                        // Treat partitions of size one and two as stopping
                        // cases.
                        // 1 for Select the first item of the partition as the
                        // pivot.
                        // Treat a partition of size 100 as a stopping case.
                        // Use an
                        // insertion sort to finish.
                        // 2 for Select the first item of the partition as the
                        // pivot.
                        // Treat a partition of size 50 as a stopping case.
                        // Use an insertion
                        // sort to finish.
                        // 3 for Select the median-of-three as the pivot.
                        // Treat
                        // partitions of size one and two as stopping cases.
                        int[] hold = arr;
                        // Normal QuickSort
                        long startTime = System.nanoTime();
                        quickSort.sort(arr, 0, n - 1, 0);
                        long endTime = System.nanoTime();
                        long elapsedTime = endTime - startTime;
                        quickSort.printArray(arr, fileNames[i], 0,
                                elapsedTime, i+1);
                        // QuickSort 100
                        arr = hold;
                        startTime = System.nanoTime();
                        quickSort.sort(arr, 0, n - 1, 1);
                        endTime = System.nanoTime();
                        elapsedTime = endTime - startTime;
                        quickSort.printArray(arr, fileNames[i], 1,
                                elapsedTime, i+1);
                        // QuickSort 50
                        arr = hold;
                        startTime = System.nanoTime();
                        quickSort.sort(arr, 0, n - 1, 2);
                        endTime = System.nanoTime();
                        elapsedTime = endTime - startTime;
                        quickSort.printArray(arr, fileNames[i], 2,
                                elapsedTime, i+1);
                        // Median-of-Three QuickSort
                        arr = hold;
                        startTime = System.nanoTime();
                        quickSort.sort(arr, 0, n - 1, 3);
                        endTime = System.nanoTime();
                        elapsedTime = endTime - startTime;
                        quickSort.printArray(arr, fileNames[i], 3,
                                elapsedTime, i+1);
                        // Natural Merge Sort
                        arr = hold;
                        startTime = System.nanoTime();
                        natMerSort.xFer(arr, fileNames[i], startTime, i+1);

                        System.out.println(
                                "No. Files Sorted: " + (i + 1) + "\n");
                    }

            }
    }