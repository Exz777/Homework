package animals.valid;

import java.util.Locale;

public class ListValid {
    public boolean isCommValid(String commStr, Enum[] listData) {
        for (Enum command : listData) {
            if (command.name().equals(commStr.toUpperCase(Locale.ROOT).trim())) {
                return true;
            }
        }
        return false;
    }
}