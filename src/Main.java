import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = getPersons();

        // Filter
        List<Person> males = persons.stream().filter(a -> Gender.MALE.equals(a.getGender())).collect(Collectors.toList());
        System.out.println("List of males in person " + males);

        // Sort by a key in ASC
        List<Person> sortedByAge = persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        System.out.println("Persons sorted by age = " + sortedByAge);

        // Sort by a key in DESC
        List<Person> reverseSorted = persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
        System.out.println("Persons sorted by age in desc order " + reverseSorted);

        // Sort by multiple keys
        List<Person> sorted = persons.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender)).collect(Collectors.toList());
        System.out.println("Persons sorted based on age and Gender");

        // Group By
        Map<Gender, List<Person>> personGroupByGender = persons.stream().collect(Collectors.groupingBy(Person::getGender));
        personGroupByGender.forEach((gender, personList) -> {
            System.out.println(gender);
            personList.forEach(System.out::println);
            System.out.println();
        });

        // Min
        Optional<Person> minAgePerson = persons.stream().min(Comparator.comparing(Person::getAge));
        System.out.println("Min age person " + minAgePerson);

        // Max
        Optional<Person> maxAgePerson = persons.stream().max(Comparator.comparing(Person::getAge));
        System.out.println("Max age person = " + maxAgePerson);

        // All match
        boolean allMatch = persons.stream().allMatch(a -> a.getAge() > 10);
        System.out.println("all person greater than age 10 check = " + allMatch);

        // Any match
        boolean anyMatch = persons.stream().allMatch(a -> a.getAge() > 100);
        System.out.println("any person greater than age 100 check = " + anyMatch);

        // None match
        boolean noneMatch = persons.stream().noneMatch(a -> "Raj".equals(a.getName()));
        System.out.println("No person match with name Raj check = " + noneMatch);

        // Find First
        Optional<Person> firstPersonAfterFilter = persons.stream().filter(person -> person.getAge() > 10).findFirst();
        System.out.println(firstPersonAfterFilter);

        // find any element from a stream
        Optional<Person> randomPerson = persons.stream().findAny();
        System.out.println(randomPerson);

        // count no of elements in the stream
        long count = persons.stream().filter(person -> person.getAge() > 20).count();
        System.out.println("persons count for age greater than 20 = " + count);

        // map elements of a stream
        Set<Integer> distinctAges = persons.stream().map(Person::getAge).collect(Collectors.toSet());
        System.out.println(distinctAges);

        // toArray
        Person[] personArray = persons.stream().toArray(Person[]::new);
        System.out.println(personArray);

    }

    private static List<Person> getPersons() {
        return Arrays.asList(
                new Person("Rahul", 19, Gender.MALE),
                new Person("Ravi", 23, Gender.MALE),
                new Person("Rakhi", 21, Gender.FEMALE),
                new Person("Rajesh", 22, Gender.MALE),
                new Person("Ravina", 22, Gender.FEMALE)
        );
    }

}