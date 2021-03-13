//code by: 19sw24 (Noor Ahmed Shaikh)
//Description: all descending sorting algorithms
// task 03

public class Task03DescendingSorting {

    //    bubble reverse sorting
    public static void BubbleSortRevesre(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j =0; j < arr.length-i-1; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    //    insertion Reverse sorting
    public static void InsertionReverseSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int n = i-1;
            while ( n>=0 && arr[n] < temp){
                arr[n+1] = arr[n--];
            }
            arr[n+1] = temp;
        }
    }



    //merge Reverse sorting
    public static void mergerReverseSort(int[] arr, int start, int end) {
        if (start< end) {
            //dividing the array into 2 parts
            int mid = (start + end) / 2;

            //recursively subLists of the divided list
            mergerReverseSort(arr,start,mid);
            mergerReverseSort(arr,mid+1,end);

            //merging the subLists
            merge(arr,start,mid,end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int i=start;
        int j= mid+1;
        int k = start;
        int[] temp= new int[arr.length];

        while (i<=mid && j<=end){
            if (arr[i] > arr[j]){
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
//------------------------------------------------------------------------------------------------------------
//    quick Reverse sorting

    public static void QuickSort(int[] arr, int start, int end){
        int loc;
        if (start < end){
            loc = partition(arr,start,end);
            QuickSort(arr,start,loc-1);
            QuickSort(arr,loc+1,end);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int s=left;
        for (int i = left; i<right ; i++) {
            if (arr[i] >= pivot){
                int temp = arr[i];
                arr[i] = arr[s];
                arr[s]= temp;
                s++;
            }
        }
        // now when end pos is less than start pos we swap the end with pivot
        int temp = arr[right];
        arr[right] = arr[s];
        arr[s] = temp;
        return s;
    }
//--------------------------------------------------------------------------------------------

    //    display method
    public static void display(int[] arr){
        for (int j : arr) {
            System.out.print(j + ",");
        }
    }


    //    main method
    public static void main(String[] args) {
        int[] arr ={23,45,77,1,78,4,95,45,33,1982,74,9,763,1,686,3,521,6};

        Task03DescendingSorting.BubbleSortRevesre(arr);
        Task03DescendingSorting.display(arr);

        Task03DescendingSorting.InsertionReverseSort(arr);
        Task03DescendingSorting.display(arr);

        Task03DescendingSorting.mergerReverseSort(arr,0, arr.length-1);
        Task03DescendingSorting.display(arr);

        Task03DescendingSorting.QuickSort(arr,0, arr.length-1);
        Task03DescendingSorting.display(arr);
    }
}