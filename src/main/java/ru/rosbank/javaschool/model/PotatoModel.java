package ru.rosbank.javaschool.model;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PotatoModel extends ProductModel {
        private int weightInG;
}