package com.ivk23.algorithms.dynamicConnectivityProblem;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UnionFindDataType {

    private int[] id;
    private int count;
    private UnionFindAlgorithm algorithm;

    public UnionFindDataType(int N, Function<int[], UnionFindAlgorithm> function) {
        this.count = N;

        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            this.id[i] = i;
        }

        this.algorithm = function.apply(this.id);
    }

    public boolean connected(int p, int q) {
        return this.algorithm.find(p) == this.algorithm.find(q);
    }

    public void union(int p, int q) {
        final boolean newConnection = this.algorithm.union(p, q);
        if (newConnection) {
            this.count--;
        }
    }

    public int count() {
        return this.count;
    }

    public void printMe() {
        final String line1 = IntStream
                .iterate(0, val -> val < this.id.length, val -> val + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        final StringBuilder line2 = new StringBuilder("");
        for (int el : this.id) {
            line2.append(el).append(" ");
        }

        System.out.println(line1);
        System.out.println(line2.toString().trim());
        System.out.println("-----------------------------------");
    }

    public void printNodes(int p, int q) {
        StringBuilder nodes = new StringBuilder("");
        for (int i = 0; i < this.id.length; i++) {
            if (i == p) {
                nodes.append("[p]").append(" ");
            } else if (i == q) {
                nodes.append("[q]").append(" ");
            } else {
                nodes.append(" " + i + " ").append(" ");
            }
        }
        System.out.println(nodes.toString());
    }

    public void printRoots(int p, int q) {
        StringBuilder roots = new StringBuilder("");
        for (int i = 0; i < this.id.length; i++) {
            roots.append(" " + id[i] + " ").append(" ");
        }
        System.out.println(roots.toString());
        System.out.println("");
    }

}
