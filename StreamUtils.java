import java.util.*;
import java.util.stream.Collectors;

public class StreamUtils {

    public static Collection<String> capitalized(Collection<String> strings) {
        return strings.stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .collect(Collectors.toList());
    }

    public static String longest(Collection<String> strings, boolean from_start) {
        return (from_start) ? strings.stream()
                .max(Comparator.comparing(String::length)).get():
                strings.stream().max(Comparator.comparingInt(String::length)
                        .thenComparing(String::compareTo)).get();
    }

    public static <T extends Comparable<T>> T least(Collection<T> items, boolean from_start) {
        return (from_start) ? items.stream()
                .min(Comparator.comparing(s -> s.toString().length())).get():
                items.stream().min(Comparator.comparingInt(t -> t.toString().length())
                .thenComparing((i, j) -> i.toString().compareTo(j.toString()))).get();
    }

    public static <K, V> List<String> flatten(Map<K, V> aMap) {
        return aMap.entrySet().stream().map(s -> s.getKey() + " -> " + s.getValue()).collect(Collectors.toList());
    }
}
