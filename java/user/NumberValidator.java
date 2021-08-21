package user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator {
    private final String acceptValue1 = "\\D\\d{3}\\D\\s\\d{3}[-]\\d{4}";
    private final String acceptValue2 = "\\d{3}[-]\\d{3}[-]\\d{4}";
    private final String fileDirectory = "src\\main\\resources\\file3.txt";
    private ArrayList<String> number = new ArrayList<>();

    public ArrayList<String> getLineList() {
        ArrayList<String> list = new ArrayList<>();

        try (FileReader file = new FileReader(fileDirectory)) {
            BufferedReader br = new BufferedReader(file);
            String line;
            while ((line = br.readLine()) != null) {
                if (isNumber(line)) {
                    list.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println("File directory in not correct!" + e);
        }
        return list;
    }

    private boolean isNumber(String number) {
        Pattern numberExample1 = Pattern.compile(acceptValue1);
        Pattern numberExample2 = Pattern.compile(acceptValue2);

        Matcher matcher1 = numberExample1.matcher(number);
        Matcher matcher2 = numberExample2.matcher(number);
        return matcher1.find() || matcher2.find();
    }

    @Override
    public String toString() {
        return "NumberValidator{" +
                "number=" + number +
                '}';
    }
}
