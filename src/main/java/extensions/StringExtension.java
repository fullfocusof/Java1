package main.java.extensions;

import java.util.HashMap;
import java.util.Map;

public class StringExtension
{
    private static final Map<Character, String> dict = new HashMap<>();

    static {
        String[] rusLower = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м",
                "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ",
                "ъ", "ы", "ь", "э", "ю", "я"};

        String[] rusUpper = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л",
                "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч",
                "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я"};

        String[] eng = {"a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "k", "l",
                "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "c", "ch",
                "sh", "sh'", "", "i", "", "e", "yu", "ya"};

        for (int i = 0; i < rusLower.length; i++)
        {
            dict.put(rusLower[i].charAt(0), eng[i]);
            if (!eng[i].isEmpty()) dict.put(rusUpper[i].charAt(0), eng[i].substring(0, 1).toUpperCase() + eng[i].substring(1));
            else dict.put(rusUpper[i].charAt(0), eng[i]);
        }
    }

    public static String transliteration(String input, String divider)
    {
        StringBuilder result = new StringBuilder();

        for (Character c : input.toCharArray())
        {
            String transChar = dict.get(c);
            if (transChar != null) result.append(transChar);
            else result.append(c);
        }

        return result.toString().replaceAll(" ", divider);
    }

    public static String transliteration(String input)
    {
        return transliteration(input, " ");
    }

    public static String truncate(String input, int count)
    {
        StringBuilder result = new StringBuilder(input);

        if (count <= input.length()) result.delete(result.length() - count, result.length());
        else result.delete(0, result.length());

        if (!result.isEmpty())
        {
            while (result.charAt(result.length() - 1) == ' ') // ???
            {
                result.delete(result.length() - 1, result.length());
            }
        }

        return result + "...";
    }

    public static String truncate(String input)
    {
        return truncate(input, 16);
    }
}