package com.ifmo.lesson13;


import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTasks {

    protected static class Person {
        private final String name;
        private final int age;
        private final String country;

        public Person(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }
    }

    public static void main(String[] args) {
        Stream<Person> people = generatePeople(100);

        List<String> countries = countriesSortedByTheirPopulationDescending(people);
        String countryThatHasMostKids = countryThatHasMostKids(people);
        Map<String, Long> populationByCountry = populationByCountry(people);

        System.out.println(countries);
        System.out.println(countryThatHasMostKids);
        System.out.println(populationByCountry);

        List<String> words = List.of("the", "hello", "approximation", "greetings", "java", "war");

        Map<Integer, Set<String>> wordsByLength = groupWordsByLength(words);
        int averageWordLength = averageWordLength(words);
        Set<String> longestWords = longestWords(words);

        System.out.println(wordsByLength);
        System.out.println(averageWordLength);
        System.out.println(longestWords);
    }

    // Метод возвращает страны в порядке убывания их населения.
    public static List<String> countriesSortedByTheirPopulationDescending(Stream<Person> people) {
        // TODO implement.

          Map<String, Long>  popInCoyntry = people
                 .collect(Collectors.groupingBy(p -> p.country, Collectors.counting()));

          popInCoyntry.entrySet()
                  .stream()
                  .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                  .map(entry -> entry.getKey())
                  .collect(Collectors.toList());

        return List.of();
    }

    // Метод находит страну (или одну из стран), в которых больше всего человек в возрасте
    // до 18 лет.
    public static String countryThatHasMostKids(Stream<Person> people) {
        // TODO implement.
                //people
                //.filter(s -> s.age < 18)
                /*.collect(Collectors.groupingBy(p ->p.country, Collectors.counting()))
                .entrySet()
                .stream()
                //.max(new Comparator.comporationLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                //.equals();*/
                //;

        return null;
    }

    // Метод возвращает карту стран их населения.
    public static Map<String, Long> populationByCountry(Stream<Person> people) {
        // TODO implement.
        //people.collect(Collectors.groupingBy(p -> p.country, Collectors.counting()));

        return Map.of();

    }



    private static List<String> COUNTRY = List.of("Japan", "China", "Rossia");
    private static List<String> NAME = List.of("Ivan", "Semen", "John");
    // Метод генерирует случайных людей в ограниченном наборе стран.
    // number - число желаемых людей.
    public static Stream<Person> generatePeople(int number) {
        Random rnd = new Random();
        // TODO implement.
        return Stream.generate(() -> new Person(NAME.get(rnd.nextInt(NAME.size())), rnd.nextInt(number), COUNTRY.get(rnd.nextInt(COUNTRY.size())))).limit(number);

    }

    // Метод возвращает карту сгруппированных слов по их длине. Например, для
    // трёхбуквенных слов будет:
    // 3 -> "the", "map", "got", "war"...
    public static Map<Integer, Set<String>> groupWordsByLength(List<String> words) {
        // TODO implement.

        return Map.of();
    }

    // Метод находит среднюю длину слов в списке.
    public static int averageWordLength(List<String> words) {
        // TODO implement.
        int avg = words.stream()
        .map(word -> word.length())
        .collect(Collectors.averagingInt(l -> l)).intValue();

        return avg;
    }

    // Метод находит самое длинное слово или слова, если таких несколько.
    public static Set<String> longestWords(List<String> words) {
        // TODO implement.

        return Set.of();
    }


}
