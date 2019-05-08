package core;

public interface CoreCallback<T> {
    void onSuccess(T result);

    void onFailure(String message);
}
