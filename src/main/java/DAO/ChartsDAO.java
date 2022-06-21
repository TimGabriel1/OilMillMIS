package DAO;

public interface ChartsDAO {
    String getCurrentMonth();

    int getUnmilledBatches();
    int getMilledBatches();

    String getIncomeCostPlot();
    String getIncomeDatePlot();
    String getExpenseCategoryCost();
    String getHarvestAndStockPlot();
    Double getTotalIncome();
    Double getTotalHarvestStockCost();
    Double getTotalExpenseAmount();
    Double getTotalOtherCosts();
    Double getTotalHonorarium();
    Double getTotalFuel();
    Double getTotalStorage();
    Double getTotalAdhoc();
    Double getTotalFirewood();
    Double getTotalPlantParts();
    Double getTotalExpenses();






}
