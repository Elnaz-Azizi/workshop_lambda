package se.lexicon.data;


import se.lexicon.model.Person;
import se.lexicon.util.PersonGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Create implementations for all methods. I have already provided an implementation for the first method *
 */
public class DataStorageImpl implements DataStorage {

    private static final DataStorage INSTANCE;

    static {
        INSTANCE = new DataStorageImpl();
    }

    private final List<Person> personList;

    private DataStorageImpl() {
        personList = PersonGenerator.getInstance().generate(1000);
    }

    static DataStorage getInstance() {
        return INSTANCE;
    }


    @Override
    public List<Person> findMany(Predicate<Person> filter) {
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (filter.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public Person findOne(Predicate<Person> filter) {
        for (Person person : personList) {
            if (filter.test(person)) {
                return person;
            }
        }
        return null;

    }

    @Override
    public String findOneAndMapToString(Predicate<Person> filter, Function<Person, String> personToString) {
        Optional<Person> result = personList.stream()
                .filter(filter)
                .findFirst();
        return result.map(personToString).orElse(null);
    }

    @Override
    public List<String> findManyAndMapEachToString(Predicate<Person> filter, Function<Person, String> personToString) {
        List<String> resultList=new ArrayList<>();
        for (Person person:personList){
            if (filter.test(person)){
                String mappedString = personToString.apply(person);
                resultList.add(mappedString);
            }
        }
        return resultList;
    }

    @Override
    public void findAndDo(Predicate<Person> filter, Consumer<Person> consumer) {
       personList.stream()
               .filter(filter)
               .forEach(consumer);
    }

    @Override
    public List<Person> findAndSort(Comparator<Person> comparator) {
        List<Person> sortedList = new ArrayList<>(personList);
        sortedList.sort(comparator);
        return sortedList;
    }

    @Override
    public List<Person> findAndSort(Predicate<Person> filter, Comparator<Person> comparator) {
     List<Person> filteredList= personList.stream()
             .filter(filter)
             .sorted(comparator)
             .collect(Collectors.toList());
        return filteredList;
    }
}
