package org.acme.quarkus.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.acme.quarkus.entity.UserFood;
import org.acme.quarkus.entity.Users;

@ApplicationScoped
public class DietService {
	
	@Inject 
	EntityManager entityManager ;
	
	@Transactional
	public String addFoodDiet(String nameOftheFood, int userid , int amountOftheItem ) {
		
		Users user = entityManager.find(Users.class, userid);
		boolean isUserFoodPresent = false;
		if(user != null) {
			
			UserFood userFood = new UserFood(user.getId(), nameOftheFood, new java.sql.Timestamp(new java.util.Date().getTime()) , amountOftheItem);
			entityManager.persist(userFood);
			isUserFoodPresent = true ;
		}
		
		return isUserFoodPresent ? "Entity has been added" : "Entity has not been added" ;
	}
	

	@Transactional
	public String deleteFoodItem(int userid , String foodName) {
		Users user = entityManager.find(Users.class, userid);
		boolean isFoodRemoved = false ;
		
		if(user != null) {
			Query query = entityManager.createQuery(" from UserFood a where a.name = ?1");
			query.setParameter(1, foodName); 
			
			List<Object> entityList = query.getResultList();
			for(Object obj : entityList) {
				UserFood food = (UserFood)obj ;
				entityManager.remove(food);
				isFoodRemoved = true ;
			}
		}
		
		return isFoodRemoved ? "Food Removed Please check" : "Food Not Removed, either User or Food  is not present" ;
	}
	
	
	public List<Object> listFoodItems(int userid){
		Query query = entityManager.createQuery("Select * from dietjournal.usersfood where userid = ?1");
		query.setParameter(1, userid);
		
		return query.getResultList();
	}
	
	

}
