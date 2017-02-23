package com.words.services;

import com.words.models.Word;


public class UtilsService {

    public static Integer minimum(Integer v1, Integer v2, Integer v3){
        return Math.min(Math.min(v1, v2), v3);
    }

    public static Integer distance(Word w1, Word w2){

        if (w1 == null || w2 == null) throw new NullPointerException("Word 1 or Word 2 have null value");

        String s1 = w1.getWord().toLowerCase();
        String s2 = w2.getWord().toLowerCase();
        Integer[][] result = new Integer[s1.length()+1][s2.length()+1];
        Integer cost = 0;


        if (s1.equals("") && !s2.equals("") || s2.equals("") && !s1.equals("") || w1.equals(w2)) return 0;

        for (int i=0; i <= s1.length(); i++) result[i][0] = i;
        for (int j=0; j <= s2.length(); j++) result[0][j] = j;

        for (int i=1; i <= s1.length(); i++){

            for (int j=1; j <= s2.length(); j++){

                if (s1.charAt(i-1) == s2.charAt(j-1)) cost = 0;
                else cost = 1;

                result[i][j] = minimum(result[i-1][j] + 1,
                                       result[i][j-1] + 1,
                                       result[i-1][j-1] + cost);

            }
        }



        return result[s1.length()][s2.length()];
    }
}
