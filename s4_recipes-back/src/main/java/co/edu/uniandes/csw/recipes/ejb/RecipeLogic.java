/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.ejb;

import co.edu.uniandes.csw.recipes.entities.RecipeEntity;
import co.edu.uniandes.csw.recipes.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.recipes.persistence.RecipePersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author CesarF
 */
@Stateless
public class RecipeLogic {
    @Inject
    private RecipePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    public RecipeEntity getRecipe(Long id) {
        return persistence.find(id);
    }

    //TODO crear el método createRecipe
    
    public RecipeEntity createRecipe(RecipeEntity entidad) throws BusinessLogicException{
        
        RecipeEntity nueva = null;
        
        if(entidad != null){
            if(persistence.find(entidad.getId()) != null){
                throw new BusinessLogicException("La receta con ese id ya existe");
            }
            else if(persistence.findByName(entidad.getName() ) != null || entidad.getName() == null || entidad.getName().equals("") ){
                throw new BusinessLogicException("La receta con ese nombre ya existe");
            }
            else if(entidad.getName().length()>30){
                throw new BusinessLogicException("el nombre es muy largo");
            }
            else if(entidad.getDescription().length()>150){
                throw new BusinessLogicException("la descripción es muy largo");
            }
            else{
                nueva = persistence.createRecipe(entidad);
            }
        }
        
        return nueva;
    }


}
