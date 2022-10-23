package product;

import java.util.HashSet;
import java.util.Set;

public class RecipesBook {
    private Set<Recipes> recipes;

    public RecipesBook() {
        recipes = new HashSet<>();
    }

    public void addRecipes(Recipes recipe) {
        if (recipes.contains(recipe)) {
            throw new IllegalArgumentException("Такой рецепт уже есть в книге!");
        } else {
            recipes.add(recipe);
        }
    }

    @Override
    public String toString() {
        return "RecipesBook{" +
                "recipes=" + recipes +
                '}';
    }
}
