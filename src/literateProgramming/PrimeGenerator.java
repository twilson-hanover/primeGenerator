package literateProgramming;

class PrimeGenerator {
  private int numPrimes;

  public PrimeGenerator(int numPrimes) {
    this.numPrimes = numPrimes;
  }

  public int[] generate() {
    final int ORDMAX = 30;
    int primes[] = new int[numPrimes + 1];

    int lastPrimeIndex = 1;
    primes[1] = 2;
    int ORD = 2;
    int nextPrimeSquare = 9;

    int[] multiples = new int[ORDMAX + 1];
    int candidatePrime = 1;
    while (lastPrimeIndex < numPrimes) {
      boolean maybePrime;
      do {
        candidatePrime += 2;
        if (candidatePrime == nextPrimeSquare) {
          ORD++;
          nextPrimeSquare = primes[ORD] * primes[ORD];
          multiples[ORD - 1] = candidatePrime;
        }
        int N = 2;
        maybePrime = true;
        while (N < ORD && maybePrime) {
          while (multiples[N] < candidatePrime)
            multiples[N] += primes[N] + primes[N];
          if (multiples[N] == candidatePrime)
            maybePrime = false;
          N++;
        }
      } while (!maybePrime);
      lastPrimeIndex++;
      primes[lastPrimeIndex] = candidatePrime;
    }
    return primes;
  }
}
