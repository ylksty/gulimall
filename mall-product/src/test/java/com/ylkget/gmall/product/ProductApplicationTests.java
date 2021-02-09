package com.ylkget.gmall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ylkget.gmall.product.entity.BrandEntity;
import com.ylkget.gmall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductApplicationTests {

	@Autowired
	BrandService brandService;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	RedissonClient redissonClient;

	@Test
	void contextLoads() {
	}

	@Test
	public void redisson(){
		System.out.println(redissonClient);

	}

	@Test
	public void teststringRedisTemplate(){
		/**
		 *
		 */
		//hello   world
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

		//保存
		ops.set("hello","world_"+ UUID.randomUUID().toString());

		//查询
		String hello = ops.get("hello");
		System.out.println("之前保存的数据是："+hello);

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
