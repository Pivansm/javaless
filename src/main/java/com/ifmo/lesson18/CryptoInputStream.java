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


    @Override
    public int read() throws IOException {

        byte result = (byte) super.read();
        if(result == -1) return result;

        if(index == key.length -1)
            index = 0;
        byte newC = (key.length > 0) ? (byte) (result ^ key[index]) : result;
        setIndex();

        return result == -1 ? result : newC;
    }



    public int read(byte[] b, int offset, int len) throws IOException {

        int result = 255;
        if(b.length == 0) {
            result = super.read();
         }
        else
            result = super.read(b, offset, len);

        if(key.length > 0)
        for(int i = 0; i < b.length; i++) {
            if (index == key.length - 1)
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
