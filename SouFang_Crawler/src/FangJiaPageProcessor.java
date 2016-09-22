import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import java.util.*;

/**
 * Created by ybdx on 16/9/21.
 */
public class FangJiaPageProcessor implements PageProcessor{

//    private Site site = Site.me().setDomain("fangjia.fang.com").addStartUrl("http://fang.com/SoufunFamily.htm");
    private Site site = Site.me().setDomain("fangjia.fang.com").addStartUrl("http://fangjia.fang.com/");

    @Override
    public void process(Page page) {

//        List<String> links = page.getHtml().links().regex("https://my\\.oschina\\.net/flashsword/blog/\\d+").all();
//        List<String> links = page.getHtml().xpath("//div[@class='suoyin']/div[@class='gray6']/a").regex("href=\"(.*?)\"").all();
//        page.addTargetRequests(links);
        List<String> links = page.getHtml().xpath("//table[@id='senfe1']").regex("href=\"(.*?)\" .*?>.*?</a>").all();
        System.out.println(links.size());
        for (String s : page.getHtml().xpath("//div[@class='city20141104nr']").regex("href=\"(.*?)\"").all())
        {
            System.out.println(s);
        }
//        page.putField("abstract", page.getHtml().xpath("//div[@class='suoyin']/div[@class='gray6']/a").regex("href=\"(.*?)\"").all());
//        page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1").toString());
//        page.putField("content", page.getHtml().$("div.content").toString());
//        page.putField("tags",page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args)
    {
        Spider.create(new FangJiaPageProcessor()).pipeline(new ConsolePipeline()).run();
    }
}
