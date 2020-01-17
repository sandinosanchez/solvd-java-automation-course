package financialinstitutes.interfaces;

@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);
}
