public class Levenshtein {
 
    public static int distance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), 
                		a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
    
    
    public static int phraseDistance(String[] a, String[] b) {
    	int distance = -1;
    	boolean match = false;
        int [] costs = new int [b.length + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length; i++) {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length; j++) {
            	if(a[i - 1].equalsIgnoreCase(b[j - 1]))
            	{
            		match = true;
            	}
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), 
                		a[i - 1].equalsIgnoreCase(b[j - 1]) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        if(match)
        {
        	distance = costs[b.length];
        }
        return distance;
    }
 
    public static void main(String [] args) {
//        String [] data = { "kitten", "sitting", "saturday", "sunday", "rosettacode", "raisethysword" };
//        System.out.println("distance(kitten,sitting)= " +  distance("kitten", "sitting"));
//        System.out.println("distance(sa,as)= " +  distance("sa", "as"));
//        System.out.println("distance(saturday,rosettacode)= " +  distance("saturday", "rosettacode"));
//        System.out.println("distance(saturday,saturday)= " +  distance("saturday", "saturday"));
//        
//        for (int i = 0; i < data.length; i += 2)
//            System.out.println("distance(" + data[i] + ", " + data[i+1] + ") = " + distance(data[i], data[i+1]));
    	String[] dict = {
    			"error type",
    			"ws context",
    			"ws enterprise logging",
    			"fault url",
    			"forcecomplete process",
    			
    	};
    	
    	String[] a = {"number"};
    	String[] b = {"telephone", "number"};
    	String[] b3 = {"good","telephone", "number"};
    	String[] a1 = {"bad"};
    	String[] b1 = {"telephone", "number", "good"};
    	System.out.println(phraseDistance(a,b));
    	System.out.println(phraseDistance(a,b3));
    	System.out.println(phraseDistance(a1,b1));
    }
}