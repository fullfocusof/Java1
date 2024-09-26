package main.java.extensions.strategy;

import java.util.regex.Pattern;

public class RegSwitchStartWithUp implements IRegSwitch
{
    @Override
    public String RegSwitchInit(String input)
    {
        String[] words = input.split(Pattern.quote(" "));
        StringBuilder result = new StringBuilder();

        if (!input.isEmpty())
        {
            for (String word : words)
            {
                if (Character.isLowerCase(word.charAt(0)))
                {
                    result.append(Character.toUpperCase(word.charAt(0)));
                    result.append(word.substring(1));
                } else result.append(word);

                if (word != words[words.length - 1]) result.append(" ");
            }
        }

        return result.toString();
    }
}