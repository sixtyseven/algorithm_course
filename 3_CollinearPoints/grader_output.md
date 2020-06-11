See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED
API:          PASSED

Spotbugs:     FAILED (5 warnings)
PMD:          FAILED (5 warnings)
Checkstyle:   FAILED (0 errors, 19 warnings)

Correctness:  41/41 tests passed
Memory:       1/1 tests passed
Timing:       41/41 tests passed

Aggregate score: 100.00%
[Compilation: 5%, API: 5%, Spotbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
3.8K May 30 03:23 BruteCollinearPoints.java
5.8K May 30 03:23 FastCollinearPoints.java
4.9K May 30 03:23 Point.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Point.java
*-----------------------------------------------------------

% javac LineSegment.java
*-----------------------------------------------------------

% javac BruteCollinearPoints.java
*-----------------------------------------------------------

% javac FastCollinearPoints.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Point:

BruteCollinearPoints:

FastCollinearPoints:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------
L D FE_FLOATING_POINT_EQUALITY FE: Tests for exact floating-point equality. Because floating-point calculations may involve rounding, the calculated values may be imprecise.  At BruteCollinearPoints.java:[line 40]
M C SLS_SUSPICIOUS_LOOP_SEARCH SLS: This method new FastCollinearPoints(Point[]) continues a loop after finding an equality condition  At FastCollinearPoints.java:[line 70]
L P UPM_UNCALLED_PRIVATE_METHOD UPM: The private method 'contains()' is never called.  At FastCollinearPoints.java:[lines 120-126]
M P UPM_UNCALLED_PRIVATE_METHOD UPM: The private method 'doubleArray()' is never called.  At FastCollinearPoints.java:[lines 112-116]
L D FE_FLOATING_POINT_EQUALITY FE: Tests for exact floating-point equality. Because floating-point calculations may involve rounding, the calculated values may be imprecise.  At FastCollinearPoints.java:[line 66]
Warnings generated: 5


================================================================


% pmd .
*-----------------------------------------------------------
BruteCollinearPoints.java:6: The private instance (or static) variable 'numOfSegments' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
FastCollinearPoints.java:10: The private instance (or static) variable 'numOfSegments' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
FastCollinearPoints.java:11: The private instance (or static) variable 'lineSegments' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
FastCollinearPoints.java:72: Avoid reassigning the loop control variable 'j' [AvoidReassigningLoopVariables]
FastCollinearPoints.java:119: Avoid unused private methods, such as 'contains(T,T)'. [UnusedPrivateMethod]
PMD ends with 5 warnings.


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] BruteCollinearPoints.java:36:19: '=' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:36:19: '=' is not preceded with whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:37:23: '=' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:37:23: '=' is not preceded with whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:38:17: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:38:20: '(' is followed by whitespace. [ParenPad]
[WARN] BruteCollinearPoints.java:38:27: '=' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:38:27: '=' is not preceded with whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:39:21: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:39:29: Do not use the letter 'l' as a local variable name. It is hard to distinguish from the number '1'. [LocalVariableName]
[WARN] BruteCollinearPoints.java:39:30: '=' is not followed by whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:39:30: '=' is not preceded with whitespace. [WhitespaceAround]
[WARN] BruteCollinearPoints.java:39:37: '<' is not preceded with whitespace. [WhitespaceAround]
[WARN] FastCollinearPoints.java:1:8: Unused import statement for 'edu.princeton.cs.algs4.MergeBU'. [UnusedImports]
[WARN] FastCollinearPoints.java:2:8: Unused import statement for 'edu.princeton.cs.algs4.MergeX'. [UnusedImports]
[WARN] FastCollinearPoints.java:72:26: Control variable 'j' is modified inside loop. [ModifiedControlVariable]
[WARN] Point.java:13:8: Unused import statement for 'edu.princeton.cs.algs4.In'. [UnusedImports]
[WARN] Point.java:14:8: Unused import statement for 'edu.princeton.cs.algs4.StdOut'. [UnusedImports]
[WARN] Point.java:109:28: '(' is preceded with whitespace. [MethodParamPad]
Checkstyle ends with 0 errors and 19 warnings.

% custom checkstyle checks for Point.java
*-----------------------------------------------------------

% custom checkstyle checks for BruteCollinearPoints.java
*-----------------------------------------------------------

% custom checkstyle checks for FastCollinearPoints.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Point
*-----------------------------------------------------------
Running 3 total tests.

Test 1: p.slopeTo(q)
  * positive infinite slope, where p and q have coordinates in [0, 500)
  * positive infinite slope, where p and q have coordinates in [0, 32768)
  * negative infinite slope, where p and q have coordinates in [0, 500)
  * negative infinite slope, where p and q have coordinates in [0, 32768)
  * positive zero     slope, where p and q have coordinates in [0, 500)
  * positive zero     slope, where p and q have coordinates in [0, 32768)
  * symmetric for random points p and q with coordinates in [0, 500)
  * symmetric for random points p and q with coordinates in [0, 32768)
  * transitive for random points p, q, and r with coordinates in [0, 500)
  * transitive for random points p, q, and r with coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 500)
  * slopeTo(), where p and q have coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 10)
  * throw a java.lang.NullPointerException if argument is null
==> passed

Test 2: p.compareTo(q)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p and q have coordinates in [0, 500)
  * antisymmetric, where p and q have coordinates in [0, 32768)
  * transitive, where p, q, and r have coordinates in [0, 500)
  * transitive, where p, q, and r have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 500)
  * sign of compareTo(), where p and q have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 10)
  * throw java.lang.NullPointerException exception if argument is null
==> passed

Test 3: p.slopeOrder().compare(q, r)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p, q, and r have coordinates in [0, 500)
  * antisymmetric, where p, q, and r have coordinates in [0, 32768)
  * transitive, where p, q, r, and s have coordinates in [0, 500)
  * transitive, where p, q, r, and s have coordinates in [0, 32768)
  * sign of compare(), where p, q, and r have coordinates in [0, 500)
  * sign of compare(), where p, q, and r have coordinates in [0, 32768)
  * sign of compare(), where p, q, and r have coordinates in [0, 10)
  * throw java.lang.NullPointerException if either argument is null
==> passed


Total: 3/3 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference Point and LineSegment)
********************************************************************************

Testing correctness of BruteCollinearPoints
*-----------------------------------------------------------
Running 17 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - no 5 (or more) points are collinear
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
  * filename = horizontal25.txt
==> passed

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
  *  5 random horizontal line segments
  * 10 random horizontal line segments
  * 15 random horizontal line segments
==> passed

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
  * filename = vertical25.txt
==> passed

Test 3b: random vertical line segments
  *  1 random vertical line segment
  *  5 random vertical line segments
  * 10 random vertical line segments
  * 15 random vertical line segments
==> passed

Test 4a: points from a file with no line segments
  * filename = random23.txt
  * filename = random38.txt
==> passed

Test 4b: random points with no line segments
  *  5 random points
  * 10 random points
  * 20 random points
  * 50 random points
==> passed

Test 5: points from a file with fewer than 4 points
  * filename = input1.txt
  * filename = input2.txt
  * filename = input3.txt
==> passed

Test 6: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 7: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 8: random line segments, none vertical or horizontal
  *  1 random line segment
  *  5 random line segments
  * 10 random line segments
  * 15 random line segments
==> passed

Test 9: random line segments
  *  1 random line segment
  *  5 random line segments
  * 10 random line segments
  * 15 random line segments
==> passed

Test 10: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
  * equidistant.txt
==> passed

Test 11: check that data type does not mutate the constructor argument
  * input8.txt
  * equidistant.txt
==> passed

Test 12: numberOfSegments() is consistent with segments()
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = horizontal5.txt
  * filename = vertical5.txt
  * filename = random23.txt
==> passed

Test 13: throws an exception if either the constructor argument is null
         or any entry in array is null
  * argument is null
  * Point[] of length 10, number of null entries = 1
  * Point[] of length 10, number of null entries = 10
  * Point[] of length 4, number of null entries = 1
  * Point[] of length 3, number of null entries = 1
  * Point[] of length 2, number of null entries = 1
  * Point[] of length 1, number of null entries = 1
==> passed

Test 14: check that the constructor throws an exception if duplicate points
  * 50 points
  * 25 points
  * 5 points
  * 4 points
  * 3 points
  * 2 points
==> passed


Total: 17/17 tests passed!


================================================================
Testing correctness of FastCollinearPoints
*-----------------------------------------------------------
Running 21 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = input299.txt
==> passed

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
  * filename = horizontal25.txt
  * filename = horizontal50.txt
  * filename = horizontal75.txt
  * filename = horizontal100.txt
==> passed

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
  *  5 random horizontal line segments
  * 10 random horizontal line segments
  * 15 random horizontal line segments
==> passed

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
  * filename = vertical25.txt
  * filename = vertical50.txt
  * filename = vertical75.txt
  * filename = vertical100.txt
==> passed

Test 3b: random vertical line segments
  *  1 random vertical line segment
  *  5 random vertical line segments
  * 10 random vertical line segments
  * 15 random vertical line segments
==> passed

Test 4a: points from a file with no line segments
  * filename = random23.txt
  * filename = random38.txt
  * filename = random91.txt
  * filename = random152.txt
==> passed

Test 4b: random points with no line segments
  *  5 random points
  * 10 random points
  * 20 random points
  * 50 random points
==> passed

Test 5a: points from a file with 5 or more on some line segments
  * filename = input9.txt
  * filename = input10.txt
  * filename = input20.txt
  * filename = input50.txt
  * filename = input80.txt
  * filename = input300.txt
  * filename = inarow.txt
==> passed

Test 5b: points from a file with 5 or more on some line segments
  * filename = kw1260.txt
  * filename = rs1423.txt
==> passed

Test 6: points from a file with fewer than 4 points
  * filename = input1.txt
  * filename = input2.txt
  * filename = input3.txt
==> passed

Test 7: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = input299.txt
==> passed

Test 8: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 9: random line segments, none vertical or horizontal
  *  1 random line segment
  *  5 random line segments
  * 25 random line segments
  * 50 random line segments
  * 100 random line segments
==> passed

Test 10: random line segments
  *  1 random line segment
  *  5 random line segments
  * 25 random line segments
  * 50 random line segments
  * 100 random line segments
==> passed

Test 11: random distinct points in a given range
  * 5 random points in a 10-by-10 grid
  * 10 random points in a 10-by-10 grid
  * 50 random points in a 10-by-10 grid
  * 90 random points in a 10-by-10 grid
  * 200 random points in a 50-by-50 grid
==> passed

Test 12: m*n points on an m-by-n grid
  * 3-by-3 grid
  * 4-by-4 grid
  * 5-by-5 grid
  * 10-by-10 grid
  * 20-by-20 grid
  * 5-by-4 grid
  * 6-by-4 grid
  * 10-by-4 grid
  * 15-by-4 grid
  * 25-by-4 grid
==> passed

Test 13: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
  * equidistant.txt
==> passed

Test 14: check that data type does not mutate the constructor argument
  * input8.txt
  * equidistant.txt
==> passed

Test 15: numberOfSegments() is consistent with segments()
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = horizontal5.txt
  * filename = vertical5.txt
  * filename = random23.txt
==> passed

Test 16: throws an exception if either constructor argument is null
         or any entry in array is null
  * argument is null
  * Point[] of length 10, number of null entries = 1
  * Point[] of length 10, number of null entries = 10
  * Point[] of length 4, number of null entries = 1
  * Point[] of length 3, number of null entries = 1
  * Point[] of length 2, number of null entries = 1
  * Point[] of length 1, number of null entries = 1
==> passed

Test 17: check that the constructor throws an exception if duplicate points
  * 50 points
  * 25 points
  * 5 points
  * 4 points
  * 3 points
  * 2 points
==> passed


Total: 21/21 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Point
*-----------------------------------------------------------
Running 1 total tests.

The maximum amount of memory per Point object is 32 bytes.

Student memory = 24 bytes (passed)

Total: 1/1 tests passed!


================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing BruteCollinearPoints
*-----------------------------------------------------------
Running 10 total tests.

Test 1a-1e: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    16   0.00        3640           0           3640                   61         
=> passed    32   0.00       71920           0          71920                  151         
=> passed    64   0.01     1270752           0        1270752                  363         
=> passed   128   0.08    21336000           0       21336000                  873         
=> passed   256   0.33   349585280           0      349585280                 2000         
==> 5/5 tests passed

Test 2a-2e: Find collinear points among n/4 arbitrary line segments


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    16   0.00        3788           0           3788                   60         
=> passed    32   0.00       72660           0          72660                  153         
=> passed    64   0.03     1274182           0        1274182                  371         
=> passed   128   0.08    21349268           0       21349268                  860         
=> passed   256   1.29   349637692           0      349637692                 1980         
==> 5/5 tests passed

Total: 10/10 tests passed!


================================================================



Timing FastCollinearPoints
*-----------------------------------------------------------
Running 31 total tests.

Test 1a-1g: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.01        7564       17964          43492                18080         
=> passed   128   0.01       31500       87126         205752                87957         
=> passed   256   0.03      128524      408790         946104               409067         
=> passed   512   0.19      519177     1890033        4299243              1890337         
=> passed  1024   0.47     2086915     8528506       19143927              8546500         
=> passed  2048   1.35     8368083    38092758       84553599             38159618         
==> 6/6 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (84553599 / 19143927) = 2.14
=> passed

==> 7/7 tests passed

Test 2a-2g: Find collinear points among the n points on an n-by-1 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00        3843        4566          12975                 6818         
=> passed   128   0.00       15875       17406          50687                22683         
=> passed   256   0.00       64515       67943         200401                79391         
=> passed   512   0.01      260099      267857         795813               291896         
=> passed  1024   0.03     1044483     1061948        3168379              1111710         
=> passed  2048   0.09     4186115     4225064       12636243              4327262         
=> passed  4096   0.20    16760835    16846869       50454573             17056154         
==> 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (50454573 / 12636243) = 2.00
=> passed

==> 8/8 tests passed

Test 3a-3g: Find collinear points among the n points on an n/4-by-4 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00        5871       14386          34643                16313         
=> passed   128   0.00       24199       42920         110039                62776         
=> passed   256   0.01       98231      147881         393993               241921         
=> passed   512   0.02      395799      544828        1485455               938798         
=> passed  1024   0.07     1588951     2081014        5750979              3677716         
=> passed  2048   0.27     6367319     8109673       22586665             14490528         
=> passed  4096   1.04    25492311    31965619       89423549             57411701         
==> 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (89423549 / 22586665) = 1.99
=> passed

==> 8/8 tests passed

Test 4a-4g: Find collinear points among the n points on an n/8-by-8 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00        5888       17251          40390                18235         
=> passed   128   0.00       24308       74449         173206                83720         
=> passed   256   0.01       98717      229652         558021               336951         
=> passed   512   0.04      397837      849527        2096891              1334387         
=> passed  1024   0.13     1597244     3251178        8099600              5303578         
=> passed  2048   0.45     6400767    12679845       31760457             21141596         
=> passed  4096   1.87    25626622    50004769      125636160             84303939         
==> 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (125636160 / 31760457) = 1.98
=> passed

==> 8/8 tests passed

Total: 31/31 tests passed!


================================================================