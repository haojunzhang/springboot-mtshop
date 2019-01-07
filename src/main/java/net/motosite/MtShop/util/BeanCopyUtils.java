package net.motosite.MtShop.util;

import net.motosite.MtShop.entity.Manufacturer;
import net.motosite.MtShop.model.ManufacturerDTO;
import org.modelmapper.ModelMapper;

public class BeanCopyUtils {

    private BeanCopyUtils() {

    }


    public static Manufacturer toManufacturerEntity(ManufacturerDTO dto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(dto, Manufacturer.class);
    }

    public static ManufacturerDTO toManufacturerDTO(Manufacturer Manufacturer) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(Manufacturer, ManufacturerDTO.class);
    }


}
