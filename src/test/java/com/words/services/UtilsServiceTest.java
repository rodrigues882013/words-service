package com.words.services;

import com.words.models.Word;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class UtilsServiceTest {

    private Word w1, w2;

    @Before
    public void setUp(){
        w1 = new Word();
        w2 = new Word();

    }
    @Test
    public void calculeDistanceBetweenEqualWordsTest(){
        w1.setWord("ball");
        w2.setWord("ball");

        Integer distance = UtilsService.calculeDistance(w1, w2);
        assertTrue("Two equal words have to be 0", distance == 0);


    }

    @Test
    public void calculeDistanceBetweenEmptyWordsTest(){
        w1.setWord("");
        w2.setWord("ball");

        Integer distance = UtilsService.calculeDistance(w1, w2);
        assertTrue("Distance between '' and 'ball' have to be 0", distance == 0);

        w1.setWord("ball");
        w2.setWord("");

        distance = UtilsService.calculeDistance(w1, w2);
        assertTrue("Distance between 'ball' and '' have to be 0", distance == 0);
    }

    @Test(expected = NullPointerException.class)
    public void nullWordsTeste(){
        Integer distance = UtilsService.calculeDistance(null, null);
    }


}
