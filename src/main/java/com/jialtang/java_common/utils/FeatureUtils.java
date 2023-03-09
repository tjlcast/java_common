package com.jialtang.java_common.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class FeatureUtils {
  public static double Score(String feature1, String feature2) {
    byte[] feat1Decode = Base64.getDecoder().decode(feature1.getBytes(StandardCharsets.UTF_8));
    byte[] feat2Decode = Base64.getDecoder().decode(feature2.getBytes(StandardCharsets.UTF_8));
    float[] feat1Floats = CustomUtils.bytes2floatArray(feat1Decode, 0, feat1Decode.length);
    float[] feat2Floats = CustomUtils.bytes2floatArray(feat2Decode, 0, feat1Decode.length);
    double dis = 0;
    for (int i = 0; i < feat1Floats.length; i++) {
      dis += Math.pow(feat1Floats[i] - feat2Floats[i], 2);
    }

    double sqrt = Math.sqrt(dis);
    return 1 - sqrt * sqrt / 4;
  }
}
