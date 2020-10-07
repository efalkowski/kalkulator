package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // kalkulator jak dla maupy
    public static void main(String[] args) {
        int firstNumber;
        int secondNumber;
        // Zmieniłbym na calculation, to pojedyńczy wybór. Liczba mnoga w nazwach zmiennych to zazwyczaj mapa/lista/set
        char calculations;

        // Pobieranie pierwszej liczby od uzytkownika
        System.out.println("Podaj pierwsza liczbe: ");
        // raczej nazywaj zmienne które wywodzą się z obiektów wzorując się na samym obiekcie.
        // Dodatkowo zmienne które się nie zmieniają warto też opatrzyć słowem klucz final, nie każdy to praktykuje ale myślę, że to dobra praktyka
        // czyli finalnie ta linia by wyglądała tak
        // final Scanner scanner = new Scanner(System.in);
        Scanner userInterface = new Scanner(System.in);
        // Zazwyczaj w javie jak robisz gdziekolwiek '{}', to trzymasz się takiego formatowania:
        // try {
        // <jakiś kod>
        //} catch {
        // <jakiś kod>
        //}
        // tak samo z warunkowymi if'ami:
        //if (warunek) {
        // <jakiś kod>
        // } else {
        // <jakiś kod>
        // }
        // generalnie Intelij i Android Studio w domyślnych ustawieniach sam Ci sformatuje kod skrótem ( ctrl + alt + L )
        try
        {
            // Intelij podkeśla tu błąd, że wartość nie jest nigdy użyta, zwracaj na to uwagę
            firstNumber = userInterface.nextInt();
            secondNumber = userInterface.nextInt();
        }
        catch (InputMismatchException exception)
        {
            System.out.println("Bledne dane!");
        }
        // Tutaj raczej jedna pusta linia żeby oddzielić kod
        firstNumber = userInterface.nextInt();
        System.out.println("Podaj druga liczbe: ");
        secondNumber = userInterface.nextInt();

        System.out.println("Jakie dzialanie chcesz wykonac? [+] - dodawanie [-] - odejmowanie [*] - mnozenie [/] - dzielenie");

        // Generalnie też, zmienne definiuje się zaraz przed użyciem, chyba że to pola w klasie.
        // w tym wypadku zrobiłbyś tu wtedy odrazu tak:
        // final char calculation = userInterface.next().charAt(0);
        calculations = userInterface.next().charAt(0);
        switch (calculations) {
            case '+': {
                System.out.println(firstNumber + secondNumber);
                break;
            }
            case '-': {
                System.out.println(firstNumber - secondNumber);
                break;
            }
            case '*': {
                System.out.println(firstNumber * secondNumber);
                break;
            }
            case '/': {
                // A co jeśli firstNumber jest zerem? :D
                if (secondNumber !=0)
                {
                    System.out.println(firstNumber / secondNumber);
                }
                else
                {
                    System.out.println("Pamietaj cholero nie dziel przez zero!");
                }
                break;

            } 
            // Przydałby się jeszcze jeden warunek w tym switchu. Co jak ktoś wpisze np. literę czy cyfrę. To też jest char. możesz dodać tutaj
            // default: {
            //  System.out.println("Nie wybrałeś prawidłowego działania.");           
            // }
            // dwie poniższe linie są puste, raczej takiego czegoś też się nie robi, do wyjebania


        }
    }
}

/* generalnie górny fragment kodu myślę, że powinien wyglądać tak jak poniżej.
   scanner.nextInt używałeś raz w try catch raz poza nim, mimo, że potrzebowałeś go użyć tylko raz stąd program pytał kilka razy o pierwszą liczbę :P
   dodałem return; w bloku catch{}, te słowo klucz w tym wypadku zakończy działanie programu. 
    
    public static void main(String[] args) {
        int firstNumber;
        int secondNumber;

        final Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj pierwsza liczbe: ");
        try {
            firstNumber = scanner.nextInt();

        } catch (InputMismatchException exception) {
            System.out.println("Bledne dane! Uruchom program ponownie.");
            return;
        }

        System.out.println("Podaj druga liczbe: ");
        try {
            secondNumber = scanner.nextInt();

        } catch (InputMismatchException exception) {
            System.out.println("Bledne dane! Uruchom program ponownie.");
            return;
        }

        System.out.println("Jakie dzialanie chcesz wykonac? [+] - dodawanie [-] - odejmowanie [*] - mnozenie [/] - dzielenie");

        final char calculation = scanner.next().charAt(0);
        ...
*/


// Może wydziel część tych rzeczy do funkcji lub klas jeszcze, w ramach praktyki.
// np. nie wiem, 2 klasy NumberReader(ma jedną funkcję do zczytywania liczb i tylko liczb) i CalculationTypeReader(zczytuje tylko obsługiwane znaki do przeliczania)
// I wtedy klasa kalkulator już do samego liczenia, w niej funkcję z twoim switch'em byś miał, i przekazywał wszystkie argumenty pozyskane z wcześniejszych 3 obiektów.
// To tylko przykład, ale możesz się tym pobawić. CalculationTypeReader i NumberReader to też podobne klasy, można by się tu pobawić dziedziczeniem i stworzyć
// jeszcze jedną klasę która była by rodzicem tych dwóch klas i w niej wtedy trzymać zmienną ze scanner'em. Warto to zrobić chociażby tylko po to żeby zrozumieć.
