package com.jialtang.java_common.utils;

import com.google.common.base.Preconditions;

public class ConvUtils {
  public static byte[] longArray2Bytes(long[] longs) {
    int length = 8;
    byte[] bytes = new byte[8 * longs.length];

    for (int i = 0; i < longs.length; i++) {
      for (int j = 0; j < length; j++) {
        bytes[i * length + length - j - 1] = (byte) (longs[i] >> j * 8);
      }
    }
    return bytes;
  }

  public static byte[] long2bytes(long aLong) {
    int length = 8;
    byte[] bytes = new byte[length];
    for (int i = 0; i < length; i++) {
      bytes[length - i - 1] = (byte) (aLong >> i * 8);
    }
    return bytes;
  }

  public static long bytes2Long(byte[] buffer, int start) {
    long value = 0;
    for (int i = start; i < start + 8; i++) {
      value <<= 8;
      value |= (buffer[i] & 0xff);
    }
    return value;
  }

  public static long[] bytes2LongArr(byte[] buffer, int start, int length) {
    Preconditions.checkState(length % 8 == 0);
    long[] longArray = new long[length / 8];
    for (int i = 0; i < length / 8; i++) {
      for (int j = start + i * 8; j < start + i * 8 + 8; j++) {
        longArray[i] <<= 8;
        longArray[i] |= (buffer[j] & 0xff);
      }
    }
    return longArray;
  }

  public static byte[] floatArray2Bytes(float[] val) {
    int[] n = floatArray2IntArray(val);
    byte[] b = intArray2Bytes(n);
    return b;
  }

  private static int[] floatArray2IntArray(float[] f) {
    int[] n = new int[f.length];
    for (int i = 0; i < f.length; i++) {
      n[i] = Float.floatToIntBits(f[i]);
    }
    return n;
  }

  private static byte[] intArray2Bytes(int[] n) {
    byte[] b = new byte[4 * n.length];
    for (int i = 0; i < n.length; i++) {
      for (int j = i * 4; j < i * 4 + 4; j++) {
        b[i * 4 + 3 - j + i * 4] = (byte) (n[i] >> (24 - (j - i * 4) * 8));
      }
    }
    return b;
  }

  public static float[] bytes2floatArray(byte[] featurebytes, int start, int length) {
    float floatArray[] = new float[length / 4];
    for (int i = 0; i < floatArray.length; i++) {
      floatArray[i] = bytes2float(featurebytes, start + i * 4);
    }
    return floatArray;
  }

  private static float bytes2float(byte[] featurebytes, int i) {
    int l;
    l = featurebytes[i];
    l &= 0xff;
    l |= ((long) featurebytes[i + 1] << 8);
    l &= 0xffff;
    l |= ((long) featurebytes[i + 2] << 16);
    l &= 0xffffff;
    l |= ((long) featurebytes[i + 3] << 24);
    return Float.intBitsToFloat(l);
  }
}
