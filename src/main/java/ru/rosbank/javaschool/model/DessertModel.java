package ru.rosbank.javaschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.dto.DessertDetailsDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DessertModel extends ProductModel {
    private String syrup;

    public DessertModel(int id, String name, int price, String description, String syrup) {
        super(id, name, price, description);
        this.syrup = syrup;
    }

    @Override
    public DessertDetailsDto toDto() {
        return new DessertDetailsDto(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getSyrup()
        );
    }
}