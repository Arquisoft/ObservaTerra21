package services;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class CrawlerController {
	
	public static void main(String [] args) throws Exception{
		String crawlerStorageFolder = "/data/crawler";
		int numCrawlers = 1;
		
		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(crawlerStorageFolder);
		
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotsTXTConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtserver = new RobotstxtServer(robotsTXTConfig, pageFetcher);
		
		CrawlController controller = new CrawlController(config, pageFetcher, robotstxtserver);
		
		controller.addSeed("www.google.com");
		
		controller.start(Arquisoft21Crawler.class, numCrawlers);
		
	}

}
