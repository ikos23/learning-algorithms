package com.ivk23.algorithms.dynamicConnectivityProblem;

public class QuickUnionAlgorithm implements UnionFindAlgorithm {

    private final int[] id;

    public QuickUnionAlgorithm(int[] id) {
        this.id = id;
    }

    @Override
    public boolean union(int p, int q) {
        final var pRoot = find(p);
        final var qRoot = find(q);

        if (pRoot == qRoot) {
            return false;
        }

        this.id[pRoot] = qRoot;
        return true;
    }

    // here idea is to find root for p
    // connected if p and q have the same root.
    @Override
    public int find(int p) {

        while (p != this.id[p]) {
            p = this.id[p];
        }

        return p;
    }
}
