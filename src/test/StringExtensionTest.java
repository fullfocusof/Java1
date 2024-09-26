package test;

import main.java.extensions.StringExtension;

import main.java.extensions.strategy.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class StringExtensionTests
{
    @Nested
    @Order(1)
    class translitTests
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
    }

    @Nested
    @Order(1)
    class truncateTests
    {
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
            assertEquals("А", StringExtension.truncate("А         ", 3));
        } //

        @Test
        void truncateInputShorterThanCount()
        {
            assertEquals("Hello", StringExtension.truncate("Hello", 10));
        } //
        @Test
        void truncateInputShorterThanCount1()
        {
            assertEquals("Hello jdx...", StringExtension.truncate("Hello jdx      fhjdf", 10));
        } //

        @Test
        void truncateInputEqualToCount()
        {
            assertEquals("Hello", StringExtension.truncate("Hello", 5));
        } //

        @Test
        void truncateInputOnlySpaces()
        {
            assertEquals("", StringExtension.truncate("     ", 5));
        } //

        @Test
        void truncateEmptyInput()
        {
            assertEquals("", StringExtension.truncate("", 5));
        } //

        @Test
        void truncateCountZero()
        {
            assertEquals("...", StringExtension.truncate("Hello", 0));
        }

        @Test
        void truncateCountNegative()
        {
            assertEquals("...", StringExtension.truncate("Hello", -1));
        } // exception
    }
}

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class SwitchRegTests
{
    RegSwitchInterraction curAlgo = new RegSwitchInterraction();

    @Nested
    @Order(1)
    class SentenceTests
    {

       // @BeforeEach


        @Test
        void toSentenceRegEmptyInput()
        {
            String input = "";
            curAlgo.setRegSwitch(new RegSwitchSentence());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("", result);
        }

        @Test
        void toSentenceRegCommon()
        {
            String input = "this is test.";
            curAlgo.setRegSwitch(new RegSwitchSentence());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("This is test.", result);
        }

        @Test
        void toSentenceRegNoDot()
        {
            String input = "this is test";
            curAlgo.setRegSwitch(new RegSwitchSentence());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("This is test", result);
        }

        @Test
        void toSentenceRegSentences()
        {
            String input = "this IS tEsT. And HellO, World";
            curAlgo.setRegSwitch(new RegSwitchSentence());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("This is test. And hello, world", result);
        }

        @Test
        void toSentenceRegSigns()
        {
            String input = "наследование - это не полиморфизм. Но это Не вАжНо! как насчет того чтобы что?";
            curAlgo.setRegSwitch(new RegSwitchSentence());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("Наследование - это не полиморфизм. Но это не важно! Как насчет того чтобы что?", result);
        }
    }

    @Nested
    @Order(2)
    class AllLowTests
    {
        @Test
        void toAllLowRegEmptyInput()
        {
            String input = "";
            curAlgo.setRegSwitch(new RegSwitchAllLow());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("", result);
        }

        @Test
        void toAllLowRegCommon()
        {
            String input = "ThIs Is TeSt.";
            curAlgo.setRegSwitch(new RegSwitchAllLow());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("this is test.", result);
        }

        @Test
        void toAllLowRegAllUp()
        {
            String input = "THIS IS TEST";
            curAlgo.setRegSwitch(new RegSwitchAllLow());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("this is test", result);
        }

        @Test
        void toAllLowRegNoChange()
        {
            String input = "-1/0#56";
            curAlgo.setRegSwitch(new RegSwitchAllLow());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("-1/0#56", result);
        }
    }

    @Nested
    @Order(3)
    class AllUpTests
    {
        @Test
        void toAllUpRegEmptyInput()
        {
            String input = "";
            curAlgo.setRegSwitch(new RegSwitchAllUpp());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("", result);
        }

        @Test
        void toAllUpRegCommon()
        {
            String input = "ThIs Is TeSt.";
            curAlgo.setRegSwitch(new RegSwitchAllUpp());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("THIS IS TEST.", result);
        }

        @Test
        void toAllUpRegAllLow()
        {
            String input = "this is test";
            curAlgo.setRegSwitch(new RegSwitchAllUpp());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("THIS IS TEST", result);
        }

        @Test
        void toAllUpRegNoChange()
        {
            String input = "";
            curAlgo.setRegSwitch(new RegSwitchAllUpp());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("", result);
        }
    }

    @Nested
    @Order(4)
    class ReverseTests
    {
        @Test
        void toReverseRegEmptyInput()
        {
            String input = "";
            curAlgo.setRegSwitch(new RegSwitchReverse());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("", result);
        }

        @Test
        void toReverseRegAllUpper()
        {
            String input = "HELLO";
            curAlgo.setRegSwitch(new RegSwitchReverse());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("hello", result);
        }

        @Test
        void toReverseAllLow()
        {
            String input = "hello";
            curAlgo.setRegSwitch(new RegSwitchReverse());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("HELLO", result);
        }

        @Test
        void toReverseMixed()
        {
            String input = "hElLo";
            curAlgo.setRegSwitch(new RegSwitchReverse());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("HeLlO", result);
        }
    }

    @Nested
    @Order(5)
    class StartWithUpTests
    {
        @Test
        void toStartWithUpRegEmptyInput()
        {
            String input = "";
            curAlgo.setRegSwitch(new RegSwitchStartWithUp());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("", result);
        }

        @Test
        void toStartWithUpRegStartWithLow()
        {
            String input = "hello";
            curAlgo.setRegSwitch(new RegSwitchStartWithUp());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("Hello", result);
        }

        @Test
        void toStartWithUpRegSentences()
        {
            String input = "hello, and my name is. John. sena...";
            curAlgo.setRegSwitch(new RegSwitchStartWithUp());
            String result = curAlgo.executeRegSwitch(input);
            assertEquals("Hello, And My Name Is. John. Sena...", result);
        }
    }
}