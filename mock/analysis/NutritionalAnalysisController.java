package mock.analysis;

import mock.analysis.dto.NutritionalAnalysisDto;

import java.util.List;

/**
 * 营养分析
 */
public interface NutritionalAnalysisController {
    List<NutritionalAnalysisDto> ListNutritionalReport();
}
