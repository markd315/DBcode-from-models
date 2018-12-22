package io.swagger.service;

import io.swagger.model.Order;
import io.swagger.repository.OrderRepository;
import io.swagger.model.Category;
import io.swagger.repository.CategoryRepository;
import io.swagger.model.User;
import io.swagger.repository.UserRepository;
import io.swagger.model.Tag;
import io.swagger.repository.TagRepository;
import io.swagger.model.Pet;
import io.swagger.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    public ResourceServiceImpl(
      OrderRepository orderRepository, CategoryRepository categoryRepository, UserRepository userRepository, TagRepository tagRepository, PetRepository petRepository){
            this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.petRepository = petRepository;
    }

    private OrderRepository orderRepository;

    @Override
    public Order findOrderById(int id) throws DataAccessException {
        Order order= orderRepository.findById(id);
        return order;
    }

    @Override
    public Collection<Order> findAllOrders() throws DataAccessException {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) throws DataAccessException {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Order order) throws DataAccessException {
        orderRepository.delete(order);
    }

private CategoryRepository categoryRepository;

    @Override
    public Category findCategoryById(int id) throws DataAccessException {
        Category category= categoryRepository.findById(id);
        return category;
    }

    @Override
    public Collection<Category> findAllCategorys() throws DataAccessException {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) throws DataAccessException {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Category category) throws DataAccessException {
        categoryRepository.delete(category);
    }

private UserRepository userRepository;

    @Override
    public User findUserById(int id) throws DataAccessException {
        User user= userRepository.findById(id);
        return user;
    }

    @Override
    public Collection<User> findAllUsers() throws DataAccessException {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) throws DataAccessException {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) throws DataAccessException {
        userRepository.delete(user);
    }

private TagRepository tagRepository;

    @Override
    public Tag findTagById(int id) throws DataAccessException {
        Tag tag= tagRepository.findById(id);
        return tag;
    }

    @Override
    public Collection<Tag> findAllTags() throws DataAccessException {
        return tagRepository.findAll();
    }

    @Override
    public void saveTag(Tag tag) throws DataAccessException {
        tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Tag tag) throws DataAccessException {
        tagRepository.delete(tag);
    }

private PetRepository petRepository;

    @Override
    public Pet findPetById(int id) throws DataAccessException {
        Pet pet= petRepository.findById(id);
        return pet;
    }

    @Override
    public Collection<Pet> findAllPets() throws DataAccessException {
        return petRepository.findAll();
    }

    @Override
    public void savePet(Pet pet) throws DataAccessException {
        petRepository.save(pet);
    }

    @Override
    public void deletePet(Pet pet) throws DataAccessException {
        petRepository.delete(pet);
    }






}
