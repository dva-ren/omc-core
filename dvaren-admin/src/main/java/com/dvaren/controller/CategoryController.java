package com.dvaren.controller;

import com.dvaren.config.ApiException;
import com.dvaren.domain.entity.Category;
import com.dvaren.service.ICategoryService;
import com.dvaren.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private ICategoryService ICategoryService;

    @GetMapping("")
    public ResponseResult<List<Category>> list(){
        return ResponseResult.ok(ICategoryService.queryCategoryList());
    }

    @GetMapping("/{id}")
    public ResponseResult<Category> queryCategory(@PathVariable String id) throws ApiException {
        return ResponseResult.ok(ICategoryService.queryCategory(id));
    }

    @PostMapping("")
    public ResponseResult<Category> Category(@RequestBody Category category) throws ApiException {
        ICategoryService.addCategory(category);
        return ResponseResult.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseResult deleteCategory(@PathVariable("id") String id) throws ApiException {
        ICategoryService.deleteCategory(id);
        return ResponseResult.ok();
    }

    @PostMapping("/{id}")
    public ResponseResult<Category> Category(@PathVariable("id") String id,@RequestBody Category category) throws ApiException {
        category.setId(id);
        ICategoryService.updateCategory(category);
        return ResponseResult.ok(category);
    }
}
