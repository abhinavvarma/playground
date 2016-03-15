import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SortWords {

	static String getInputLine() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	static ArrayList<String> toWords(String ip)
	{
		char[] ipChars = ip.toCharArray();
		ArrayList<String> list = new ArrayList<String>();
		int prv=0,cur=0 ;
		while( cur < ipChars.length)
		{
			if(ipChars[cur] != ' ')
				cur++;
			else
			{
				String buf = new String(ipChars,prv,cur-prv);
				list.add(buf);
				prv = ++cur;
			}
		}
		String buf = new String(ipChars,prv,cur-prv);
		list.add(buf);
		return list;
	}
	
	static void quickSort(ArrayList<String> list, int first,int last)
	{
		if(first<last)
		{
			int pivot = first;
			int small = first+1;
			int large = last;
			while(small<=large){
				while(small < list.size() && isBefore(	list.get(small),	list.get(pivot)))
					small++;
				
				while(large > pivot && isBefore(	list.get(pivot),	list.get(large)))
					large--;
				
				if(small<large)
				{
					// exchange small indexed string and large indexed string
					String temp = list.get(small);
					list.set(small, list.get(large));
					list.set(large,temp);
				}
			}
			String temp = list.get(pivot);
			list.set(pivot, list.get(large));
			list.set(large,temp);
			
			quickSort(list, pivot, large-1);
			quickSort(list, large+1, last);
		}
	}

	static boolean isBefore(String first, String second)
	{
		char[] chArr1 = first.toCharArray();
		char[] chArr2 = second.toCharArray();
		int i = 0 , j = 0;
		while(i<chArr1.length && j<chArr2.length)
		{
			int x = chArr1[i];
			int y = chArr2[j];
			if(65 <= x && x <= 90)
				x += 32;
			if(65 <= y && y <= 90)
				y += 32;
			if(x<y)
				return true;
			else if(x>y)
				return false;
			else
			{
				i++;
				j++;
			}
		}
		if(chArr1.length <= chArr2.length) 
			return true ;
		return false;
	}
	
	static String sortWords(String ip)
	{
		ArrayList<String> words = toWords(ip);
		//System.out.println("No. of Words: "+words.size());
		quickSort(words, 0, words.size()-1);
		StringBuffer op = new StringBuffer();
		for(String word:words)
		{
			op.append(word);
			op.append(' ');
		}
		return op.toString();
	}
	
	String joinStrings(ArrayList<String> list)
	{
		StringBuffer sbf = new StringBuffer();
		int size = list.size(),i = 0; 
		while(i<size)
		{
			sbf.append(list.remove(i));
			sbf.append(' ');
			i++;
		}
		return sbf.toString();
	}
	
	static ArrayList<String> toSents(String ip)
	{
		char[] ipChars = ip.toCharArray();
		ArrayList<String> list = new ArrayList<String>();
		int prv=0,cur=0 ;
		while( cur < ipChars.length)
		{
			if(ipChars[cur] != '.')
				cur++;
			else
			{
				String buf = new String(ipChars,prv,cur-prv);
				list.add(buf);
				prv = ++cur;
				while(prv < ipChars.length && ipChars[prv+1] != ' ')	prv++;
			}
		}
		String buf = new String(ipChars,prv,cur-prv);
		list.add(buf);
		return list;
	}
	
	static String sortPara(String ip)
	{
		ArrayList<String> sents = toSents(ip);
		for(int i = 0 ; i< sents.size(); i++)
		{
			String sortedSent = sortWords(sents.get(i));
			sents.set(i, sortedSent);
		}
		quickSort(sents, 0, sents.size()-1);
		StringBuffer op = new StringBuffer();
		for(String sent : sents)
		{
			op.append(sent);
			op.append('\n');
		}
		return op.toString();
	}

	public static void main(String args[])
	{
		long st = System.currentTimeMillis();
		try {
			System.out.println("Enter input: ");
			String ip = getInputLine();
			System.out.println("String with sorted order of its words: ");
			System.out.println(sortPara(ip));
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("Done in: "+ (end-st));
	}
}
