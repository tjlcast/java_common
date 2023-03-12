package com.jialtang.java_common.utils;

import org.junit.Assert;
import org.junit.Test;

public class ConvUtilsTest {

  @Test
  public void longArray2Bytes() {
    long a = 1;
    long b = 2;
    long[] longs = {a, b};

    byte[] abytes = ConvUtils.long2bytes(a);
    byte[] bbytes = ConvUtils.long2bytes(b);

    byte[] bytes = ConvUtils.longArray2Bytes(longs);

    Assert.assertTrue(abytes.length + bbytes.length == bytes.length);
    for (int i = 0; i < bytes.length; i++) {
      byte bv = bytes[i];
      if (i < abytes.length) {
        byte abyte = abytes[i];
        Assert.assertTrue(bv == abyte);
      } else {
        byte bbyte = bbytes[i - abytes.length];
        Assert.assertTrue(bv == bbyte);
      }
    }
  }
}
