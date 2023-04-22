package Java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPractice{




    // 1. Print IntStream
    public static void printIntStream() {
        IntStream.range(1, 10).forEach(System.out::print);
        System.out.println();
    }

    // 2. Skip IntStream
    public static void skipIntStream() {
        IntStream.range(1, 10).skip(5).forEach(System.out::print);
        System.out.println();
    }

    // 3. Sum first 3 elements of IntStream
    public static void sumFirstThreeIntStream() {
        int sum = IntStream.range(1, 10).limit(3).sum();
        System.out.println(sum);
    }

    // 4. Stream.of, sorted and findFirst
    public static void printSortedFirstElement() {
        Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst().ifPresent(System.out::println);
    }

    // 5. Stream from Array, sort, filter and print
    public static void filterAndPrintNames() {
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};

        Arrays.stream(names).filter(x -> startsWithIgnoreCase(x, "A")).forEach(System.out::println);

        System.out.println("Printing the joined String");

        String str = Arrays.stream(names).filter(x -> x.toLowerCase().startsWith("a")).collect(Collectors.joining(","));

        System.out.println(str);
    }

    // 6. Average of squares of int array
    public static void printAverageOfSquares() {
        System.out.println(
                Arrays.stream(new int[]{2, 4, 6, 8})
                        .map(x -> x * x).average());

        System.out.println("\n");
    }

    // 7. Stream rows from text file, sort, filter, and print
    public static void printSortedLongBands() throws IOException {
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();
    }

    // 9. Stream rows from text file and save to List
    public static void saveFilteredBandsToList() throws IOException {
        List<String> bands2 = Files.lines(Paths.get("bands.txt"))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println("\n" + x));
    }

    // 10. Stream rows from CSV file and count
    public static void countRowsInCsv() throws IOException {
        Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
        int rowCount = (int) rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();
    }

    //11. Parsing data from csv
    public static void parseDataFromCsv(String filePath) throws IOException {
        Stream<String> rows = Files.lines(Paths.get(filePath));
        rows    .map(row -> row.split(","))
                .filter(row -> row.length == 3)
                .filter(row -> Integer.parseInt(row[1]) > 15)
                .forEach(row -> System.out.println(row[0] + " " + row[1] + " " + row[2]));
        rows.close();
    }

    // 12 Find the maximum value
    public static void findMaximum(){

        List<String> strings = Arrays.asList("f", "barx", "baz", "qx");
        List<String> stringsWithSameLength = Arrays.asList("foo", "bar", "baz", "qux");

        List<Integer> numbers = Arrays.asList(1,10,6,7,8,19,20);

        Optional<String> maxValue= strings.stream().collect(Collectors.maxBy((s1,s2)-> s2.length()-s1.length()));

        Optional<String> minValue= strings.stream().collect(Collectors.maxBy((s1,s2)-> s1.length()-s2.length()));


        Optional<Integer> nminValue = numbers.stream().collect(Collectors.maxBy((n1,n2)-> n2-n2));

        Optional<Integer> nmaxValue=numbers.stream().collect(Collectors.maxBy((n1,n2)-> n1-n2));



        Optional<String>  maxStringEqualLength = stringsWithSameLength.stream().collect(Collectors.maxBy(Comparator.comparing(String::length)));

        System.out.println("String with Max Length  "+maxValue.get());

        System.out.println("String with min Length  "+minValue.get());

        System.out.println("Largest Number   "+nmaxValue.get());

        System.out.println("Smallest Number   "+nminValue.get());

        System.out.println("Max String with SameLength  "+maxStringEqualLength.get());




    }



    // 13.Parse csv data in map

    public static void putCSVDataToMap(String path) throws IOException{

        List<String> record= Files.lines(Paths.get(path)).collect(Collectors.toList());
        System.out.println("Records in file");

        record.stream().map(x -> x.split(",")).filter(x->x.length==3).forEach(x-> System.out.println(x[0] +"  "+ x[1] +"  "+x[2]));
        System.out.println("Records in data");

        Map<String,Integer> map =record.stream().map(x-> x.split(","))
                .filter(x->x.length==3)
                .filter(x->Integer.parseInt(x[1])>15)
                .collect(Collectors
                        .toMap(x -> x[0] ,x-> Integer.parseInt(x[1]))).entrySet().stream()
                .sorted((a,b)-> a.getValue().compareTo(b.getValue()))
                .collect(Collectors.toMap(m-> m.getKey(), m-> m.getValue()));


        map.forEach((k,v)-> System.out.println(k+" ," +v));

        record.forEach(x->System.out.println(x));

    }




    public static boolean startsWithIgnoreCase(String str, String prefix)
    {
        return str.regionMatches(true, 0, prefix, 0, prefix.length());
    }

    public static boolean endsWithIgnoreCase(String str, String suffix)
    {
        int suffixLength = suffix.length();
        return str.regionMatches(true, str.length() - suffixLength, suffix, 0, suffixLength);
    }


    public static void main(String[] args) throws IOException {

        printIntStream();
        skipIntStream();
        sumFirstThreeIntStream();
        printSortedFirstElement();
        filterAndPrintNames();
        printAverageOfSquares();
        printSortedLongBands();
        saveFilteredBandsToList();
        countRowsInCsv();
        parseDataFromCsv("data.txt");
        putCSVDataToMap("data.txt");

        findMaximum();


    }

}
