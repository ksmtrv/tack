package ru.vsu.cs;

public class RowCalculateResult {
    int iteration;
    double sumEpsilon;

    public RowCalculateResult(int iteration, double sumEpsilon) {
        this.iteration = iteration;
        this.sumEpsilon = sumEpsilon;
    }

    public int getIteration(){
        return iteration;
    }

    public double getSumEpsilon() {
        return sumEpsilon;
    }
}
