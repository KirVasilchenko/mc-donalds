package ru.rosbank.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.model.DessertModel;
import ru.rosbank.javaschool.model.DrinkModel;
import ru.rosbank.javaschool.model.PotatoModel;
import ru.rosbank.javaschool.model.ProductModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DessertDetailsDto extends ProductDetailsDto {
    private String syrup;

    public DessertDetailsDto(int id, String name, int price, String description, String syrup) {
        super(id, name, price, description);
        this.syrup = syrup;
    }

    public static DessertDetailsDto from(DessertModel model) {
        return new DessertDetailsDto(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getDescription(),
                model.getSyrup()
        );
    }

    @Override
    public DessertModel fromDto() {
        return new DessertModel(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getSyrup()
        );
    }
}
