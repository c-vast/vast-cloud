package com.vast.common.buffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class MyBuffer {

    private final int MAX_LENGTH = 1024;

    private final ByteBuffer buffer;

    public MyBuffer() {
        buffer = ByteBuffer.allocate(MAX_LENGTH);
        buffer.mark();
    }

    public MyBuffer(byte[] bytes) {
        buffer = ByteBuffer.allocate(MAX_LENGTH);
        buffer.mark();
        buffer.put(bytes);
        buffer.limit(bytes.length);
        buffer.reset();
    }

    public void clear() {
        buffer.clear();
        buffer.mark();
    }

    public boolean hasRemain() {
        return buffer.remaining() > 0;
    }

    public byte[] array() {
        int pos = buffer.position();
        byte[] data = new byte[pos];
        buffer.reset();
        buffer.get(data);
        return data;
    }

    public void put(byte b) {
        buffer.put(b);
    }

    public void put(byte[] b) {
        buffer.put(b);
    }

    public void put(short s) {
        buffer.putShort(s);
    }

    public void put(int i) {
        buffer.putInt(i);
    }

    public void put(long l) {
        buffer.putLong(l);
    }

    public void putByte(int i) {
        buffer.put((byte) i);
    }

    public void putShort(int i) {
        buffer.putShort((short) i);
    }

    public void putInt(long l) {
        buffer.putInt((int) l);
    }

    public void put(String str) {
        byte[] bytes = str.getBytes(Charset.forName("GBK"));
        buffer.put(bytes);
    }

    public void put(String str, int len) {
        byte[] data = new byte[len];
        byte[] bytes = str.getBytes(Charset.forName("GBK"));
        int min = Math.min(data.length, bytes.length);
        System.arraycopy(bytes, 0, data, 0, min);
        buffer.put(data);
    }

    public byte get() {
        return buffer.get();
    }

    public int getUnsignedByte() {
        return buffer.get() & 0x0FF;
    }

    public byte[] get(int len) {
        byte[] data = new byte[len];
        buffer.get(data);
        return data;
    }

    public short getShort() {
        return buffer.getShort();
    }

    public int getUnsignedShort() {
        return buffer.getShort() & 0xFFFF;
    }

    public int getInt() {
        return buffer.getInt();
    }

    public long getUnsignedInt() {
        return buffer.getInt() & 0x0FFFFFFFFL;
    }

    public long getLong() {
        return buffer.getLong();
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
