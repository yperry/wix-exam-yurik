package com.wixpress.test.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinTreeDeserializerUtilTest {

    @Test
    public void shouldSerializeSimpleCaseCorrectly() throws Exception {
        BinTree binTree = new BinTree("1", new BinTree("2"), null);
        assertEquals(BinTreeDeserializerUtil.deserialize("1 2"), binTree);
    }
}