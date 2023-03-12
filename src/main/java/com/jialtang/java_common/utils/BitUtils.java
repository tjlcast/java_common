package com.jialtang.java_common.utils;

public class BitUtils {
  public static int getInt(byte[] arr, int index) {
    return (0xff000000 & (arr[index + 3] << 24))
        | (0x00ff0000 & (arr[index + 2] << 16))
        | (0x0000ff00 & (arr[index + 1] << 8))
        | (0x000000ff & (arr[index + 0]));
  }
}
