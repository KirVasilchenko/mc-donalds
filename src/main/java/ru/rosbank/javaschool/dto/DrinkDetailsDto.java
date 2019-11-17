package ru.rosbank.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.model.DrinkModel;
import ru.rosbank.javaschool.model.PotatoModel;
import ru.rosbank.javaschool.model.ProductModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkDetailsDto extends ProductDetailsDto {
    private int volumeInMl;

    public DrinkDetailsDto(int id, String name, int price, String description, int volumeInMl) {
        super(id, name, price, description);
        this.volumeInMl = volumeInMl;
    }

    public static DrinkDetailsDto from(DrinkModel model) {
        return new DrinkDetailsDto(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getDescription(),
                model.getVolumeInMl()
        );
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
