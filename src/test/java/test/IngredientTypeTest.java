package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private Ingredient ingredient;
    private String ingredientName = "ingredientName";
    private float ingredientPrice = 100.0f;
    private IngredientType type;

    public IngredientTypeTest(IngredientType type) {
        this.type = type;
    }


    @Parameterized.Parameters(name = "type={0}")
    public static Object[] type() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    public void getPriceForIngredientType() {
        ingredient = new Ingredient(type, ingredientName, ingredientPrice);
        IngredientType expected = type;
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(expected, actual);
    }


}
