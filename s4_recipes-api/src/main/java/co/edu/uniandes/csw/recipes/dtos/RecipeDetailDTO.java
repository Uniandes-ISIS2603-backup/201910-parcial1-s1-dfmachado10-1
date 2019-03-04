/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.dtos;

import co.edu.uniandes.csw.recipes.entities.IngredientEntity;
import co.edu.uniandes.csw.recipes.entities.RecipeEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CesarF
 */
public class RecipeDetailDTO extends RecipeDTO {
    
    private List<IngredientDTO> ingredientes;
    
    public RecipeDetailDTO(){
    
    }
    
    public RecipeDetailDTO(RecipeEntity entity){
        super(entity);
        if(entity != null){
            if(entity.getIngredientes() != null){
                for(IngredientEntity entidad: entity.getIngredientes()){
                    
                    ingredientes.add(new IngredientDTO(entidad));
                }
            }
        }
    }
    
    public RecipeEntity toEntity(){
        
        RecipeEntity entidad = super.toEntity();
        
        if(ingredientes != null){
            List<IngredientEntity> ingEnt = new ArrayList<>();
            
            for(IngredientDTO ing : ingredientes){
                ingEnt.add(ing.toEntity());
            }
        }
        
        return entidad;
    }
    
}
