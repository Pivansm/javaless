package com.ifmo.lesson15;

import java.io.*;

/**
 * Реализация входящего потока, котрая генерирует данные в виде пилы
 * указанной длины и аплитуды.
 * Например:
 * Амплитуда 5, тогда вывод будет:
 * 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0...
 */
public class SawInputStream extends InputStream {
    private final int amplitude;
    private final long length;
    private int index;
    private int count;

    public SawInputStream(int amplitude, long length) {
        this.amplitude = amplitude;
        this.length = length;
        //writeFile(0);
        index = 0;
        count = 0;
    }

    @Override
    public int read() throws IOException {
        // TODO implement
        if(length <= 0 ) return -1;

        int result = getCount();

        if(result >= amplitude) {
            result = 0;
            count = 0;
        }
        setCount();

        if(getIndex() >= length) return -1;
        setIndex();

        return result;
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

    private void setCount() {
        count++;
    }

    private int getCount() {
        return count;
    }
}
