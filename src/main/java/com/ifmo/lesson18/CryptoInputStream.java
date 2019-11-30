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
    public CryptoInputStream(InputStream in, byte[] key) {
        super(in);
        this.key = key;
    }

    public int read() throws IOException {
        int c = in.read();
        return (c == -1) ? c : c ^ (int) key[0];
    }

    public int read(byte[] b, int offset, int len) throws IOException {
        int result = in.read(b, offset, len);

        for(int i = offset, j = 0; i < offset + result; i++, j++)
        {
            if (j == key.length -1)
                j = 0;
            b[i] = (byte) (b[i] ^ key[j]);
        }
        return result;
    }
}
