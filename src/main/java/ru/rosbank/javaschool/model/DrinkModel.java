package ru.rosbank.javaschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.dto.DrinkDetailsDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkModel extends ProductModel {
    private int volumeInMl;

    public DrinkModel(int id, String name, int price, String description, int volumeInMl) {
        super(id, name, price, description);
        this.volumeInMl = volumeInMl;
    }

    @Override
    public DrinkDetailsDto toDto() {
        return new DrinkDetailsDto(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getVolumeInMl()
        );
    }
}