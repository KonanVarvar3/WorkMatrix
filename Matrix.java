package com.netckracker.edu.dvorianchicov.tricky_tasks.work_matrix;

/**
 * Class for work with matrices
 *
 * @author Dvorianchicov Sergey
 */
public class Matrix implements IMatrixWorker {

    @Override
    public void print(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Method for definition of the same number of elements in a line,
     * because matrices must be square or rectangular
     */
    public boolean checkMatrixCol(double[][] m1) {
        //compare the length of the first line with others
        for (int i = 0; i < m1.length; i++) {
            if (m1[0].length > m1[i].length || m1[0].length < m1[i].length) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean haveSameDimension(double[][] m1, double[][] m2) {
        return (m1.length == m2.length && checkMatrixCol(m1) && checkMatrixCol(m2));
    }

    @Override
    public double[][] add(double[][] m1, double[][] m2) throws HaveSameDimensionExeption {
        if (!haveSameDimension(m1, m2)) {//use this method, since matrices must be of the same dimension
            throw new HaveSameDimensionExeption("Matrices do not have same dimension!");
        }
        double[][] matrix = new double[m1.length][m1[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                matrix[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return matrix;
    }

    @Override
    public double[][] subtract(double[][] m1, double[][] m2) throws HaveSameDimensionExeption {
        double[][] matrix = new double[m1.length][m1[0].length];

        if (!haveSameDimension(m1, m2)) {//use this method, since matrices must be of the same dimension
            throw new HaveSameDimensionExeption("Matrices do not have same dimension!");
        }
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                matrix[i][j] = m1[i][j] - m2[i][j];
            }
        }
        return matrix;
    }

    /**
     * 1.For matrix multiplication it is necessary that the number
     * of columns in the first matrix be equal to the number of rows in the second.
     * <p>
     * 2.The size of the resulting matrix will consist of the number of rows
     * from the first matrix and the number of columns from the second.
     * <p>
     * 3.Multiplies row by column and add elements
     * <p>
     * For example, to get the first element of the resulting matrix,
     * need to multiply the elements from the first row by the first column and add
     */
    @Override
    public double[][] multiply(double[][] m1, double[][] m2) throws MultiplyMatrixExeption {
        if (!checkMatrixCol(m1) || !checkMatrixCol(m2) || m1[0].length != m2.length) {
            throw new MultiplyMatrixExeption("Matrices do not have same number elements in rows or the number\n" +
                    " * of columns in the first matrix is not equal to the number of rows in the second");
        }
        double[][] matrix = new double[m1.length][m2[0].length];

        int m = m1[0].length;

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                for (int k = 0; k < m; k++) {
                    matrix[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return matrix;
    }
}
