package org.quicktheories.generators;

import org.quicktheories.core.Gen;

/**
 * A Class for creating Double Sources that will produce doubles within a set
 * interval and will shrink within this domain.
 */
public class DoublesDSL {

  /**
   * Generates Doubles inclusively bounded below by Double.NEGATIVE_INFINITY and
   * above by Double.POSITIVE_INFINITY.
   * 
   * @return a Source of type Double
   */
  public Gen<Double> any() {
    return Doubles.fromNegativeInfinityToPositiveInfinity();

  }

  /**
   * Generates Doubles inclusively bounded below by Double.NEGATIVE_INFINITY and
   * above by a value very close to zero on the negative side.
   * 
   * @return a Source of type Double
   */
  public Gen<Double> negative() {
    return Doubles.negative();
  }

  /**
   * Generates Doubles inclusively bounded below by a value very close to zero
   * on the positive side and above by Double.POSITIVE_INFINITY.
   * 
   * @return a Source of type Double
   */
  public Gen<Double> positive() {
    return Doubles.positive();
  }


  /**
   * Generates Doubles inclusively bounded below by zero and above by one.
   * 
   * @return a Source of type Double
   */
  public Gen<Double> fromZeroToOne() {
    return Doubles.fromZeroToOne();
  }
  
  /**
   * Generates Doubles inclusively between two bounds
   * @param minInclusive minimum value to generate
   * @param maxInclusive maximum value to generate
   * @return a Gen of Doubles between minInclusive and maxInclusive
   */
  public Gen<Double> between(double minInclusive, double maxInclusive) {
    return Doubles.between(minInclusive, maxInclusive);
  }
  
  /**
   * Starts a range
   * 
   * @param startInclusive
   *          - lower bound of domain
   * @return start of range
   */
  public DoubleDomainBuilder from(final double startInclusive) {
    return new DoubleDomainBuilder(startInclusive);
  }

  
  public class DoubleDomainBuilder {

    private final double startInclusive;

    private DoubleDomainBuilder(double startInclusive) {
      this.startInclusive = startInclusive;
    }

    /**
     * Generates within the interval specified with an inclusive lower
     * and upper bound.
     * 
     * @param endInclusive
     *          - inclusive upper bound of domain
     * @return a Source of type Double
     */
    public Gen<Double> upToAndIncluding(final double endInclusive) {
      return between(startInclusive, endInclusive);
    }

  }
  
}
