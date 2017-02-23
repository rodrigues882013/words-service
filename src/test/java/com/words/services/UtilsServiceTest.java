package com.words.services;

import com.words.models.Word;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class UtilsServiceTest {

    private Word w1, w2;
    private Integer distance;

    @Before
    public void setUp(){
        w1 = new Word();
        w2 = new Word();


    }
    @Test
    public void calculeDistanceBetweenEqualWordsTest(){
        w1.setWord("ball");
        w2.setWord("ball");

        distance = UtilsService.distance(w1, w2);
        assertTrue("Two equal words have to be 0", distance == 0);


    }

    @Test
    public void calculeDistanceBetweenEmptyWordsTest(){
        w1.setWord("");
        w2.setWord("ball");

        distance = UtilsService.distance(w1, w2);
        assertTrue("Distance between '' and 'ball' have to be 0", distance == 0);

        w1.setWord("ball");
        w2.setWord("");

        distance = UtilsService.distance(w1, w2);
        assertTrue("Distance between 'ball' and '' have to be 0", distance == 0);
    }

    @Test(expected = NullPointerException.class)
    public void nullWordsTeste(){
        distance = UtilsService.distance(null, null);
    }

    @Test
    public void calculeDistanceBetweenTwoWordsTest(){
        w1.setWord("abacate");
        w2.setWord("banana");

        distance = UtilsService.distance(w1, w2);
        assertTrue("Distance between 'abacate' and 'banana' have to be diferente from 0", distance != 0);
        assertTrue("Distance between 'abacate' and 'banana' have to be 3", distance == 4);
    }

    @Test
    public void maxAndMinTest(){
        assertTrue("Min val between 100, 4, 9 have to be 4", UtilsService.minimum(100, 4, 9) == 4);
    }

}
