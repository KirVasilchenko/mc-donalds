package ru.rosbank.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.model.BurgerModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BurgerDetailsDto extends ProductDetailsDto {
    private String cutletMeat;
    private int cutletCount;

    public BurgerDetailsDto(int id, String name, int price, String description, String cutletMeat, int cutletCount) {
        super(id, name, price, description);
        this.cutletMeat = cutletMeat;
        this.cutletCount = cutletCount;
    }

    @Override
    public BurgerModel fromDto() {
        return new BurgerModel(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getCutletMeat(),
                this.getCutletCount()
        );
    }

}
