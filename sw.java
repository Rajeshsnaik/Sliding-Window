//Variable Size Sliding Window 
//max sum subarray of size k
class sw
{
    public static void main(String args[]) {
        int[] arr1={4,1,1,1,2,3,5};
        System.out.println(solve(arr1,5));
    }
static int solve(int[] arr,int k)
{
    int mx=0;
 int i=0,j=0,sum=0;
 while(j<arr.length)
 {
    sum+=arr[j];
    if(sum<k)
    {
        j++;
    }
    else if(sum==k)
    {
        mx=Math.max(mx, j-i+1);
        j++;
    }
    else{
        while(sum>k)
        {
            sum-=arr[i];
            i++;
        }
        j++;
    }
 }
return mx;
} 
}