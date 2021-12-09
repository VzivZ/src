package mock.recipe;

import mock.recipe.dto.RecipeRespDto;

import java.util.List;

/**
 * 一周菜谱
 */
public interface RecipeController {
    List<RecipeRespDto> listRecipe();
}
