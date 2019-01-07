package net.motosite.MtShop.controller;

import net.motosite.MtShop.entity.Manufacturer;
import net.motosite.MtShop.model.ManufacturerDTO;
import net.motosite.MtShop.model.ServiceResponse;
import net.motosite.MtShop.repository.ManufacturerCrudRepository;
import net.motosite.MtShop.util.BeanCopyUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/manufacturers")
public class ManufacturerController {

    private final ManufacturerCrudRepository repository;

    public ManufacturerController(ManufacturerCrudRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin()
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ServiceResponse<List<ManufacturerDTO>> all() {
        List<ManufacturerDTO> list = new ArrayList<>();
        for (Manufacturer item : repository.findAll()) {
            list.add(BeanCopyUtils.toManufacturerDTO(item));
        }
        return new ServiceResponse<>(list);
    }

    @RequestMapping(value = "/{manufacturerId}", method = RequestMethod.GET)
    public ServiceResponse<ManufacturerDTO> findManufacturerById(@PathVariable(value = "manufacturerId") Long id) {
        return repository.findById(id)
                .map(manufacturer -> new ServiceResponse<>(BeanCopyUtils.toManufacturerDTO(manufacturer)))
                .orElseGet(() -> new ServiceResponse<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ServiceResponse<ManufacturerDTO> createManufacturer(@RequestBody ManufacturerDTO manufacturerDTO,
                                                               HttpServletRequest request) {
        Manufacturer manufacturer = BeanCopyUtils.toManufacturerEntity(manufacturerDTO);
        Manufacturer createdManufacturer = repository.save(manufacturer);
        return new ServiceResponse<>(BeanCopyUtils.toManufacturerDTO(createdManufacturer));
    }

    @RequestMapping(value = "/{manufacturerId}", method = RequestMethod.DELETE)
    public ServiceResponse<Void> deletePostById(@PathVariable(value = "manufacturerId") Long id) {
        repository.deleteById(id);
        return new ServiceResponse<>(HttpStatus.OK);
    }
}
