package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.demo.mapper.entity.Fruit;
import com.example.demo.mapper.FruitMapper;

@Controller
public class FruitController {

	@Autowired
	FruitMapper fruitMapper;

	@RequestMapping(value = "/fruits/list")
	public String index(Model model) {
 		System.out.println("Enter index");
		
		List<Fruit> list = fruitMapper.selectAll();
		model.addAttribute("fruits", list);
		return "fruits";
	}

	@Transactional
	@PostMapping("/fruits/insert")
	public String insert(Model model, @RequestParam("name") String name) {

 		System.out.println("Enter insert");
 		System.out.println("name is" + name);
		
		fruitMapper.insert(name);
 		System.out.println("after insert");

		List<Fruit> list = fruitMapper.selectAll();
		model.addAttribute("fruits", list);

		System.out.println("after selectAll");
		return "fruits";
		
	}

	@Transactional
	@PostMapping("/fruits/update")
	public String update(Model model, @RequestParam("chg_before_name") String before_name,
			@RequestParam("chg_after_name") String after_name) throws Exception {

 		System.out.println("Enter update");
		fruitMapper.update(before_name, after_name);
 		System.out.println("after update");

		List<Fruit> list = fruitMapper.selectAll();
		model.addAttribute("fruits", list);

		// トランザクション動作確認		
		if(after_name.equals("非検査例外")) {
			//	非検査例外の時にはロールバックが発生します。		
			System.out.println("非検査例外発生");
			throw new RuntimeException(); 
		}
		if(after_name.equals("検査例外")) {
			// 検査例外の時にはそのままコミットされます。			
			System.out.println("検査例外発生");
			throw new Exception();
		}
		return "fruits";
	}

	// 例外キャッチ
	@ControllerAdvice 
	public class ExceptionHandlerAdvisor {
	     @ExceptionHandler
	     public String catchError(RuntimeException e){
	 		System.out.println("非検査例外キャッチ");
	     	 e.printStackTrace(); 
	 		return "error";
	     }
	     @ExceptionHandler
	     public String catchError(Exception e){
	 		System.out.println("検査例外キャッチ");
	     	 e.printStackTrace(); 
	 		return "error";
	     }
	}
	
	@PostMapping ("/fruits/delete")
	public String delete(Model model, @RequestParam("del_name") String name) {
 		System.out.println("Enter delete");
		fruitMapper.delete(name);
 		System.out.println("after delete");
		List<Fruit> list = fruitMapper.selectAll();
		model.addAttribute("fruits", list);

		return "fruits";

	}
}