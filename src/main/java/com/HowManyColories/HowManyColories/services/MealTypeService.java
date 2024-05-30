package com.HowManyColories.HowManyColories.services;

import com.HowManyColories.HowManyColories.entities.DTOs.MealTypeDto;
import com.HowManyColories.HowManyColories.entities.MealType;
import com.HowManyColories.HowManyColories.repositories.MealTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MealTypeService {
    private final MealTypeRepository mealTypeRepository;

    public List<MealTypeDto> getAllMealTypes() {
        List<MealType> mealTypes = mealTypeRepository.findAll();
        return mealTypes.stream()
                .map(mealType -> new MealTypeDto( mealType.getTitle()))
                .collect(Collectors.toList());
    }

    public MealTypeDto getMealType(Long mealID) {
        Optional<MealType> mealTypeOpt = mealTypeRepository.findById(mealID);
        if (mealTypeOpt.isPresent()) {
            MealType mealType = mealTypeOpt.get();
            return new MealTypeDto(mealType.getTitle());
        }
        return null;
    }

    public void deleteMealType(Long mealID) {
        mealTypeRepository.deleteById(mealID);
    }

    public MealTypeDto createMealType(Long userID, String mealTypeTitle) {
        MealType mealType = new MealType();
        mealType.setTitle(mealTypeTitle);
        mealType = mealTypeRepository.save(mealType);
        return new MealTypeDto(mealType.getTitle());
    }
}
