import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

public class BruteForce {

    Grafo g;

    public BruteForce(Grafo g) {
        this.g = g;
    }

    // Recebido o grafico, deveriam ser gerados todos os caminhos que, partindo 
    // de um dado vertice, retornem ao mesmo apos passar por todos os outros
    // Se eu enumerar os vertices de 1 a n, colocar , criar n! permutacoes e 
    // testar se cada permutaçao permite um caminho valido (ou seja, que cumpra
    // a questao do problema). Se sim, calcular o tamanho do caminho e ver se e 
    // o menor encontrado.
    static public int[] findPermutation(int n, long k) {
        // Esse metodo foi copiado (e depois, adaptado) de 
        // https://stackoverflow.com/questions/31216097/given-n-and-k-return-the-kth-permutation-sequence
        int[] numbers = new int[n];
        long[] indices = new long[n];

        // initialise the numbers 1, 2, 3...
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        long divisor = 1;
        for (long place = 1; place <= n; place++) {
            if ((k / divisor) == 0) {
                break;	// all the remaining indices will be zero
            }
            // compute the index at that place:
            long aux = (k / divisor) % place;
            indices[n - (int) place] = (k / divisor) % place;
            divisor *= place;
        }

        // print out the indices:
        // System.out.println(Arrays.toString(indices));
        // permute the numbers array according to the indices:
        for (int i = 0; i < n; i++) {
            long index = indices[i] + i;

            // take the element at index and place it at i, moving the rest up
            if (index != i) {
                int temp = numbers[(int) index];
                for (int j = (int) index; j > i; j--) {
                    numbers[j] = numbers[j - 1];
                }
                numbers[i] = temp;
            }
        }

        return numbers;
    }

    public static long factorial(long number) {
        long result = 1;

        for (long factor = 2; factor <= number; factor++) {
            result = result * factor;
        }

        return result;
    }

    boolean validPermutation(int[] permut) {
        // Verifica se existe um ciclo entre os vertices propostos pela
        // permutacao
        for (int i = 0; i < permut.length - 1; i++) {
            if (!g.existsEdge(permut[i], permut[i + 1])) {
                return false;
            }
        }
        int lenght = permut.length;
        return g.existsEdge(permut[lenght - 1], permut[0]);
    }

    int lenghtPermut(int[] permut) {
        // Calcula o comprimento do caminho proposto pela permutacao
        int lenght = 0;

        for (int i = 0; i < permut.length - 1; i++) {
            lenght += g.getWeight(permut[i], permut[i + 1]);
        }

        lenght += g.getWeight(permut[permut.length - 1], permut[0]);

        return lenght;
    }

    int[] subtrai(int[] permut) {
        for (int i = 0; i < permut.length; i++) {
            permut[i]--;
        }

        return permut;

    }

    public int[] rodaCaminhos() {
        // Recolhendo o numero de vertices do grafo
        int numV = g.getVertices();
        long fact = factorial(numV);

        int[] savePermut = null;
        int fasterLenghtPath = 1000000000; // numero absurdo
        int[] permut = null;

        for (long i = 0; i < fact; i++) {
            permut = subtrai(findPermutation(numV, i));

            //  System.out.println(Arrays.toString(permut));
            if (validPermutation(permut) == true) {
                int lenghtPath = lenghtPermut(permut);
                if (lenghtPath < fasterLenghtPath) {
                    fasterLenghtPath = lenghtPath;
                    savePermut = permut;
                }
            }

        }
        return savePermut;

    }

}