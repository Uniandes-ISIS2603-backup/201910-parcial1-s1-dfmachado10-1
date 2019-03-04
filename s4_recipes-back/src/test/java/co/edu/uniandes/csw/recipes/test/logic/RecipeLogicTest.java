/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.test.logic;

import co.edu.uniandes.csw.recipes.ejb.RecipeLogic;
import co.edu.uniandes.csw.recipes.entities.IngredientEntity;
import co.edu.uniandes.csw.recipes.entities.RecipeEntity;
import co.edu.uniandes.csw.recipes.persistence.RecipePersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class RecipeLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private RecipeLogic reLogic;
    
    @Inject
    RecipePersistence recipePersistence;

    @PersistenceContext
    EntityManager em;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RecipeEntity.class.getPackage())
                .addPackage(IngredientEntity.class.getPackage())
                .addPackage(RecipePersistence.class.getPackage())
                .addPackage(RecipeLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Test
    public void createRecipeTest(){
        
        RecipeEntity entidad = factory.manufacturePojo(RecipeEntity.class);
        entidad.setName("Pollo asado");
        entidad.setDescription("Muy rico");
            
        try {
            
            RecipeEntity nuevo = reLogic.createRecipe(entidad);
            
            Assert.assertNotNull(nuevo);
        
            RecipeEntity entidadNueva = em.find(RecipeEntity.class,nuevo.getId());
        
            Assert.assertEquals(entidadNueva.getId()+"", entidad.getId()+"");
            Assert.assertEquals(entidadNueva.getName(), entidad.getName());
            Assert.assertEquals(entidadNueva.getDescription(), entidad.getDescription());
                
                
        } catch (Exception e) {
            
            Assert.fail("No deberia fallar");
        }
        
        
    }
    
    
}
