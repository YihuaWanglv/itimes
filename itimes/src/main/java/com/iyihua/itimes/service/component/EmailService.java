package com.iyihua.itimes.service.component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Component
public class EmailService {

	@Autowired
    Configuration configuration;
	
	public String initHtml() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		
		// prepare data
        Map<String, String> data = new HashMap<>();
        data.put("name", "Max Mustermann");
        
		// get template
        Template t = configuration.getTemplate("test.html");
        
        String readyParsedTemplate = FreeMarkerTemplateUtils
                .processTemplateIntoString(t, data);
        
        return readyParsedTemplate;
        
	}
}
