package com.ylkget.gmall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ylkget.gmall.product.entity.BrandEntity;
import com.ylkget.gmall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductApplicationTests {

	@Autowired
	BrandService brandService;

	@Test
	void contextLoads() {
	}

	@Test
	void testBrand() {
		BrandEntity brandEntity = new BrandEntity();
		// 增
//		brandEntity.setName("joe");
//		brandService.save(brandEntity);

		// 改
//		brandEntity.setBrandId(1L);
//		brandEntity.setLogo("华为");
//		brandService.updateById(brandEntity);

		// 查
		brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L)).forEach(System.out::println);

		System.out.println("操作完成");
	}
}
