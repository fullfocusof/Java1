package main.java;

import main.java.extensions.StringExtension;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while(!exit)
        {
            System.out.print("Выберите действие\n1. Перевод строки\n2. Усекание строки\n3. Другие преобразования строки\n");
            String userChoice = sc.nextLine();

            while (!(userChoice.equals("1") || userChoice.equals("2") || userChoice.equals("3")))
            {
                System.out.print("Введите 1, 2 или 3\n");
                userChoice = sc.nextLine();
            }

            System.out.print("Введите строку: ");
            String userInput = sc.nextLine();
            String result;

            switch (userChoice)
            {
                case "1":
                {
                    System.out.print("Введите разделитель: ");
                    String userDivider = sc.nextLine();

                    if (userDivider.isEmpty()) result = StringExtension.transliteration(userInput);
                    else result = StringExtension.transliteration(userInput, userDivider);

                    System.out.println("Полученный перевод: " + result);
                }
                break;

                case "2":
                {
                    System.out.print("Введите количество символов: ");
                    String userCount = sc.nextLine();

                    if (userCount.isEmpty()) result = StringExtension.truncate(userInput);
                    else result = StringExtension.truncate(userInput, Integer.parseInt(userCount));

                    System.out.println("Полученная строка: " + result);
                }
                break;

                case "3":
                {
                    System.out.print("Выберите действие\n1. Регистр как в предложениях\n2. все буквы строчные\n3. ВСЕ БУКВЫ ПРОПИСНЫЕ\n4. Начинать С Прописных\n5. иЗМЕНИТЬ РЕГИСТР\n");
                    String userChoiceMethodRegisterChange = sc.nextLine();

                    while (!(userChoiceMethodRegisterChange.equals("1") || userChoiceMethodRegisterChange.equals("2") || userChoiceMethodRegisterChange.equals("3") || userChoiceMethodRegisterChange.equals("4") || userChoiceMethodRegisterChange.equals("5")))
                    {
                        System.out.print("Введите 1, 2, 3, 4 или 5\n");
                        userChoiceMethodRegisterChange = sc.nextLine();
                    }

                    switch(userChoiceMethodRegisterChange)
                    {
                        case "1":
                        {
                            System.out.println("Полученная строка: " + StringExtension.toSentenceReg(userInput));
                        }
                        break;

                        case "2":
                        {
                            System.out.println("Полученная строка: " + StringExtension.allLowReg(userInput));
                        }
                        break;

                        case "3":
                        {
                            System.out.println("Полученная строка: " + StringExtension.allUpReg(userInput));
                        }
                        break;

                        case "4":
                        {
                            System.out.println("Полученная строка: " + StringExtension.startWithUp(userInput));
                        }
                        break;

                        case "5":
                        {
                            System.out.println("Полученная строка: " + StringExtension.reverseReg(userInput));
                        }
                        break;

                        default:
                            break;
                    }
                }
                break;

                default:
                    break;
            }

            System.out.print("Завершить работу?\n1. Да\n2. Нет\n");
            String userExit = sc.nextLine();
            while (!(userExit.equals("1") || userExit.equals("2")))
            {
                System.out.print("Введите 1 или 2\n");
                userExit = sc.nextLine();
            }
            exit = Integer.parseInt(userExit) == 1;
        }

        sc.close();
    }
}