package com.ivk23.algorithms.dynamicConnectivityProblem;

public interface UnionFindAlgorithm {

    default boolean union(int p, int q) {
        throw new UnsupportedOperationException();
    }

    default int find(int p) {
        throw new UnsupportedOperationException();
    }

}
