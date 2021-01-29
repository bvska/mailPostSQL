package controler;

import java.util.List;

public interface Say<T, PK> {
    List<T> saySearch();
    void sayAdd(T t);
    void sayDelete(PK pk);
    void sayUpdate(T t);
    T saySearchId(PK pk);
}
