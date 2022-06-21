package DAO;

import Model.MillingProduct;

public interface MillingProductDAO {

    MillingProduct get();
    Boolean update(MillingProduct millingProduct);

    boolean sellFibreOilCan(double number);
    boolean sellPalmOilDrum(int number);
    boolean sellPalmOilCan(int number);



}
