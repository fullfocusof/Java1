package test;

import main.java.extensions.StringExtension;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringExtensionTest
{
    @Test
    void translitCommon()
    {
        assertEquals("Argumentii>>Klavin", StringExtension.transliteration("Аргументий Клавин", ">>"));
    }

    @Test
    void translitNoDiv()
    {
        assertEquals("Argumentii Klavin", StringExtension.transliteration("Аргументий Клавин"));
    }

    @Test
    void translitNoDictSymbols()
    {
        assertEquals("1234!@#", StringExtension.transliteration("1234!@#", "]]"));
    }

    @Test
    void translitEmptyInput()
    {
        assertEquals("", StringExtension.transliteration("", "]]"));
    }

    @Test
    void translitDiffAlphabet()
    {
        assertEquals("Hello,+mir!", StringExtension.transliteration("Hello, мир!", "+"));
    }



}
