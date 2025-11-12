package com.udemy.spring2item;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.udemy.spring2item.Controller.ItemController;
import com.udemy.spring2item.service.ItemService;

@SpringBootTest
class Spring2itemApplicationTests {
	
	@Autowired
	private ItemController itemController;
	
	@Autowired
	private ItemService itemService;
	

	// アプリケーションがspringコンテキストを正常にロードするか
	@Test
	void contextLoads() {
		// AssertJを利用した検証
		// Asserthanの引数に検証の値を入れる
		// 続けてメソッドにて期待値を指定。この場合はNull出ないこと
		assertThat(itemController).isNotNull();
		assertThat(itemService).isNotNull();
	}

}
