package services;

import java.util.List;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class Arquisoft21Crawler extends WebCrawler{
	
	private final static Pattern filter = Pattern.compile(".*(\\.(csv|html))$");
	
	public Arquisoft21Crawler(){
		System.out.println("Creating the crawler");
	}
	
	@Override
	public boolean shouldVisit(WebURL url){
		System.out.println("I'm sh");
		String href = url.getURL().toLowerCase();
		return !filter.matcher(href).matches();
	}
	
	@Override
	public void visit(Page page){
		
		String url = page.getWebURL().getURL();
		System.out.println(url);
		
		if(page.getParseData() instanceof HtmlParseData){
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			String text = htmlParseData.getText();
			String html = htmlParseData.getHtml();
			
			List<WebURL> links = htmlParseData.getOutgoingUrls();
			
			
		}
	}

}
