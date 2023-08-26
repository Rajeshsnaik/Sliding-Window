//first negative number in every window of size k
import java.util.ArrayList;
class sw2{
public static void main(String[] args) {

    int [] arr = {12,-1,-7,8,-25,30,-18,-28};
    ArrayList<Integer> a = sum(0, 0, 3, arr);
    System.out.println(a);
}

static ArrayList<Integer> sum(int start,int end,int k,int[] arr)
{
    ArrayList<Integer> list =new ArrayList<Integer>();
    while (end < arr.length)
    {
// if given number is negative then add it into given list
        if(arr[end]<0)
        {
            list.add(arr[end]);
        }

        if((end - start +1)<k)
        {
            end++;
        }
        else if((end - start +1) == k)
        {
//  If list is empty then print zero
            if(list.size()==0)
            {
                System.out.println(0);
            }
            else
            {
                if(arr[start]==list.get(0))
                {
                    System.out.println(arr[start]);
                    list.remove(list.get(0));
                }
            }

            start++;
            end++;
        }
    }
    return list;
    
    }
}