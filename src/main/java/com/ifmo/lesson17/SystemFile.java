package com.ifmo.lesson17;

import java.io.File;
import java.util.*;

public class SystemFile implements Cloneable, Iterable<File> {
    private static SystemFile instatge;
    private List<File> files;

    public SystemFile() {
        instatge = new SystemFile();
        files = Arrays.asList(new File("file1"), new File("file"));
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */

    @Override
    public Iterator<File> iterator() {
        return instatge.iterator();
    }
 public SystemFile getInstatge() {
        return instatge;
 }
   public List<File> getF() {
        return files;
   }

}
