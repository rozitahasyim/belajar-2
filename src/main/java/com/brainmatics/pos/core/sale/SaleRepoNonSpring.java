package com.brainmatics.pos.core.sale;

import com.brainmatics.commom.Repository;

public interface SaleRepo extends Repository<Sale> {
    Sale getByIdEager(int id);
}
