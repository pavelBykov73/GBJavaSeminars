package hw1_simple.model;

import java.util.Map;
import java.util.Set;

public interface INotebooksTable {
    public Set<Notebook> getNotebooks(Map<FilterKey, String> mapFilter);

    public void printNotebooks(Map<FilterKey, String> mapFilter);
}
