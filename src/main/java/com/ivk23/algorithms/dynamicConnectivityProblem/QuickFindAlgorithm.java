package com.ivk23.algorithms.dynamicConnectivityProblem;

public class QuickFindAlgorithm implements UnionFindAlgorithm {

    private final int[] id;

    public QuickFindAlgorithm(int[] id) {
        this.id = id;
    }

    @Override
    public boolean union(int p, int q) {
        final int pID = find(p);
        final int qID = find(q);

        if (pID == qID) {
            // p and q are connected iff they have the same id
            return false;
        }

        // To merge components containing p and q, we need to change all entries
        // whose id equals id[p] to id[q].
        for (int i=0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }

        return true;
    }

    @Override
    public int find(int p) {
        return this.id[p];
    }
}
