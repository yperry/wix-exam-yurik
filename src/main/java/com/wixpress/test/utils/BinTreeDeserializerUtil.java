package com.wixpress.test.utils;

import com.wixpress.test.tree.BinTree;
import com.wixpress.test.tree.BinTreeSerializationException;

import java.util.StringTokenizer;

public class BinTreeDeserializerUtil {

    private BinTreeDeserializerUtil() {
    }

    public static BinTree deserialize(String serializedString, String delim) throws BinTreeSerializationException {
        if (isCorrectInput(serializedString)) {
            return null;
        }

        if(!serializedString.contains(" $ ")) {
            throw new BinTreeSerializationException("Seems that we have incorrect serialized string");
        }

        StringTokenizer valTokens = new StringTokenizer(serializedString, delim);
        return deserializeInternally(valTokens);
    }

    private static boolean isCorrectInput(String serializedString) {
        return serializedString == null || serializedString.length() == 0;
    }

    private static BinTree deserializeInternally(StringTokenizer valTokens) {
        if (!valTokens.hasMoreTokens()) {
            return null;
        }

        String val = valTokens.nextToken();
        if (val.equals("$")) {
            return null;
        }

        BinTree root = new BinTree(val);
        root.setLeft(deserializeInternally(valTokens));
        root.setRight(deserializeInternally(valTokens));
        return root;
    }
}
