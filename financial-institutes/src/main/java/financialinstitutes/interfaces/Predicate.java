package financialinstitutes.interfaces;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
