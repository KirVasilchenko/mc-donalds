package ru.rosbank.javaschool.model;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.EqualsAndHashCode;
        import lombok.NoArgsConstructor;
        import ru.rosbank.javaschool.dto.BurgerDetailsDto;
        import ru.rosbank.javaschool.dto.ProductDetailsDto;


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


//    @Override
//    public BurgerModel withId(int id) {
//
//        return new BurgerModel(
//                id,
//                name,
//                price,
//                description,
//                cutletMeat,
//                cutletCount
//        );
//    }

//    public static BurgerModel from(BurgerModel model) {
//        return new BurgerModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getDescription(),
//                model.getCutletMeat(),
//                model.getCutletCount()
//        );
//    }
//
//    public static BurgerModel from(BurgerDetailsDto dto) {
//        return new BurgerModel(
//                dto.getId(),
//                dto.getName(),
//                dto.getPrice(),
//                dto.getDescription(),
//                dto.getCutletMeat(),
//                dto.getCutletCount()
//        );
//    }
//
//    public BurgerModel(BurgerDetailsDto dto) {
//                id = dto.getId();
//                name = dto.getName();
//                price = dto.getPrice();
//                description = dto.getDescription();
//                cutletMeat = dto.getCutletMeat();
//                cutletCount = dto.getCutletCount();
//    }

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
