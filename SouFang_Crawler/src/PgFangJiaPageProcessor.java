import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import java.util.*;

/**
 * Created by ybdx on 16/9/21.
 * 处理查房价页面
 */
public class PgFangJiaPageProcessor implements PageProcessor {

    private  Site site = Site.me().setDomain("fangjia.fang.com").addStartUrl("http://fangjia.fang.com/");
    Set<String> setLinks = new HashSet<>();
    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().xpath("//div[@class='city20141104nr']").regex("href=\"(.*?)\"").all();
        for(String s : links)
        {
            setLinks.add(s);
        }

        for(String url : setLinks)
        {

        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public Set<String> getSetLinks(Set<String> setLinks)
    {
        return setLinks;
    }

    public static void main(String[] args)
    {
        Spider.create(new PgFangJiaPageProcessor()).pipeline(new ConsolePipeline()).run();
    }
}
