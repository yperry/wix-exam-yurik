package com.wixpress.test.tree;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BinTreeSerializerUtilTest {

    @Test
    public void shouldSerializeCorrectlyWhenSimpleCasePassed() throws Exception {
        BinTree binTree = new BinTree("A");
        assertEquals("A", BinTreeSerializerUtil.serialize(binTree));
    }
}
