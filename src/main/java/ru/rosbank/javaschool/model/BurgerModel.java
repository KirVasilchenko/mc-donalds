package ru.rosbank.javaschool.model;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import ru.rosbank.javaschool.dto.BurgerDetailsDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BurgerModel extends ProductModel {
    private String cutletMeat;
    private int cutletCount;

    public BurgerModel(int id, String name, int price, String description, String cutletMeat, int cutletCount) {
        super(id, name, price, description);
        this.cutletMeat = cutletMeat;
        this.cutletCount = cutletCount;
    }

    @Override
    public BurgerDetailsDto toDto() {
        return new BurgerDetailsDto(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getDescription(),
                this.getCutletMeat(),
                this.getCutletCount()
        );
    }
}
