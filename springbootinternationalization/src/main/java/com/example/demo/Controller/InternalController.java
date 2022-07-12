package com.example.demo.Controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class InternalController {
	
	@Autowired
	private ResourceBundleMessageSource bundleMessageSource;
	
	@GetMapping("/locale1")
	public String locale(Model model,HttpServletRequest request)
	{
		
		model.addAttribute("page title", request);
		
		Locale currentLocale=request.getLocale();
		String countryCode=currentLocale.getCountry();
		String countryName=currentLocale.getDisplayCountry();
		
		String langCode=currentLocale.getLanguage();
		String langName=currentLocale.getDisplayLanguage();
		System.out.println(countryCode+":"+countryName);
		System.out.println(langCode+":"+langName);
		
		System.out.println("============");
		String[] languages=Locale.getISOLanguages();
		
		for(String lang:languages)
		{
			Locale locale=new Locale(lang);
			System.out.println(lang+":"+locale.getDisplayLanguage());
		}
		return "locale";
	}
	
	

}
