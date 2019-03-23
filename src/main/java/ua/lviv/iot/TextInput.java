package ua.lviv.iot;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextInput {

    private String input;
    private Set<String> emailSet;
    private Set<String> domainSet;

    public static String emailPattern = "[a-zA-Z0-9-._]{6,30}@[a-zA-Z]+\\.+[a-zA-Z]{2,6}";
    public static String domainPattern = "@[a-zA-Z]+\\.+[a-zA-Z]{2,6}";

    public TextInput(String input) throws NullPointerException {
        if (input != null) {
            this.input = input;
            emailSet = new HashSet<>();
            domainSet = new HashSet<>();
        } else {
            throw new NullPointerException();
        }
    }


    public Set<String> getDomainSet() {
        return domainSet;
    }


    public void findEmail() {

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            emailSet.add(matcher.group());
        }
    }

    public String findDomains() {

        this.findEmail();

        if (emailSet.size() != 0) {

            Pattern pattern = Pattern.compile(domainPattern);
            Matcher matcher = pattern.matcher(emailSet.toString());
            while (matcher.find()) {
                domainSet.add(matcher.group());
            }

            return domainSet.toString();
        }

        return null;
    }

    public void showResults() {

        System.out.println("Hey, here are all domains I could find:");
        System.out.println(this.findDomains());
    }

}
