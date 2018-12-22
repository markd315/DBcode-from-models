package io.swagger.service;

import io.swagger.model.Order;
import io.swagger.model.Category;
import io.swagger.model.User;
import io.swagger.model.Tag;
import io.swagger.model.ModelApiResponse;
import io.swagger.model.Pet;
import java.util.Collection;

public interface ResourceService {

    void saveOrder(Order order);
    Order findOrderById(int Id);
    void deleteOrder(Order order);
    Collection<Order> findAllOrders();void saveCategory(Category category);
    Category findCategoryById(int Id);
    void deleteCategory(Category category);
    Collection<Category> findAllCategorys();void saveUser(User user);
    User findUserById(int Id);
    void deleteUser(User user);
    Collection<User> findAllUsers();void saveTag(Tag tag);
    Tag findTagById(int Id);
    void deleteTag(Tag tag);
    Collection<Tag> findAllTags();void saveModelApiResponse(ModelApiResponse modelapiresponse);
    ModelApiResponse findModelApiResponseById(int Id);
    void deleteModelApiResponse(ModelApiResponse modelapiresponse);
    Collection<ModelApiResponse> findAllModelApiResponses();void savePet(Pet pet);
    Pet findPetById(int Id);
    void deletePet(Pet pet);
    Collection<Pet> findAllPets();





}
