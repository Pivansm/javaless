package com.ifmo.lesson18;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Реализовать шифрующий (XOR) поток вывода.
 */
public class CryptoOutputStream extends FilterOutputStream {
    /**
     * Создаёт новый {@link CryptoOutputStream}.
     * При записи применяет операцию XOR последовательно:
     * каждый байт из ключа ^ каждый байт из выходящего потока.
     * Когда встречается конец ключа, то на следующий байт потока
     * берётся первый байт из ключа (по принципу кольцевого буфера).
     *
     * @param out Поток вывода.
     * @param key Ключ шифрования.
     */
    private byte[] key;
    private int index;

    public CryptoOutputStream(OutputStream out, byte[] key) {
        super(out);
        this.key = key;
        index = 0;
    }


    @Override
    public void write(int b) throws IOException {

        if(index == key.length -1)
            index = 0;
        byte newC = (byte) (b ^ key[index]);
        setIndex();

        out.write(newC);
    }

    /*public void write(byte[] b) throws IOException {

        for(int i = 0, j = 0; i < b.length; i++, j++)
        {
            if (j == key.length -1)
                j = 0;
            b[i] = (byte) (b[i] ^ key[j]);
        }

        out.write(b);
    }*/

    @Override
    public void write(byte[] b, int offset, int len) throws IOException {

        for(int i = 0; i < len; i++)
        {
            if(index == key.length -1)
                index = 0;
            b[offset +i] = (byte) (b[i] ^ key[index]);
            setIndex();
        }

        out.write(b, offset, len);
    }

    private void setIndex() {
        index++;
    }

}
