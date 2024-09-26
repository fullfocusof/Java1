package main.java.extensions.strategy;

public class RegSwitchReverse implements IRegSwitch
{
    @Override
    public String RegSwitchInit(String input)
    {
        StringBuilder result = new StringBuilder();

        for (Character c : input.toCharArray())
        {
            if (Character.isUpperCase(c)) result.append(Character.toLowerCase(c));
            else result.append(Character.toUpperCase(c));
        }

        return result.toString();
    }
}
