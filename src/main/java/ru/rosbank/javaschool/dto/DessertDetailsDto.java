package ru.rosbank.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.model.DessertModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DessertDetailsDto extends ProductDetailsDto {
    private String syrup;

    public DessertDetailsDto(int id, String name, int price, String description, String syrup) {
        super(id, name, price, description);
        this.syrup = syrup;
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
