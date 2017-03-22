package com.wixpress.test.tree;

public class BinTreeSerializerUtil {
    private BinTreeSerializerUtil() {
    }

    public static String serialize(BinTree binTree) {
        StringBuilder sb = new StringBuilder();
        serializeInternally(binTree, sb);
        return sb.toString();
    }

    private static void serializeInternally(BinTree binTree, StringBuilder sb) {
        if(binTree == null) {
            return;
        }
        
        sb.append(binTree.getValue()).append(" ");
        serializeInternally(binTree.getLeft(), sb);
        serializeInternally(binTree.getRight(), sb);
    }

}
