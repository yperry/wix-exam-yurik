package com.wixpress.test.tree;

import java.util.HashSet;
import java.util.Set;

public class BinTreeSerializerUtil {
    private BinTreeSerializerUtil() {
    }

    public static String serialize(BinTree binTree) throws BinTreeSerializationException {
        StringBuilder sb = new StringBuilder();
        Set<String> visitedElems = new HashSet<String>();
        serializeInternally(binTree, sb, visitedElems);
        return sb.toString();
    }

    private static void serializeInternally(BinTree binTree, StringBuilder sb, Set<String> visitedElems) throws BinTreeSerializationException {
        if (binTree == null) {
            sb.append("$ ");
            return;
        }

        if(isAlreadyVisited(binTree, visitedElems)) {
            throw new BinTreeSerializationException();
        }

        sb.append(binTree.getValue()).append(" ");
        visitedElems.add(binTree.getValue());
        serializeInternally(binTree.getLeft(), sb, visitedElems);
        serializeInternally(binTree.getRight(), sb, visitedElems);
    }

    private static boolean isAlreadyVisited(BinTree binTree, Set<String> visitedElems) {
        return visitedElems.contains(binTree.getValue());
    }

}
