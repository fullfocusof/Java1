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

    @Test
    void translitMainTest()
    {
        assertEquals("Shalaginova Nadezhda", StringExtension.transliteration("Шалагинова Надежда", " "));
    }

    @Test
    void translitSubMainTest()
    {
        assertEquals("Murtuzaev Telman Islam ogli", StringExtension.transliteration("Муртузаев Тельман Ислам оглы", " "));
    }

    @Test
    void translitAllUpper()
    {
        assertEquals("ZHAK ZHAN Ruso", StringExtension.transliteration("ЖАК ЖАН Русо", " "));
    }



    @Test
    void truncateCommon()
    {
        assertEquals("39 новых...", StringExtension.truncate("39 новых фич, которые будут доступны в Java 12", 9));
    }

    @Test
    void truncateNoCount()
    {
        assertEquals("39 новых фич, ко...", StringExtension.truncate("39 новых фич, которые будут доступны в Java 12"));
    }

    @Test
    void truncateHaveSpace()
    {
        assertEquals("А...", StringExtension.truncate("А         ", 3));
    }

    @Test
    void truncateInputShorterThanCount()
    {
        assertEquals("Hello...", StringExtension.truncate("Hello", 10));
    }

    @Test
    void truncateInputEqualToCount()
    {
        assertEquals("Hello...", StringExtension.truncate("Hello", 5));
    }

    @Test
    void truncateInputOnlySpaces()
    {
        assertEquals("...", StringExtension.truncate("     ", 5));
    }

    @Test
    void truncateEmptyInput()
    {
        assertEquals("...", StringExtension.truncate("", 5));
    }

    @Test
    void truncateCountZero()
    {
        assertEquals("...", StringExtension.truncate("Hello", 0));
    }

    @Test
    void truncateCountNegative()
    {
        assertEquals("...", StringExtension.truncate("Hello", -1));
    }




    @Test
    void toSentenceRegEmptyInput()
    {
        assertEquals("", StringExtension.toSentenceReg(""));
    }

    @Test
    void toSentenceRegCommon()
    {
        assertEquals("This is test.", StringExtension.toSentenceReg("this is test."));
    }

    @Test
    void toSentenceRegNoChange()
    {
        assertEquals("This is test", StringExtension.toSentenceReg("This is test"));
    }

    @Test
    void toSentenceReg()
    {
        assertEquals("", StringExtension.toSentenceReg(""));
    }



}
