package financialinstitutes.interfaces;

@FunctionalInterface
public interface BiConsumer<T,U> {
    void supply(T t, U u);
}

