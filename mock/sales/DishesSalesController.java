package mock.sales;

import mock.sales.dto.SalesRespDto;

import java.util.List;

/**
 * 菜品情况分析
 */
public interface DishesSalesController {
    List<SalesRespDto> listDishesSales();
}
