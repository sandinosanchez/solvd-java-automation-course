package financialinstitutes.interfaces;

@FunctionalInterface
public interface Consumer<T> {
    void supply(T t);
}
