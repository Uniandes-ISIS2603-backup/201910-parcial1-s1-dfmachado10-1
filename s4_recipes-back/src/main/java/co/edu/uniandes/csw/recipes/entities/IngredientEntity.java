/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.entities;

import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author estudiante
 */
public class IngredientEntity extends BaseEntity{
    
    
    private String name;
    
    private Long calories;
    
    @PodamExclude
    @ManyToOne
    private RecipeEntity recipe;

    public String getName() {
        return name;
    }

    public Long getCalories() {
        return calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }
    
    
    
    
    
}
