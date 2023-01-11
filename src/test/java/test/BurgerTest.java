package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientSecond;

    @Test
    public void setBunForBurger() {
        burger = new Burger();
        burger.setBuns(bun);
        Bun expected = bun;
        Bun actual = burger.bun;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addIngredientAddIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        Ingredient expected = ingredient;
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeIngredientSetIngredientIsEmpty() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientChangeIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(1, 0);
        Ingredient expected = ingredientSecond;
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getPriceSumBunAndIngredients() {
        burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(50f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        float expected = 150f;
        float actual = burger.getPrice();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceipt() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("bunName");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("ingredientName");
        Mockito.when(burger.getPrice()).thenReturn(200f);

        String expected =
                String.format("(==== %s ====)%n", "bunName") +
                        String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), "ingredientName") +
                        String.format("(==== %s ====)%n", "bunName") +
                        String.format("%nPrice: %f%n", 200f);
        String actual = burger.getReceipt();


        Assert.assertEquals("Receipt incorrect", expected, actual);
    }

}
