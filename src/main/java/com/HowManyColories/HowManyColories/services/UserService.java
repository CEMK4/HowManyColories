package com.HowManyColories.HowManyColories.services;

import com.HowManyColories.HowManyColories.entities.DTOs.UserDto;
import com.HowManyColories.HowManyColories.entities.User;
import com.HowManyColories.HowManyColories.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MealService mealService;

    public UserDto getUser(Long userID)
    {
        return createUserDto(userRepository.findById(userID).get());
    }

    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setAge(userDto.getAge());
        user.setHeight(userDto.getHeight());
        user.setWeight(userDto.getWeight());
        user.setCaloriesConsumption(userDto.getCaloriesConsumption());
        user.setWaterConsumption(userDto.getWaterConsumption());

        User savedUser = userRepository.save(user);
        return convertToDto(savedUser);
    }

    public UserDto updateUser(Long userID, UserDto userDto) {
        var userOpt = userRepository.findById(userID);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setAge(userDto.getAge());
            user.setHeight(userDto.getHeight());
            user.setWeight(userDto.getWeight());
            user.setCaloriesConsumption(userDto.getCaloriesConsumption());
            user.setWaterConsumption(userDto.getWaterConsumption());

            User updatedUser = userRepository.save(user);
            return convertToDto(updatedUser);
        }
        return null; // Handle not found
    }

    private UserDto convertToDto(User user) {
        return new UserDto(
                user.getAge(),
                user.getHeight(),
                user.getWeight(),
                user.getMeals(),
                user.getCaloriesConsumption(),
                user.getWaterConsumption()
        );
    }

    public void deleteUser(Long userID)
    {
        userRepository.delete(userRepository.findById(userID).get());
    }

    public UserDto createUserDto(User user)
    {
        var meals = user.getMeals().stream().map(mealService::createMealDto).collect(Collectors.toSet());
        return new UserDto(user.getAge(), user.getHeight(), user.getWeight(), meals, user.getCaloriesConsumption(), user.getWaterConsumption());
    }
}
