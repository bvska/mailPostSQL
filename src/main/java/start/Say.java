package start;

import sqlEntity.Client;

import java.util.List;

public interface Say<T> {
    List<T> saySearch();
    void sayAdd(T t);
    void sayDelete(Integer integer);
}
