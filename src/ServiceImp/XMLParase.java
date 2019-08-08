package ServiceImp;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLParase {


    public static void main(String[] args) {

        DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
        DocumentBuilder db= null;
        try {
            db = dbf.newDocumentBuilder();
            Document doc=db.parse("src/ServiceImp/scores.xml");
            NodeList list=doc.getChildNodes();

            NodeList onelist=list.item(0).getChildNodes();
            for(int i=0;i<onelist.getLength();i++){
                if(onelist.item(i).getNodeName().equals("student")){
                    System.out.println(onelist.item(i).getNodeName()+" id:"+onelist.item(i).getAttributes().item(0).getTextContent());
                    NodeList twolist=onelist.item(i).getChildNodes();
                    for(int j=0;j<twolist.getLength();j++){
                        if(twolist.item(j).getNodeName().equals("name")){
                            System.out.println(twolist.item(j).getNodeName()+":"+twolist.item(j).getTextContent());
                        }else if(twolist.item(j).getNodeName().equals("score")){
                            System.out.println(twolist.item(j).getNodeName()+":"+twolist.item(j).getTextContent());
                        }else if(twolist.item(j).getNodeName().equals("course")){
                            System.out.println(twolist.item(j).getNodeName()+":"+twolist.item(j).getTextContent());
                        }
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
