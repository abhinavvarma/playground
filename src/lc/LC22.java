package lc;

import java.util.*;

public class LC22 {
//    private List<String> generate(int n) {
//        if (n==0){
//            return Collections.singletonList("");
//        }
//        List<String> components = generate(n - 1);
//        for (int i = 0; i < components.size(); i++) {
//            String comp = components.get(i);
//
//        }
//    }

    public static void main(String[] args) {
        String[] r1 = {"()()()()","(()())()","(()(()))","()()(())","(((())))","(())()()","()((()))","()(())()","()(()())","(()()())","((()()))","((()))()","((())())"};
        String[] r2 = {"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};
        Set<String> s1 = new HashSet<>(Arrays.asList(r1));
        Set<String> s2 = new HashSet<>(Arrays.asList(r2));
        s2.removeAll(s1);
        System.out.println(s2);
    }
}
