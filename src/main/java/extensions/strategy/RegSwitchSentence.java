package main.java.extensions.strategy;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegSwitchSentence implements IRegSwitch
{
    @Override
    public String RegSwitchInit(String input)
    {
        StringBuilder result = new StringBuilder();

        if (!input.isEmpty())
        {
//            Map<Integer, Character> signsID = new HashMap<>();
//            for (Character c : input.toCharArray())
//            {
//                if (c == '.' || c == '!' || c == '?') signsID.put(input.indexOf(c), c);
//            }

            String[] sens = input.split("(?<=[.!?])");
            for (String sentence : sens)
            {
                int firstID = Character.isSpaceChar(sentence.charAt(0)) ? 1 : 0;
                char firstLetter = sentence.charAt(firstID);

                if (firstID == 1) result.append(" ");

                String newSentence = Character.toUpperCase(firstLetter) + sentence.substring(firstID + 1).toLowerCase();
                result.append(newSentence);

//                for (int i = 0; i < result.length(); i++)
//                {
//                    if (signsID.containsKey(i + 1))
//                    {
//                        result.append(signsID.get(i + 1));
//                        signsID.remove(i + 1);
//                        break;
//                    }
//                }
            }
        }

        return result.toString();
    }
}
