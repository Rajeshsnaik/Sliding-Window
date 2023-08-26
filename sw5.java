//Longest Substring With K Unique Characters | Variable Size Sliding Window
import java.util.HashMap;

public class sw5 {
    public static void main(String[] args) {
        String S= "aabacbebebe";
        int k =3;
        System.out.println(MaxSubtringSizeK(S,k));
   }
//function to return the answer:
  public static int MaxSubtringSizeK(String s, int k ){
        int len = s.length();
        int answer=-1,i=0,j=0;
        HashMap<Character,Integer> hm = new HashMap<>(); // Map to store the frequency of each character 
      
       while (j<len){
            //Sliding window Calculations
            char ch = s.charAt(j);
            //get the frequency of ch from Map and then increase it by 1 in the map.
            int chFrequencyInMap =   hm.getOrDefault(ch,0);
            hm.put(ch, chFrequencyInMap+1); //increase the frequency of current character in Map
           
            //Sliding Window Condition: hashmap.size = k  [OR number of Unique Characters =k];
            if (hm.size()>k){  /*Reduce the frequency of ith element by 1 and remove it from map if frequency becomes 0.
                                                 Keep doing above [reducing window size] till hm.size becomes <=k  */
                while(hm.size()>k){
                    char iChar = s.charAt(i);
                    int freqiChar = hm.get(iChar);
                    hm.put(iChar, freqiChar-1);
                    if (hm.get(iChar)==0)
                        hm.remove(iChar);
                    i++;
                }
            }

            if(hm.size() == k){ //unique chars = k , compute candidate answer.
                int currentAns = j-i+1;
                answer = Math.max(answer,currentAns);
            }

            j++; // increase window size and look for next window where sum = target
        }
        return answer;
  
 }
}
