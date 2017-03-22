package com.wixpress.test.utils;

import com.wixpress.test.tree.BinTree;
import com.wixpress.test.tree.BinTreeSerializationException;

import java.util.HashSet;
import java.util.Set;

public class BinTreeSerializerUtil {
    private BinTreeSerializerUtil() {
    }

    public static String serialize(BinTree binTree) throws BinTreeSerializationException {
        StringBuilder sb = new StringBuilder();
        Set<BinTree> visitedElems = new HashSet<BinTree>();
        serializeInternally(binTree, sb, visitedElems);
        return sb.toString();
    }

    private static void serializeInternally(BinTree binTree, StringBuilder sb, Set<BinTree> visitedElems) throws BinTreeSerializationException {
        if (binTree == null) {
            sb.append("$ ");
            return;
        }

        if(isAlreadyVisited(binTree, visitedElems)) {
            throw new BinTreeSerializationException("Detected cycle");
        }

        addToVisited(binTree, visitedElems);
        sb.append(binTree.getValue()).append(" ");
        serializeInternally(binTree.getLeft(), sb, visitedElems);
        serializeInternally(binTree.getRight(), sb, visitedElems);
    }

    private static void addToVisited(BinTree binTree, Set<BinTree> visitedElems) {
        visitedElems.add(binTree);
    }

    private static boolean isAlreadyVisited(BinTree binTree, Set<BinTree> visitedElems) {
        return visitedElems.contains(binTree);
    }

}
