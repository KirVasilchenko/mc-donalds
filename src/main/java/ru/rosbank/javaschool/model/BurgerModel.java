package ru.rosbank.javaschool.model;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.EqualsAndHashCode;
        import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BurgerModel extends ProductModel {
    private String cutletMeat;
    private int cutletCount;
}
