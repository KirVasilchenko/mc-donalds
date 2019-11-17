package ru.rosbank.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.model.PotatoModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PotatoDetailsDto extends ProductDetailsDto {
    private int weightInG;

    public PotatoDetailsDto(int id, String name, int price, String description, int weightInG) {
        super(id, name, price, description);
        this.weightInG = weightInG;
    }

    @Override
    public PotatoModel fromDto() {
        return new PotatoModel(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getWeightInG()
        );
    }

}
