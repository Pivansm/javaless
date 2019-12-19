package com.ifmo.lesson18;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Реализовать шифрующий (XOR) поток вывода.
 */
public class CryptoInputStream extends FilterInputStream {
    /**
     * Создаёт новый {@link CryptoInputStream}.
     * При чтении применяет операцию XOR последовательно:
     * каждый байт из ключа ^ каждый байт из входящего потока.
     * Когда встречается конец ключа, то на следующий байт потока
     * берётся первый байт из ключа (по принципу кольцевого буфера).
     *
     * @param in Поток ввода.
     * @param key Ключ шифрования.
     */

    private byte[] key;
    private int index;

    public CryptoInputStream(InputStream in, byte[] key) {
        super(in);
        this.key = key;
        index = 0;
    }

    public int read() throws IOException {
        int result = in.read();
        if(result == -1) return result;
        if(index == key.length -1)
            index = 0;
        result = result ^ (int) key[index];
        setIndex();
        return result;
    }

    public int read(byte[] b) throws IOException {
        int result = in.read(b);
        if(result == -1) return -1;

        for(int i = 0; i < result; i++) {
            if(index == key.length -1)
                index = 0;
            b[i] = (byte) (b[i] ^ key[index]);
            setIndex();
        }

        return result;
    }

    public int read(byte[] b, int offset, int len) throws IOException {

        int result = in.read(b, offset, len);

        if (result == -1) return -1;

        for(int i = offset; i < offset + result; i++)
        {
            if(index == key.length -1)
                index = 0;
            b[i] = (byte) (b[i] ^ key[index]);
            setIndex();
        }
        return result;
    }

    private void setIndex() {
        index++;
    }
}
