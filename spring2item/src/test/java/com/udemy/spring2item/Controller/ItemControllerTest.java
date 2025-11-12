package com.udemy.spring2item.Controller;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.spring2item.model.Item;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {
	
	@Autowired
	private MockMvc mvc;

	// 検索結果が想定通りであるかテスト
	@Test
	void testGetItem() throws Exception{
		int itemId = 10001;
		String responseJsonString = mvc.perform(get("/items/{itemId}", itemId)
									.contentType(MediaType.APPLICATION_JSON)
									.accept(MediaType.APPLICATION_JSON_UTF8_VALUE) //非推奨だが現時点で入れる。（文字化け対策）
									.characterEncoding("UTF-8"))
									.andExpect(status().isOk()) //ステータスコードチェック
									.andReturn().getResponse().getContentAsString();
		
		// 取得したJsonをJavaオブジェクトにマッピング
		ObjectMapper objectMapper = new ObjectMapper();
		Item responseItem = objectMapper.readValue(responseJsonString, Item.class);
		
		assertThat(responseItem.getItemId()).isEqualTo("10001");
		assertThat(responseItem.getItemName()).isEqualTo("ネックレス");
		assertThat(responseItem.getItemCategory()).isEqualTo("ジュエリー");
	}

}
