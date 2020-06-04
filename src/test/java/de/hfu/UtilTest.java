package de.hfu;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void testIstErstesHalbjahrUntereGrenze(){
        assertTrue(Util.istErstesHalbjahr(1));
    }

    @Test
    public void testIstErstesHalbjahrObereGrenze(){
        assertTrue(Util.istErstesHalbjahr(6));
    }

    @Test
    public void testIstNichtErstesHalbjahrUntereGrenze(){
        assertFalse(Util.istErstesHalbjahr(7));
    }

    @Test
    public void testIstNichtErstesHalbjahrObereGrenze(){
        assertFalse(Util.istErstesHalbjahr(12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIstKeinMonatUntereGrenze(){
        Util.istErstesHalbjahr(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIstKeinMonatObereGrenze(){
        Util.istErstesHalbjahr(13);
    }
}
