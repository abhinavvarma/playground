public class  ABBADiv1{
	public String canObtain(String initial, String target) {
        if (check(initial, target))
            return "Possible";
        else
            return "Impossible";
	}

    public boolean check(String initial, String target) {
        int targetLength = target.length();
    	if (target.equals(initial)) {
            return true;
		}
    	
    	if (targetLength==0) {
    		return false;
    	}
    	
        boolean isAAtEnd = target.charAt(targetLength-1) == 'A';
        boolean isBAtStart = target.charAt(0) == 'B';

        if (isAAtEnd) {
        	String t1 = target.substring(0, targetLength-1);
            if (check(initial, t1))
                return true;
        } 
        
        if (isBAtStart) {
        	String t2 = new StringBuilder(target).reverse().toString();
            t2 = t2.substring(0, targetLength-1);
            return check(initial, t2);
        } 
        return false;
    }
    
//    public void test(String initial, String target, boolean result) {
//    	if (check(initial, target)!=result) {
//    		System.out.println("failed");
//    	} else {
//    		System.out.println("passed");
//    	}
//    }
//
//    public static void main(String[] args) {
//    	ABBADiv1 a = new ABBADiv1();
//    	a.test("A", "BABA", true);
//    	a.test("BAAAAABAA", "BAABAAAAAB", true);
//    	a.test("A", "ABBA", false);
//    	a.test("AAABBAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB", true);
//    	a.test("AAABAAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB", false);
//    }
}