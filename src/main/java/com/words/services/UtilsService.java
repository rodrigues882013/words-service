package com.words.services;

import com.words.models.Word;

public class UtilsService {

    public static Integer calculeDistance(Word w1, Word w2){
        if (w1 == null || w2 == null) throw new NullPointerException("Word 1 or Word 2 have null value");
        if (w1.getWord().equals("") && !w2.getWord().equals("") ||
                w2.getWord().equals("") && !w1.getWord().equals("")) return 0;
        if (w1.equals(w2)) return 0;
        return -1;
    }
}
