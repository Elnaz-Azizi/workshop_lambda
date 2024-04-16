package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /*
       TODO:  1.	Find everyone that has firstName: “Erik” using findMany().
    */
    public static void exercise1(String message) {
        System.out.println(message);
        List<Person> erikList = storage.findMany(person -> person.getFirstName().equals("Erik"));
        System.out.println("People with the first name 'Erik'");
        erikList.forEach(System.out::println);
    }

    /*
        TODO:  2.	Find all females in the collection using findMany().
     */
    public static void exercise2(String message) {
        System.out.println(message);

        List<Person> femalesList = storage.findMany(person -> person.getGender().equals(Gender.FEMALE));
        System.out.println("Females in the collection:");
        for (Person female : femalesList) {
            String firstName = female.getFirstName();
            System.out.println(firstName);
        }

    }

    /*
        TODO:  3.	Find all who are born after (and including) 2000-01-01 using findMany().
    */


    public static void exercise3(String message) {
        System.out.println(message);
        List<Person> bornAfter2000 = storage.findMany(person -> person.getBirthDate().isAfter(LocalDate.of(1999, 12, 31)));
        System.out.println("People born after equal January 1, 2000. ");
        for (Person person : bornAfter2000) {
            System.out.println(person);
        }

    }

    /*
        TODO: 4.	Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message) {
        System.out.println(message);
        Predicate<Person> findId123 = person -> person.getId() == 123;
        Person personWithId123 = storage.findOne(findId123);
        System.out.println("Person with Id 123: ");
        System.out.println(personWithId123.getFirstName().concat(personWithId123.getLastName()));
    }

    /*
        TODO:  5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message) {
        System.out.println(message);
        Predicate<Person> findId456 = person -> person.getId() == 456;
        Function<Person, String> personToString = person -> "Name: " + person.getFirstName() + " " + person.getLastName() + "  born: " + person.getBirthDate();
        String result = storage.findOneAndMapToString(findId456, personToString);
        System.out.println(result);
    }

    /*
        TODO:  6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message) {
        System.out.println(message);
        Predicate<Person> filteredNamesStartWithE = person -> person.getGender() == Gender.MALE && person.getFirstName().startsWith("E");
        Function<Person, String> persontoString= person -> " Name: " + person.getFirstName() + " " + person.getLastName();
        List<String> resultList= storage.findManyAndMapEachToString(filteredNamesStartWithE, persontoString);
        System.out.println("Male people whose names start with 'E': ");
        System.out.println(resultList);

    }

    /*
        TODO:  7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }
}
