package org.example;

import junit.framework.Assert;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class TestSteps {

    private String randomString;
    private String sortedRandomString;

    public TestSteps getRandomString() {
        String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        randomString = salt.toString();
        return this;
    }

    public TestSteps sortTheRandomString(){
        char[] array = randomString.toCharArray();
        Arrays.sort(array);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : array) {
            stringBuilder.append(c);
        }
        sortedRandomString = stringBuilder.toString();
        return this;
    }

    public void verifyStringIsSorted(){
        System.out.println(randomString);
        System.out.println(sortedRandomString);

        String expectedSortString = randomString.chars()
                .mapToObj(i -> String.valueOf((char) i))
                .sorted()
                .collect(Collectors.joining());

        System.out.println(expectedSortString);

        Assert.assertEquals(
                "ahhaaha",
                sortedRandomString
        );
    }

}
