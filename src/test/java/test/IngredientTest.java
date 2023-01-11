package test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private Ingredient ingredient;
    private String ingredientName = "ingredientName";
    private float ingredientPrice = 100.0f;

    @Mock
    IngredientType type;


    @Test
    public void getPriceForIngredient() {
        ingredient = new Ingredient(type, ingredientName, ingredientPrice);
        float expected = ingredientPrice;
        float actual = ingredient.getPrice();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getNameForIngredient() {
        ingredient = new Ingredient(type, ingredientName, ingredientPrice);
        String expected = ingredientName;
        String actual = ingredient.getName();
        Assert.assertEquals(expected, actual);
    }

}
