//code by: 19sw24
//Description: all sorting algorithms along with execution time of each
// task 01 and 02
public class Task01And02Sorting {

    //    insertion sorting
    public static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int n = i-1;
            while ( n>=0 && arr[n] > temp){
                arr[n+1] = arr[n--];
            }
            arr[n+1] = temp;
        }
    }


//-------------------------------------------------------------------------------------------------------------------------------


    //    bubble sorting
    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j =0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


//--------------------------------------------------------------------------------------------------------------------


    //merger sorting
    public static void mergerSort(int[] arr, int start, int end) {
        if (start< end) {
            //dividing the array into 2 parts
            int mid = (start + end) / 2;

            //recursively subLists of the divided list
            mergerSort(arr,start,mid);
            mergerSort(arr,mid+1,end);

            //merging the subLists
            merge(arr,start,mid,end);
        }
    }

    //merge method for merge sorting
    private static void merge(int[] arr, int start, int mid, int end) {
        int i=start;
        int j= mid+1;
        int k = start;
        int[] temp= new int[arr.length];

        while (i<=mid && j<=end){
            if (arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        if(i>mid){
            while (j<=end) {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        else{
            while (i<=mid) {
                temp[k] = arr[i];
                i++;
                k++;
            }
        }
        //copying the temp array elements into the original array
        int s=start;
        while(s<k){
            arr[s] = temp[s];
            s++;
        }

    }

//-------------------------------------------------------------------------------------------------------------------------------
//------------------ Quick sorting----------------------------------------

    public static void QuickSort(int[] arr, int start, int end){
        int loc;
        if (start < end){
            loc = partition(arr,start,end);
            QuickSort(arr,start,loc-1);
            QuickSort(arr,loc+1,end);
        }
}

    private static int partition(int[] arr, int s, int e) {
        int pivot = arr[s];
        int start=s;
        int end=e;
        while(start<end){

            while(arr[start]<=pivot){
                start++;
            }

            while(arr[end] > pivot){
                end--;
            }
           //when start is less than end position
            if (start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
       // now when end pos is less than start pos we swap the end with pivot
        int temp = arr[s];
        arr[s] = arr[end];
        arr[end] = temp;
        return end;
    }

//-------------------------------------------------------------------------------------------------------------------------------


    public static void display(int[] arr){
        for (int j : arr) {
            System.out.print(j + ",");
        }
    }


//-------------------------------------------------------------------------------------------------------------------------------


    public static void main(String[] args) {
        int[] arr ={23,45,77,1,78,4,95,34,46,11,66,0,34,989,5,88,31,0,91,1,36,6776};
        long initTime = System.nanoTime();

        //Insertion sorting is taking 20300 nanoSec in this program to sort the array
        Task01And02Sorting.InsertionSort(arr);
        System.out.println("Time(nano Sec) taken by Insertion sorting is:" + (System.nanoTime() - initTime));
        Task01And02Sorting.display(arr);

        //bubble sorting is taking 35200 nanoSec in this program to sort the array
        Task01And02Sorting.BubbleSort(arr);
        System.out.println("Time(nano sec) taken by Bubbling sorting is:" + (System.nanoTime() - initTime));
        Task01And02Sorting.display(arr);

        //merge sorting is taking 27000 nanoSec in this program to sort the array
        Task01And02Sorting.mergerSort(arr,0, arr.length-1);
        System.out.println("Time(nano sec) taken by merge sorting is:" + (System.nanoTime() - initTime));
        Task01And02Sorting.display(arr);

        //Quick sorting is taking 28800 nanoSec in this program to sort the array
        Task01And02Sorting.QuickSort(arr,0,arr.length-1);
        System.out.println("Time(nano sec) taken by Quick sorting is:" + (System.nanoTime() - initTime));
        Task01And02Sorting.display(arr);
    }
    /*
    Task 02 Answer:
    ---------------
    As we calculate the time of each sorting algorithm of a particular array, each gives us a different execution time
   -> The fast and efficient sorting is 'merge sorting algorithm' among the all because it is less execution time from the others
   -> merge sort is fastest and efficient for larger arrays/elements, while for small array quick sort is more efficient than merge

   Time complexity:
   ----------------
   1) inserting sorting -> O(n^2)
   2) bubble sorting -> O(n^2)
   4) Quick sorting -> O(n log n)
   4) merge sorting -> O(n*log n)

    */
}