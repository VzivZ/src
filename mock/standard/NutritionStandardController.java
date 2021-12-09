package mock.standard;

import mock.standard.dto.NutritionStandardDto;

import java.util.List;

/**
 * 就餐营养管理
 */
public interface NutritionStandardController {
    /**
     * 设置营养值标准
     *
     * @return
     */
    Boolean saveNutritionStandard(NutritionStandardDto nutritionStandardDto);

    /**
     * 查询
     * @return
     */
    List<NutritionStandardDto> listNutritionStandard(String grade,String gender);

    /**
     * 修改
     * @param nutritionStandardDto
     * @return
     */
    Boolean modifyNutritionStandardByPk(NutritionStandardDto nutritionStandardDto);

    /**
     *
     * @return
     */
    Boolean removeNutritionNutritionStandardByPkByPk(List<String> standardIds);
}
