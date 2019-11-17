package ru.rosbank.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.model.DrinkModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkDetailsDto extends ProductDetailsDto {
    private int volumeInMl;

    public DrinkDetailsDto(int id, String name, int price, String description, int volumeInMl) {
        super(id, name, price, description);
        this.volumeInMl = volumeInMl;
    }

    @Override
    public DrinkModel fromDto() {
        return new DrinkModel(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getVolumeInMl()
        );
    }
}
