package com.ivk23.algorithms.dynamicConnectivityProblem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickUnionAlgorithmTest {

    private UnionFindDataType UF;

    // be careful - it takes a lot of time for this test to finish :)
    @Disabled
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
        UF = new UnionFindDataType(N, QuickUnionAlgorithm::new);
        //UF.printMe();
        System.out.println("Start processing " + N + " items.");

        String line;
        int i=1;
        while ((line = reader.readLine()) != null) {
            final var newPair = line.split(" ");

            int p = Integer.parseInt(newPair[0]);
            int q = Integer.parseInt(newPair[1]);

            System.out.println(String.format("Processing line %d: p=%d, q=%d", i++, p, q));

            if (UF.connected(p, q)) continue;

            UF.union(p, q);

            //UF.printMe();
        }

        reader.close();
    }

}