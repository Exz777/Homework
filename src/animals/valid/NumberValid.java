package animals.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValid {
    public boolean isNumber(String numberStr, Pattern pattern) {
        Matcher matcher = pattern.matcher(numberStr);
        return matcher.find();
    }
}