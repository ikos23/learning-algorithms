package com.ivk23.algorithms.dynamicConnectivityProblem;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickFindAlgorithmTest {

    private UnionFindDataType UF;

    @Test
    void UF_tiny_Test() throws Exception {
        final var is = this.getClass().getClassLoader().getResourceAsStream("dynamicConnectivityProblem/tinyUF.txt");
        final var tinyUFReader = new BufferedReader(new InputStreamReader(is));

        processData(tinyUFReader);
        System.out.println("Number of components founded: " + UF.count());

        assertEquals(2, this.UF.count());
    }

    @Test
    void UF_medium_Test() throws Exception {
        final var is = this.getClass().getClassLoader().getResourceAsStream("dynamicConnectivityProblem/mediumUF.txt");
        final var tinyUFReader = new BufferedReader(new InputStreamReader(is));

        processData(tinyUFReader);
        System.out.println("Number of components founded: " + UF.count());

        assertEquals(3, this.UF.count());
    }

    private void processData(BufferedReader reader) throws Exception {
        int N = Integer.parseInt(reader.readLine());
        UF = new UnionFindDataType(N, QuickFindAlgorithm::new);
        //UF.printMe();
        System.out.println("Start processing " + N + " items.");

        String line;
        while ((line = reader.readLine()) != null) {
            final var newPair = line.split(" ");

            int p = Integer.parseInt(newPair[0]);
            int q = Integer.parseInt(newPair[1]);

            if (UF.connected(p, q)) continue;

            UF.union(p, q);

            //UF.printMe();
        }

        reader.close();
    }

}