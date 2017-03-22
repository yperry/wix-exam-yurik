package com.wixpress.test.tree;

import java.util.StringTokenizer;

public class BinTreeDeserializerUtil {

    private BinTreeDeserializerUtil() {
    }

    public static BinTree deserialize(String serializedString) {
        if (serializedString == null || serializedString.length() == 0) {
            return null;
        }
        StringTokenizer valTokens = new StringTokenizer(serializedString, " ");
        return deserializeInternally(valTokens);
    }

    private static BinTree deserializeInternally(StringTokenizer valTokens) {
        if (!valTokens.hasMoreTokens()) {
            return null;
        }
        String val = valTokens.nextToken();
        BinTree root = new BinTree(val);
        root.setLeft(deserializeInternally(valTokens));
        root.setRight(deserializeInternally(valTokens));
        return root;
    }
}
