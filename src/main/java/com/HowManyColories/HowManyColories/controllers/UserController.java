package com.HowManyColories.HowManyColories.controllers;

import com.HowManyColories.HowManyColories.entities.DTOs.UsedProductDto;
import com.HowManyColories.HowManyColories.entities.DTOs.UserDto;
import com.HowManyColories.HowManyColories.services.UsedProductService;
import com.HowManyColories.HowManyColories.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userID}")
    public ResponseEntity<?> getUsedProduct(@PathVariable Long userID)
    {
        return ResponseEntity.ok(userService.getUser(userID));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUsedProduct(@RequestBody UserDto userDto)
    {
        UserDto createdUserDto= userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{userID}/update")
    public ResponseEntity<?> updateUsedProduct(@PathVariable Long userID,
                                               @RequestBody UserDto userDto)
    {
        UserDto updatedUserDto = userService.updateUser(userID, userDto);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userID}/delete")
    public ResponseEntity<?> deleteUsedProduct(@PathVariable Long userID)
    {
        userService.deleteUser(userID);
        return ResponseEntity.ok().body("");
    }
}
