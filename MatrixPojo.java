package com.netckracker.edu.dvorianchicov.tricky_tasks.work_matrix;

public class MatrixPojo {

    private double[][] matrix;
    private int rows;
    private int cols;

    MatrixPojo() {
    }

    MatrixPojo(double[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        this.matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double getElem(int indexRow, int indexCol) {
        if (matrix == null) {
            throw new NullPointerException("Matrix is not initialize");
        } else if (indexRow >= rows || indexCol >= cols) {
            throw new ArrayIndexOutOfBoundsException("No such index exists");
        }
        return matrix[indexRow][indexCol];
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setElem(int indexRow, int indexCol, double elem) {
        if (matrix == null) {
            throw new NullPointerException("Matrix is not initialize");
        } else if (indexRow >= rows || indexCol >= cols) {
            throw new ArrayIndexOutOfBoundsException("No such index exists");
        }
        this.matrix[indexRow][indexCol] = elem;
    }

}
