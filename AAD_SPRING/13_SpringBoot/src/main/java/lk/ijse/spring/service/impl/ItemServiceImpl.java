package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveItem(ItemDTO dto) {
        if (!itemRepo.existsById(dto.getCode())) {
            itemRepo.save(mapper.map(dto, Item.class));
        } else {
            throw new RuntimeException("Item Already Exist.!");
        }
    }

    @Override
    public void deleteItem(String code) {
        if (itemRepo.existsById(code)) {
            itemRepo.deleteById(code);
        } else {
            throw new RuntimeException("Delete Failed, No Item Available For " + code);
        }
    }

    @Override
    public void updateItem(ItemDTO dto) {
        if (itemRepo.existsById(dto.getCode())) {
            itemRepo.save(mapper.map(dto, Item.class));
        } else {
            throw new RuntimeException("Update Failed, No Item Available For " + dto.getCode());
        }
    }

    @Override
    public ItemDTO searchItem(String code) {
        if (itemRepo.existsById(code)) {
            return mapper.map(itemRepo.findById(code), ItemDTO.class);
        } else {
            throw new RuntimeException("Search Failed, No Item Available For " + code);
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapper.map(itemRepo.findAll(), new TypeToken<List<ItemDTO>>() {
        }.getType());
    }
}
