package amibotnaidra.rpg;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PasswordGenerator {

    private static final String LOWERCASE_CHARACTERS = generateCharacterString('a', 'z');
    private static final String UPPERCASE_CHARACTERS = generateCharacterString('A', 'Z');
    private static final String NUMBERS = generateCharacterString('0', '9');
    private static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";
    private final Random random;

    public PasswordGenerator() {
        random = new Random();
    }

    private static String generateCharacterString(char start, char end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers,
                                   boolean includeSpecialSymbols) {
        StringBuilder passwordBuilder = new StringBuilder();

        String validCharacters = "";
        if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        for(int i = 0; i < length; i++){
            int randomIndex = random.nextInt(validCharacters.length());
            char randomChar = validCharacters.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }

        return passwordBuilder.toString();
    }
}