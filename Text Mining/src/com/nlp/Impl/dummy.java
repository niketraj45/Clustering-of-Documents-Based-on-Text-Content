package com.nlp.Impl;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.algorithm.StopWords;

public class dummy {
public static void main(String[] args) throws IOException {
//	Reader initialReader = new StringReader("text");
//    char[] arr = new char[8 * 1024];
//    StringBuilder buffer = new StringBuilder();
//    int numCharsRead;
//    while ((numCharsRead = initialReader.read(arr, 0, arr.length)) != -1) {
//        buffer.append(arr, 0, numCharsRead);
//    }
//    initialReader.close();
//    String targetString = buffer.toString();
//    System.out.println(targetString);
	String s = "[[privileges, practice, addresses, instance, officer, questions, owners, office, multi-keyword, platforms, pseudorandom, division, diffie-hellman, outsource, usability, attacks, circuits, np-hard, correctness, overhead, preference, interoperability, schemes, relevance, quality, trapdoor, two-factor, qiaoyan, campaign, placement, bursting, fundamentals, components, circuit, scores, trade-off, policies, protection, virtualisation, clouds, choosing, linear-geometry, caveats, platform, delegate, revocation, general, diversity, operations, uploaded, vector, situation, introduction, cloudices, deployment, situations, ciphertext-policy, delivery, product, ciphertext, original, sub-dictionaries, compositions, requirement, technology, intent, heterogeneity, respond, delegation, operation, decryption, seniority], null, null, null]";
	String[] str = s.split(",");
	ArrayList<String> arr = new ArrayList<String>(Arrays.asList(s.split(",")));
	String s1 = "clouds.";
	System.out.println(StopWords.cleanString(s1));
	System.out.println(arr.contains(s1));
}
}
