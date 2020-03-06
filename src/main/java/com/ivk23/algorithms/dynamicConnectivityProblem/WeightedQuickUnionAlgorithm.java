package com.ivk23.algorithms.dynamicConnectivityProblem;

import java.util.Arrays;

public class WeightedQuickUnionAlgorithm implements UnionFindAlgorithm {

    private final int[] id;
    private final int[] sz;

    public WeightedQuickUnionAlgorithm(int[] id) {
        this.id = id;

        this.sz = new int[id.length];
        Arrays.fill(this.sz, 1);
    }

    @Override
    public boolean union(int p, int q) {
        final var pRoot = find(p);
        final var qRoot = find(q);

        if (pRoot == qRoot) {
            return false;
        }

        if (this.sz[pRoot] < this.sz[qRoot]) {
            this.id[pRoot] = qRoot;
            this.sz[qRoot] += this.sz[pRoot];
        } else {
            this.id[qRoot] = pRoot;
            this.sz[pRoot] += this.sz[qRoot];
        }

        return true;
    }

    @Override
    public int find(int p) {

        // find root
        while (p != this.id[p]) {
            p = this.id[p];
        }

        return p;
    }
}
