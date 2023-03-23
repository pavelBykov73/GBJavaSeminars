package hw_test;

import hw_test.model.NotebookT;

import java.util.HashSet;
import java.util.Set;

public class HwTestSet {
    public static void main(String[] args) {
        Set<NotebookT> notebookSet = new HashSet<>();
        putSampleNotebooks(notebookSet);
        for (NotebookT notebook : notebookSet
        ) {
            System.out.println(notebook.toString());
        }
    }

    private static void putSampleNotebooks(Set<NotebookT> notebooks) {

        NotebookT notebook11 = new NotebookT("Asus", 27800);
        NotebookT notebook12 = new NotebookT("Asus", 27800);
        System.out.println(notebook11.equals(notebook12));
        notebooks.add(notebook11);
        notebooks.add(notebook12);
    }

}
