class Search{
    public static int search(int[] arr,int a){
        int left=0,right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==a)
                return mid;

            if(arr[left]<=arr[mid]){
                if(a>arr[left] && a<arr[mid]){
                    right=mid-1;
                }
                else
                    left=mid+1;
            }
            else{
                if(a>arr[mid] && a<arr[right]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }

        }
        return -1;
    }
    public static void main(String args[]){
        int[] ar={4,5,6,7,0,1,2};
        int tar=2;
        System.out.println(search(ar,tar));
    }
}