//Longest Substring With Without Repeating Characters | Variable Size Sliding
import java.util.HashMap;

class sw7{
    public static void main(String[] args) {
        String s1= "pwwkew";
        int a=lengthOfLongestSubstring(s1);
        System.out.println(a);
    }
    public static int lengthOfLongestSubstring(String s) {
         int i=0;
        int j=0;
        int max=0;
        HashMap <Character,Integer> map=new HashMap<>();
        while(j<s.length()){
            char c=s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);

            if(map.size()==j-i+1){
                max=Math.max(max,j-i+1);
                j++;
            }
            else if(map.size()<j-i+1){
                while(map.size()<j-i+1){
                    char c2=s.charAt(i);
                    map.put(c2,map.get(c2)-1);
                    if(map.get(c2)==0)
                        map.remove(c2);
                    i++;
                }
                if(map.size()==j-i+1){
                    max=Math.max(max,j-i+1);
                }
                j++;
            }

        }
        return max;
    }
}

