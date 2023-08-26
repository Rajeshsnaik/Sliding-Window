import java.util.HashMap;
public class sw6 {

	public static void main(String[] args) {
		// Variable window
		// conditions -> toy ko line se uthana hai aur maximum two type ka toy hi hona chahiye
		// no of unique toy should be two and we should give john max toys
		final String str="abaccab";
		// each character represents a type of toy
		// a-> car
		// b->helicopter
		// c->elephant
		int maxToys= Integer.MIN_VALUE;
		int k=2;
		HashMap<Character,Integer> map= new HashMap<>();
		int i=0,j=0;
		while(j<str.length()) {
			if(map.containsKey(str.charAt(j))) {
				int val= map.get(str.charAt(j));
				map.put(str.charAt(j), val+1);
			}
			else {
				map.put(str.charAt(j), 1);
			}
			
			if(map.size()<k) {
				j++;
			}
			else if(map.size()==k) {
				maxToys= Math.max(maxToys, j-i+1);
				j++;
			}
			else if(map.size()>k) {
				while(map.size()>k) {
					int val= map.get(str.charAt(i));
					val--;
					if(val==0) {
						map.remove(str.charAt(i));
						i++;
					}
					else {
						map.put(str.charAt(i), val);
					}
				}
				j++;
			}
		}
		
		
        System.out.println(maxToys);
	}

}