import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiExercises {
    public static IntUnaryOperator getMiddle() {
        return number -> number / 10 % 1000;
    }

    public static IntStream pseudoRandomStream(int seed) {
        IntStream randomNumbers = IntStream.iterate(seed, x -> getMiddle().applyAsInt(x * x));
        return randomNumbers;
    }

    public static <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {
        
        List<T> sortedValues = stream.collect(Collectors.toList());
        if (sortedValues.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            sortedValues.sort(order);
            T min = sortedValues.get(0);
            T max =  sortedValues.get(sortedValues.size() - 1);
            minMaxConsumer.accept(min, max);
        }
    }

    public static <T> void alternativeFindMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {

        MinMaxFinder<T> minMaxFinder = new MinMaxFinder<>(order);
        stream.forEach(minMaxFinder);
        minMaxConsumer.accept(minMaxFinder.min, minMaxFinder.max);
    }

    private static class MinMaxFinder<T> implements Consumer<T> {

        private final Comparator<? super T> order;
        T min;
        T max;

        private MinMaxFinder(Comparator<? super T> order) {
            this.order = order;
        }

        @Override
        public void accept(T t) {
            if (min == null || order.compare(t, min) < 0) {
                min = t;
            }
            if (max == null || order.compare(max, t) < 0) {
                max = t;
            }
        }
    }

    public static void displayMostFrequentWords() {
        try (Scanner scanner  = new Scanner(System.in, StandardCharsets.UTF_8)) {
            String input = scanner.nextLine();
            Map<String, Long> frequencyMap = Arrays.stream(input.split("[^a-zA-Zа-яА-Я0-9]+"))
                                                    .map(String::toLowerCase)
                                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                frequencyMap.entrySet()
                            .stream()
                            .sorted((x, y) -> {
                                if (x.getValue().compareTo(y.getValue()) == 0) return x.getKey().compareTo(y.getKey());
                                else return y.getValue().compareTo(x.getValue());
                            })
                            .limit(10)
                            .forEach(x -> System.out.println(x.getKey()));
        }
    }

    public static void main(String[] args) {
        //pseudoRandomStream(13).limit(12).forEach(System.out::println);
        
        // try (IntStream stream = pseudoRandomStream(13)) {
        //     Comparator<Integer> order = Comparator.naturalOrder();
        //     BiConsumer<Integer, Integer> minMaxConsumer = (min, max) -> {
        //         System.out.println("Min: " + min + ", Max: " + max); 
        //     };
        //     alternativeFindMinMax(stream.limit(12).boxed(), order, minMaxConsumer);
        // }

        displayMostFrequentWords();
    }
}
