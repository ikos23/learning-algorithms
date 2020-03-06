package com.ivk23.algorithms.dynamicConnectivityProblem;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeightedQuickUnionAlgorithmTest {

    private UnionFindDataType UF;

    @Test
    void UF_large_Test() throws Exception {
        final var is = this.getClass().getClassLoader().getResourceAsStream("dynamicConnectivityProblem/largeUF.txt");
        final var tinyUFReader = new BufferedReader(new InputStreamReader(is));

        processData(tinyUFReader);
        System.out.println("Number of components founded: " + UF.count());

        assertEquals(6, this.UF.count());
    }

    private void processData(BufferedReader reader) throws Exception {
        int N = Integer.parseInt(reader.readLine());
        UF = new UnionFindDataType(N, WeightedQuickUnionAlgorithm::new);
        //UF.printMe();
        System.out.println("Start processing " + N + " items.");

        String line;
        int i=1;
        while ((line = reader.readLine()) != null) {
            final var newPair = line.split(" ");

            int p = Integer.parseInt(newPair[0]);
            int q = Integer.parseInt(newPair[1]);

           //System.out.println(String.format("Processing line %d: p=%d, q=%d", i++, p, q));

            if (UF.connected(p, q)) continue;

            UF.union(p, q);

            //UF.printMe();
        }

        reader.close();
    }

    @Test
    void UF_tiny_Test() throws Exception {
        final var is = this.getClass().getClassLoader().getResourceAsStream("dynamicConnectivityProblem/tinyUF.txt");
        final var reader = new BufferedReader(new InputStreamReader(is));

        int N = Integer.parseInt(reader.readLine());
        UF = new UnionFindDataType(N, WeightedQuickUnionAlgorithm::new);
        System.out.println("Start processing " + N + " items.\n");

        System.out.println(IntStream
                .iterate(0, val -> val < N, val -> val + 1)
                .mapToObj(i -> " " + i + " ")
                .collect(Collectors.joining(" ")) + "\n");

        String line;
        int i=1;
        while ((line = reader.readLine()) != null) {
            final var newPair = line.split(" ");

            int p = Integer.parseInt(newPair[0]);
            int q = Integer.parseInt(newPair[1]);

            //System.out.println(String.format("Processing line %d: p=%d, q=%d", i++, p, q));
            UF.printNodes(p, q);

            if (UF.connected(p, q)) {
                UF.printRoots(p, q);
                continue;
            }

            UF.union(p, q);
            UF.printRoots(p, q);
        }
        System.out.println("\nNumber of components founded: " + UF.count());
        assertEquals(2, this.UF.count());
    }
}