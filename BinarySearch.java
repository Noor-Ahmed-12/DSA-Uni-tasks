public class BinarySearch {

//    binary search in java using compareTo
    public static int BinarySearchArray(Comparable target1,Comparable[] a,int left,int right){
        if (left>right) return 0;
        int l=left;
        int r=right;
        while(l<=r){
            int m = (l+r)/2;
            int comp1 = target1.compareTo(a[m]);
            if (comp1==0 ) return m;
            else if (comp1< 0) return r=m-1;
            else return l=m+1;
        }
        return 0;
    }
    public static int RecursiveBinarySearch(Comparable target,Comparable[] a, int left,int right){
        if (left>right) return 0;
        int m = (left+right)/2;
        int comp = target.compareTo(a[m]);
        if (comp==0) return m;
        else if (comp<0) return RecursiveBinarySearch(target,a,left,m-1);
        else{
            return RecursiveBinarySearch(target,a,m+1,right);
        }
    }

    public static void main(String[] args) {
        Comparable[] arr ={1,15,33,42,45,67,73,75,77,89,95};
//        System.out.println(BinarySearch.BinarySearchArray(89,arr,0,arr.length));
//        System.out.println(BinarySearch.RecursiveBinarySearch(34,arr,0,arr.length));

        //  paper question
        System.out.println(BinarySearch.BinarySearchArray(95,arr,0,arr.length));
        System.out.println(BinarySearch.BinarySearchArray(47,arr,0,arr.length));
    }
}