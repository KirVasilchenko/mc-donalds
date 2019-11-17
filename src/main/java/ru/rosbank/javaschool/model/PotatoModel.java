package ru.rosbank.javaschool.model;

import lombok.Getter;
import lombok.Setter;
import ru.rosbank.javaschool.dto.PotatoDetailsDto;


@Getter
@Setter
public class PotatoModel extends ProductModel {
        private int weightInG;

        public PotatoModel(int id, String name, int price, String description, int weightInG) {
                super(id, name, price, description);
                this.weightInG = weightInG;
        }

        @Override
        public PotatoDetailsDto toDto() {
                return new PotatoDetailsDto(
                        this.getId(),
                        this.getName(),
                        this.getPrice(),
                        this.getDescription(),
                        this.getWeightInG()
                );
        }
}


