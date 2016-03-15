class  ABBADiv1{
	public String canObtain(String initial, String target) {
        if (check(initial, target))
            return "Possible";
        else
            return "Impossible";
	}

    public boolean check(String initial, String target) {
    	if (target.equals(initial)) {
            return true;
		}
    	
    	if (target.length()==0) {
    		return false;
    	}
    	
        boolean isAAtEnd = target.charAt(target.length()-1) == 'A';
        boolean isBAtStart = target.charAt(0) == 'B';

        if (isAAtEnd) {
        	String t1 = target.substring(0, target.length()-1);
            if (check(initial, t1))
                return true;
        } 
        
        if (isBAtStart) {
        	String t2 = new StringBuilder(target).reverse().toString();
            t2 = target.substring(0, target.length()-1);
            return check(initial, t2);
        } 
        return false;
    }
    
    public static void main(String[] args) {
    	String res = new ABBADiv1().canObtain("A", "BABA");
    	System.out.println(res);
    }
}