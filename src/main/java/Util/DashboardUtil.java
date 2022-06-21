package Util;

public class DashboardUtil {
    private int unmilledBatches;

    private int milledBatches;

    private String month;

    private Double totalIncome;

    private Double totalExpenses;
    private Double totalHarvestStockCost;

    private Double profitOrLoss;

    private Double profitMargin;



    public int getUnmilledBatches() {
        return unmilledBatches;
    }

    public void setUnmilledBatches(int unmilledBatches) {
        this.unmilledBatches = unmilledBatches;
    }

    public int getMilledBatches() {
        return milledBatches;
    }

    public void setMilledBatches(int milledBatches) {
        this.milledBatches = milledBatches;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Double getTotalHarvestStockCost() {
        return totalHarvestStockCost;
    }

    public void setTotalHarvestStockCost(Double totalHarvestStockCost) {
        this.totalHarvestStockCost = totalHarvestStockCost;
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Double getProfitOrLoss() {
        return ( this.totalIncome - this.totalExpenses);
    }

    public void setProfitOrLoss(Double profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }


    public Double getProfitMargin() {
        return (( this.totalIncome - this.totalExpenses)/(this.totalExpenses + this.totalIncome));

    }

    public void setProfitMargin(Double profitMargin) {
        this.profitMargin = profitMargin;
    }

    @Override
    public String toString() {
        return "DashboardUtil{" +
                "unmilledBatches=" + unmilledBatches +
                ", milledBatches=" + milledBatches +
                ", month='" + month + '\'' +
                ", totalIncome=" + totalIncome +
                ", totalExpenses=" + totalExpenses +
                ", totalHarvestStockCost=" + totalHarvestStockCost +
                ", profitOrLoss=" + profitOrLoss +
                ", profitMargin=" + profitMargin +
                '}';
    }
}