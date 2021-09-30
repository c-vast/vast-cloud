package com.vast.common.buffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class MyBuffer {

    private final int MAX_LENGTH = 1024;

    private final ByteBuffer BUFFER;

    public MyBuffer() {
        BUFFER = ByteBuffer.allocate(MAX_LENGTH);
        BUFFER.mark();
    }

    public MyBuffer(byte[] bytes) {
        BUFFER = ByteBuffer.allocate(MAX_LENGTH);
        BUFFER.mark();
        BUFFER.put(bytes);
        BUFFER.limit(bytes.length);
        BUFFER.reset();
    }

    public void clear() {
        BUFFER.clear();
        BUFFER.mark();
    }

    public boolean hasRemain() {
        return BUFFER.remaining() > 0;
    }

    public byte[] array() {
        int pos = BUFFER.position();
        byte[] data = new byte[pos];
        BUFFER.reset();
        BUFFER.get(data);
        return data;
    }

    public void put(byte b) {
        BUFFER.put(b);
    }

    public void put(byte[] b) {
        BUFFER.put(b);
    }

    public void put(short s) {
        BUFFER.putShort(s);
    }

    public void put(int i) {
        BUFFER.putInt(i);
    }

    public void put(long l) {
        BUFFER.putLong(l);
    }

    public void putByte(int i) {
        BUFFER.put((byte) i);
    }

    public void putShort(int i) {
        BUFFER.putShort((short) i);
    }

    public void putInt(long l) {
        BUFFER.putInt((int) l);
    }

    public void put(String str) {
        byte[] bytes = str.getBytes(Charset.forName("GBK"));
        BUFFER.put(bytes);
    }

    public void put(String str, int len) {
        byte[] data = new byte[len];
        byte[] bytes = str.getBytes(Charset.forName("GBK"));
        int min = Math.min(data.length, bytes.length);
        System.arraycopy(bytes, 0, data, 0, min);
        BUFFER.put(data);
    }

    public byte get() {
        return BUFFER.get();
    }

    public int getUnsignedByte() {
        return BUFFER.get() & 0x0FF;
    }

    public byte[] get(int len) {
        byte[] data = new byte[len];
        BUFFER.get(data);
        return data;
    }

    public short getShort() {
        return BUFFER.getShort();
    }

    public int getUnsignedShort() {
        return BUFFER.getShort() & 0xFFFF;
    }

    public int getInt() {
        return BUFFER.getInt();
    }

    public long getUnsignedInt() {
        return BUFFER.getInt() & 0x0FFFFFFFFL;
    }

    public long getLong() {
        return BUFFER.getLong();
    }

    public String getString(int len) {
        byte[] data = get(len);
        return new String(data, Charset.forName("GBK"));
    }

    public String getBcdString(int len) {
        byte[] data = get(len);
        StringBuilder bcd = new StringBuilder();
        for (int m = 0; m < len; m++) {
            bcd.append(String.format("%02X", data[m]));
        }
        return bcd.toString();
    }
}
