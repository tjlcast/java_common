package com.jialtang.java_common.utils;

public class CustomUtils {
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
