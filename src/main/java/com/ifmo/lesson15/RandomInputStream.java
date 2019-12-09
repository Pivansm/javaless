package com.ifmo.lesson15;

import java.io.*;
import java.util.Random;

/**
 * Реализация потока ввода, которая генерирует случайные данные
 * указанной длины.
 */
public class RandomInputStream extends InputStream {
    private final Random random;
    private final long length;
    private int index;

    public RandomInputStream(Random random, long length) {
        this.random = random;
        this.length = length;
        //writeFile(0);
        index = 0;
    }

    @Override
    public int read() throws IOException {
        // TODO implement
        if(random == null) return -1;
        if(length <= 0 ) return -1;
        int result = readFile();

        if(index >= length)
            return -1;
        //writeFile(result + 1);
        setIndex();

        return random.nextInt(255);
     }

    public void writeFile(int i) {
        File fl = new File("wapTmp.txt");

        try (OutputStream out = new FileOutputStream(fl)) {
            out.write(i);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int readFile() throws FileNotFoundException {
        File fl = new File("wapTmp.txt");
        int result = 0;
        if (fl.exists()) {
            try (InputStream in = new FileInputStream(fl)) {
                result = in.read();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private void setIndex() {
        index++;
    }

    private int getIndex() {
        return index;
    }
}
