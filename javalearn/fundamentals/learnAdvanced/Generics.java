//package javalearn.fundamentals.learnAdvanced;

import java.util.*;

public class Generics {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

//        System.out.println(i + " " + s);

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

        Optional<String> test = Optional.of("test");

//        System.out.println(mustBeTrue + " " + mustAlsoBeTrue);

        Collection<?> collection = new ArrayList<Object>();
        Object object = new Object();


    }
    
}
class Pair<T, W> {
    private final T firstValue;
    private final W secondValue;

    private Pair(T first, W second) {
        this.firstValue = first;
        this.secondValue = second;
    }

    public static <T, W> Pair <T, W> of(T first, W second) {
        return new Pair<>(first, second);
    }

    public T getFirst() {
        return firstValue;
    }

    public W getSecond() {
        return secondValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(getFirst(), pair.getFirst()) && Objects.equals(getSecond(), pair.getSecond());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }
}
