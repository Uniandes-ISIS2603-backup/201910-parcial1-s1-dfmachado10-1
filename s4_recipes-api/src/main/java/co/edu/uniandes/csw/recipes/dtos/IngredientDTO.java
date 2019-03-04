/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.dtos;

import co.edu.uniandes.csw.recipes.entities.IngredientEntity;
import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class IngredientDTO implements Serializable {
    
    private Long id;
    
    private String name;
    
    private Long calories;

    public IngredientDTO() {
        
        
    }

    public IngredientDTO(IngredientEntity entidad) {
        this.id = entidad.getId();
        this.name = entidad.getName();
        this.calories = entidad.getCalories();
    }
    
    public IngredientEntity toEntity() {
        IngredientEntity entity = new IngredientEntity();
        entity.setId(this.id);
        entity.setName(this.name);   	
        return entity;
    }

    
}
