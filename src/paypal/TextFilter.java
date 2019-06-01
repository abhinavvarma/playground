package paypal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.stream.Stream;
import java.util.regex.Pattern;
import java.util.concurrent.atomic.AtomicInteger;

enum PatternType {
    TEST_NAME,
    ACTIVITY_ID
}

enum TestStatus {
    SUCCESS,
    FAILURE
}

class TestResult {
    PatternType testName;
    TestStatus testStatus;
    String activityId;
}

public class TextFilter {
    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public static void main(String[] argv) throws Exception {
        String[] patterns = {
                "\"transactionActivityId\": \"(\\d+)\",",
                "Test Name: (\\w+)",
                "Status: (\\w+)"
        };
        String fileName = "sample.txt";
        AtomicInteger atomicInteger = new AtomicInteger(0);
        try (Stream<String> stream = Files.lines(Paths.get(fileName)))
        {
            stream.forEach(s ->
            {
                atomicInteger.getAndIncrement();
                for (String patternStr : patterns) {
                    Pattern pattern = Pattern.compile(patternStr);
                    Matcher matcher = pattern.matcher(s);
                    while (matcher.find()) {
                        String match = matcher.group();
                        System.out.println(match);
                        String captured = matcher.group(1);
                        if (isInteger(captured)) {
                            System.out.println("https://moneyadmin.msmaster.qa.paypal.com/payment/new/"+captured);
                        }
                        if (match.startsWith("Status")) {
                            System.out.println("----------------------------------------------------------------");
                        }
                    }
                }
            });
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
