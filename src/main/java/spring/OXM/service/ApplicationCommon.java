package spring.OXM.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.OXM.model.SimpleBean;

import javax.annotation.Resource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by bf50 on 2015/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/Bean_oxm.xml")
public class ApplicationCommon {
    private String FILE_NAME = "simpleBean.xml";
//    private Settings settings = new Settings();
    private SimpleBean simpleBean = new SimpleBean();

    @Resource(name = "castorMarshaller")
    private Marshaller marshaller;
    @Resource(name = "castorMarshaller")
    private Unmarshaller unmarshaller;

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void saveSettings() throws IOException {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(FILE_NAME);
            this.marshaller.marshal(simpleBean, new StreamResult(os));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null)
                os.close();
        }
    }

    public void loadingSettings() throws IOException {
        FileInputStream is = null;
        try {
            is = new FileInputStream(FILE_NAME);
            this.simpleBean = (SimpleBean) this.unmarshaller.unmarshal(new StreamSource(is));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is != null)
                is.close();
        }
    }

    @Test
    public void testMarshaller() throws IOException {
        simpleBean.setAge(35);
        simpleBean.setExecutive(false);
        simpleBean.setJobDescription("Janitor");
        simpleBean.setName("Mister Jones");
        saveSettings();
        loadingSettings();
    }
}
