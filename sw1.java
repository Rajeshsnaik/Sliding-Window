//Maximum Sum Subarray of size K | Sliding Window
public class sw1
{
    
	public static void main(String[] args) {
	    int[] arr= new int[]{100,200,300,400};
        int size=2;
	    System.out.println("sum of "+ size +" consecutive numbers :"+window(arr,size));
	}
    public static int window(int[] arr, int k){
        int i=0,j=0;
        int maxcurr=0;
        int maxsum=Integer.MIN_VALUE;
        
        while(j<arr.length){
            maxcurr=maxcurr+arr[j];
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                maxsum=Math.max(maxsum,maxcurr);
                maxcurr=maxcurr-arr[i];
                j++;
                i++;
            }
        }
            return maxsum;
    }
}
