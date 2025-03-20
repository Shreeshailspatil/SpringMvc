package testyantra.boot_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControlTest {
	
	@GetMapping("/")
	public String loadmain() {
		return "main.html";
	}

	@GetMapping("/otp")
	public String otp(Model model) {
		int otp = new Random().nextInt(10000, 1000000);
		model.addAttribute("otp", otp);
		return "main.html";
	}
	@GetMapping("/message")
	public String printMessage(@RequestParam("message") String message,@RequestParam("color") String color, Model model ){
		model.addAttribute("message",message);
		model.addAttribute("color",color);
        return "main.html";
	}
	@GetMapping("/circle")
	public String printCircle(@RequestParam("size") int size, @RequestParam("color") String color, Model model ){
		model.addAttribute("size",size);
		model.addAttribute("color",color);
        return "main.html";
	}
	@GetMapping("/table")
	public String loadTable(@RequestParam ("num")int num,Model model) {
		List<String>table=new ArrayList();
		for (int i = 1; i <=10; i++) {
			table.add(num+"x"+i+"="+num*i);
		
		}
		model.addAttribute("table", table);
		return "main.html";
	}
	
}

