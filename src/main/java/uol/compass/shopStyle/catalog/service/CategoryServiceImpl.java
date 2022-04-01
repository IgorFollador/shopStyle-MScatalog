package uol.compass.shopStyle.catalog.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uol.compass.shopStyle.catalog.document.Category;
import uol.compass.shopStyle.catalog.dto.CategoryDTO;
import uol.compass.shopStyle.catalog.dto.CategoryFormDTO;
import uol.compass.shopStyle.catalog.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoryDTO save(CategoryFormDTO form) {
        Category categoryEntity = this.categoryRepository.save(mapper.map(form, Category.class));
        return mapper.map(categoryEntity, CategoryDTO.class);
    }

    @Override
    public Page<CategoryDTO> findAll(Pageable page) {
        Page<Category> category = this.categoryRepository.findAll(page);
        return category.map(CategoryDTO::new);
    }

    @Override
    public Optional<Category> findById(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category;
    }

    @Override
    public CategoryDTO update(Category category, CategoryFormDTO form) {
        if(form.getName() != null)category.setName(form.getName());
        if(form.getActive() != null)category.setActive(form.getActive());

        this.categoryRepository.save(category);
        return mapper.map(category, CategoryDTO.class);
    }

    @Override
    public void delete(Category category) {
        this.categoryRepository.delete(category);
    }
}
